package ee.taltech.unity.service;

import ee.taltech.unity.service.alpha.DailyResponse;
import ee.taltech.unity.service.alpha.DataPoint;
import ee.taltech.unity.service.alpha.Metadata;
import ee.taltech.unity.service.classes.Meta;
import ee.taltech.unity.service.classes.Polarity;
import ee.taltech.unity.service.classes.Response;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class FinanceCalculator {
    // TODO: Test
    public Response getNegPosDays(DailyResponse dailyResponse) {
        if (dailyResponse == null || dailyResponse.getError() != null) {
            Response errorResponse = new Response();
            errorResponse.setError("Invalid API call. Check documentation.");
            return errorResponse;
        }
        Meta resultMetaData = new Meta();
        Metadata dailyMetaData = dailyResponse.getMetadata();

        resultMetaData.setSymbol(dailyMetaData.getSymbol());
        resultMetaData.setTimeZone(dailyMetaData.getTimeZone());

        Response result = new Response();
        result.setMetaData(resultMetaData);

        Polarity listResult = getResults(dailyResponse.getData());

        result.setPolarity(listResult);
        return result;
    }
    // TODO: Test
    public Polarity getResults(Map<LocalDate, DataPoint> data) {
        Polarity result = new Polarity();

        List<LocalDate> positiveList = new ArrayList<>();
        List<LocalDate> negativeList = new ArrayList<>();
        List<LocalDate> equalList = new ArrayList<>();

        for (LocalDate date : data.keySet()) {

            var dataNumbers = data.get(date);

            //check null values
            if(dataNumbers.getOpen() == null || dataNumbers.getClose() == null)
            {
                continue;
            }

            //check if they are numeric
            var isOpeningParsable = isParsable(dataNumbers.getOpen().toString());
            var isClosingParsable = isParsable(dataNumbers.getClose().toString());

            if(isOpeningParsable && isClosingParsable)
            {
                BigDecimal open = data.get(date).getOpen();
                BigDecimal close = data.get(date).getClose();
                int comparison = close.compareTo(open);
                if (comparison > 0) {
                    result.setPositiveDays(result.getPositiveDays() + 1);
                    positiveList.add(date);
                } else if (comparison < 0) {
                    result.setNegativeDays(result.getNegativeDays() + 1);
                    negativeList.add(date);
                } else {
                    result.setEqualDays(result.getEqualDays() + 1);
                    equalList.add(date);
                }
            }

        }
        result.setEqualDaysList(result.getEqualDays() == 0 ? null : equalList);
        result.setNegativeDaysList(result.getNegativeDays() == 0 ? null : negativeList);
        result.setPositiveDaysList(result.getPositiveDays() == 0 ? null : positiveList);

        return result;
    }

    public static boolean isParsable(final String str) {
             if (StringUtils.isEmpty(str)) {
                       return false;
             }
             if (str.charAt(str.length() - 1) == '.') {
                    return false;
             }
               if (str.charAt(0) == '-') {
                      if (str.length() == 1) {
                              return false;
                      }
                      return withDecimalsParsing(str, 1);
               }
               return withDecimalsParsing(str, 0);
    }

    private static boolean withDecimalsParsing(final String str, final int beginIdx) {
        int decimalPoints = 0;
        for (int i = beginIdx; i < str.length(); i++) {
            final boolean isDecimalPoint = str.charAt(i) == '.';
            if (isDecimalPoint) {
                decimalPoints++;
            }
            if (decimalPoints > 1) {
                return false;
            }
            if (!isDecimalPoint && !Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

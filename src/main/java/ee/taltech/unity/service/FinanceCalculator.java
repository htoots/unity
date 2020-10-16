package ee.taltech.unity.service;

import ee.taltech.unity.service.alpha.DailyResponse;
import ee.taltech.unity.service.alpha.DataPoint;
import ee.taltech.unity.service.alpha.Metadata;
import ee.taltech.unity.service.classes.Meta;
import ee.taltech.unity.service.classes.Polarity;
import ee.taltech.unity.service.classes.ResultData;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

// Change this to return daily full response
@Service
public class FinanceCalculator {

    public ResultData getNegPosDays(DailyResponse dailyResponse) {
        if (dailyResponse == null) {
            return new ResultData();
        }
        Meta resultMetaData = new Meta();
        Metadata dailyMetaData = dailyResponse.getMetadata();

        resultMetaData.setSymbol(dailyMetaData.getSymbol());
        resultMetaData.setTimeZone(dailyMetaData.getTimeZone());

        ResultData result = new ResultData();
        result.setMetaData(resultMetaData);

        Polarity listResult = getResults(dailyResponse.getData());

        result.setPolarity(listResult);
        return result;
    }

    static Polarity getResults(Map<LocalDate, DataPoint> data) {
        Polarity result = new Polarity();

        List<LocalDate> positiveList = new ArrayList<>();
        List<LocalDate> negativeList = new ArrayList<>();
        List<LocalDate> equalList = new ArrayList<>();

        for (LocalDate date : data.keySet()) {
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
        result.setEqualDaysList(equalList);
        result.setNegativeDaysList(negativeList);
        result.setPositiveDaysList(positiveList);

        return result;
    }
}

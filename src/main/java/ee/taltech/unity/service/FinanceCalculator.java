package ee.taltech.unity.service;

import ee.taltech.unity.service.alpha.DailyResponse;
import ee.taltech.unity.service.alpha.DataPoint;
import ee.taltech.unity.service.alpha.Metadata;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// Change this to return daily full response
@Service
public class FinanceCalculator {

    public Optional<HashMap<LocalDate, FinanceResponse>> getLatestQuote(DailyResponse dailyResponse) {
        if (dailyResponse == null) {
            return Optional.empty();
        }
        FinanceResponse financeResponse = new FinanceResponse();
        Optional<HashMap<LocalDate, FinanceResponse>> result = calc(dailyResponse.getData());
//        Optional<Map.Entry<LocalDate, DataPoint>> lastEntryOp = getLastEntry(dailyResponse.getData());
//        if (lastEntryOp.isPresent()) {
//            Map.Entry<LocalDate, DataPoint> maxEntry = lastEntryOp.get();
//            financeResponse.setDate(maxEntry.getKey());
//            financeResponse.setPrice(maxEntry.getValue().getClose());
//        }
        return result;
    }

    private String getSymbol(Metadata metadata) {
        return metadata != null ? metadata.getSymbol() : "no symbol";
    }

    static Optional<HashMap<LocalDate, FinanceResponse>> calc(Map<LocalDate, DataPoint> data) {
        if (data == null) return Optional.empty();

        HashMap<LocalDate, FinanceResponse> newData = new HashMap<>();

        for (LocalDate date : data.keySet()) {
            FinanceResponse values = new FinanceResponse();
            BigDecimal open = data.get(date).getOpen();
            BigDecimal close = data.get(date).getClose();
            int comparison = open.compareTo(close);

            values.setOpen(open);
            values.setClose(close);
            values.setComparison(comparison);

            newData.put(date, values);
        }
        for(LocalDate date : newData.keySet()) {
            System.out.println(newData.get(date));
        }
        Optional returnData = Optional.of(newData);
        return returnData;
//        return data.entrySet().stream().max(Map.Entry.comparingByKey());
    }
}

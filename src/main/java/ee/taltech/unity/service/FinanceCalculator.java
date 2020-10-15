package ee.taltech.unity.service;

import ee.taltech.unity.service.alpha.DailyResponse;
import ee.taltech.unity.service.alpha.DataPoint;
import ee.taltech.unity.service.alpha.Metadata;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

// Change this to return daily full response
@Service
public class FinanceCalculator {

    public FinanceResponse getLatestQuote(DailyResponse dailyResponse) {
        if (dailyResponse == null) {
            return new FinanceResponse();
        }
        FinanceResponse financeResponse = new FinanceResponse();
        financeResponse.setSymbol(getSymbol(dailyResponse.getMetadata()));
        Optional<Map.Entry<LocalDate, DataPoint>> lastEntryOp = getLastEntry(dailyResponse.getData());
        if (lastEntryOp.isPresent()) {
            Map.Entry<LocalDate, DataPoint> maxEntry = lastEntryOp.get();
            financeResponse.setDate(maxEntry.getKey());
            financeResponse.setPrice(maxEntry.getValue().getClose());
        }
        return financeResponse;
    }

    private String getSymbol(Metadata metadata) {
        return metadata != null ? metadata.getSymbol() : "no symbol";
    }

    static Optional<Map.Entry<LocalDate, DataPoint>> getLastEntry(Map<LocalDate, DataPoint> data) {
        if (data == null) return Optional.empty();
        return data.entrySet().stream().max(Map.Entry.comparingByKey());
    }
}

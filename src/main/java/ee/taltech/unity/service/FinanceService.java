package ee.taltech.unity.service;

import ee.taltech.unity.service.alpha.DailyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

@Service
public class FinanceService {

    @Autowired
    private AlphaVantageApi alphaVantageApi;
    @Autowired
    private FinanceCalculator financeCalculator;

    public Optional<HashMap<LocalDate, FinanceResponse>> queryForData(String symbol) {
        DailyResponse dailyResponse = alphaVantageApi.queryForDaily(symbol);
        return financeCalculator.getLatestQuote(dailyResponse);
    }
}

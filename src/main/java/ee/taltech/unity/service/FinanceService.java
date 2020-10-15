package ee.taltech.unity.service;

import ee.taltech.unity.service.alpha.DailyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {

    @Autowired
    private AlphaVantageApi alphaVantageApi;
    @Autowired
    private FinanceCalculator financeCalculator;

    public FinanceResponse queryForData(String symbol) {
        DailyResponse dailyResponse = alphaVantageApi.queryForDaily(symbol);
        return financeCalculator.getLatestQuote(dailyResponse);
    }
}

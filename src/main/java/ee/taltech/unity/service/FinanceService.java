package ee.taltech.unity.service;

import ee.taltech.unity.service.alpha.DailyResponse;
import ee.taltech.unity.service.classes.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {

    @Autowired
    private AlphaVantageApi alphaVantageApi;
    @Autowired
    private FinanceCalculator financeCalculator;
    // TODO: Test
    public Response queryForData(String symbol) {
        DailyResponse dailyResponse = alphaVantageApi.queryForDaily(symbol);
        return financeCalculator.getNegPosDays(dailyResponse);
    }
}

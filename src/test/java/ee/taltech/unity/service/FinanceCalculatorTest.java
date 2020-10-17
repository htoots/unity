package ee.taltech.unity.service;

import ee.taltech.unity.service.alpha.DailyResponse;
import ee.taltech.unity.service.alpha.DataPoint;
import ee.taltech.unity.service.alpha.Metadata;
import ee.taltech.unity.service.classes.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FinanceCalculatorTest {

    private FinanceCalculator testCalculator = new FinanceCalculator();

    @Test
    void getNegPosDays_returns_error_on_null() {
        Response testResponse = testCalculator.getNegPosDays(null);
        assertEquals("Invalid API call. Check documentation.", testResponse.getError(), "Invalid result on null dailyResponse.");
    }

    @Test
    void getNegPosDays_returns_error_on_error() {
        DailyResponse errorResponse = new DailyResponse();
        errorResponse.setError("testError");
        Response testResponse = testCalculator.getNegPosDays(errorResponse);
        assertEquals("Invalid API call. Check documentation.", testResponse.getError(), "Invalid result on error dailyResponse.");
    }

    @Test
    void getNegPosDays_returns_result_correctly() {
        DailyResponse mockResponse = new DailyResponse();
        Metadata mockMetaData = new Metadata();
        DataPoint mockDataPoint = new DataPoint();
        Map<LocalDate, DataPoint> mockData = new HashMap<>();

        mockMetaData.setInformation("test information");
        mockMetaData.setOutputSize("test outputsize");
        mockMetaData.setSymbol("test symbol");
        mockMetaData.setRefreshed("test refreshed");
        mockMetaData.setTimeZone("test timezone");

        mockResponse.setMetadata(mockMetaData);

        mockDataPoint.setClose(new BigDecimal(140.021));
        mockDataPoint.setHigh(new BigDecimal(140.902));
        mockDataPoint.setLow(new BigDecimal(140.021));
        mockDataPoint.setOpen(new BigDecimal(140.084));
        mockDataPoint.setVolume(new BigDecimal(4714320));

        mockData.put(LocalDate.now(), mockDataPoint);

        mockResponse.setData(mockData);

        Response testResult = testCalculator.getNegPosDays(mockResponse);

        assertEquals(null, testResult.getError(), "Error is not null");
        assertEquals(1, testResult.getPolarity().getNegativeDays(), "Invalid day calculation");
        assertEquals(true, testResult.getPolarity().getNegativeDaysList().contains(LocalDate.now()), "Localdate is at the wrong spot");
        assertEquals("test symbol", testResult.getMetaData().getSymbol(), "Invalid symbol");
        assertEquals("test timezone", testResult.getMetaData().getTimeZone(), "Invalid timezone");
    }

}
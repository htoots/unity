package ee.taltech.unity.controller;

import ee.taltech.unity.service.AlphaVantageApi;
import ee.taltech.unity.service.alpha.DailyResponse;
import ee.taltech.unity.service.alpha.DataPoint;
import ee.taltech.unity.service.alpha.Metadata;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FinanceControllerMockMvc2Test {

    @Autowired
    private MockMvc mvc;

    @SpyBean
    private AlphaVantageApi alphaVantage;

    @Test
//    @DisplayName("name of the test")
    void financeController_returns_IBMquote() throws Exception {
        mvc.perform(get("/finance").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.symbol").value("IBM"))
                .andExpect(jsonPath("$.date").exists())
                .andExpect(jsonPath("$.price").exists());
    }

    @Test
    void financeController_returns_AAPL_quote() throws Exception {
        //todo but you need to mock alphaVantageApi
        DailyResponse response = new DailyResponse();
        response.setMetadata(metadata());
        response.setData(data());
        Mockito.when(alphaVantage.queryForDaily(Mockito.anyString())).thenReturn(response);
        mvc.perform(get("/finance?symbol=AAPL").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.symbol").value("AAPL"))
                .andExpect(jsonPath("$.date").value(LocalDate.now().toString()))
                .andExpect(jsonPath("$.price").value(BigDecimal.TEN));
    }

    private Map<LocalDate, DataPoint> data() {
        DataPoint v1 = new DataPoint();
        v1.setClose(BigDecimal.TEN);
        return Map.of(LocalDate.now(), v1);
    }

    private Metadata metadata() {
        Metadata metadata = new Metadata();
        metadata.setSymbol("AAPL");
        return metadata;
    }

}

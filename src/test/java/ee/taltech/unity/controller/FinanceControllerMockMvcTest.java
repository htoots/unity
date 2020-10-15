package ee.taltech.unity.controller;

import ee.taltech.unity.service.alpha.DailyResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FinanceControllerMockMvcTest {

    @Autowired
    private MockMvc mvc;

//    @MockBean
//    private AlphaVantage alphaVantage;

    @Test
//    @DisplayName("name of the test")
    void financeController_returns_IBMquote() throws Exception {
        DailyResponse response = new DailyResponse();
//        Mockito.when(alphaVantage.queryForDaily(Mockito.anyString())).thenReturn(response);
        mvc.perform(MockMvcRequestBuilders.get("/finance").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.symbol").value("IBM"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").exists());
    }

    @Test
    void financeController_returns_AAPL_quote() {
        //todo but you need to mock alphaVantageApi
    }
}

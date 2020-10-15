package ee.taltech.unity.controller;

import ee.taltech.unity.service.FinanceResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FinanceControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void one_can_get_latest_ibm_data() {
        ResponseEntity<FinanceResponse> entity = testRestTemplate.getForEntity("/finance", FinanceResponse.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        FinanceResponse financeResponse = entity.getBody();
        assertNotNull(financeResponse);
        assertEquals("IBM", financeResponse.getSymbol());
        assertNotNull(financeResponse.getPrice());
        assertNotNull(financeResponse.getDate());
    }

    @Disabled
    @Test
    void one_can_get_latest_aapl_data() {
        ResponseEntity<FinanceResponse> entity = testRestTemplate.getForEntity("/finance?symbol=AAPL", FinanceResponse.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        FinanceResponse financeResponse = entity.getBody();
        assertNotNull(financeResponse);
        assertEquals("IBM", financeResponse.getSymbol());
        assertNotNull(financeResponse.getPrice());
        assertNotNull(financeResponse.getDate());
    }
}

package ee.taltech.unity.controller;

import ee.taltech.unity.service.classes.ResultData;
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
        ResponseEntity<ResultData> entity = testRestTemplate.getForEntity("/finance", ResultData.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        ResultData resultData = entity.getBody();
        assertNotNull(resultData);
        assertEquals("IBM", resultData.getMetaData().getSymbol());
        assertNotNull(resultData.getResponse());
    }

    @Disabled
    @Test
    void one_can_get_latest_aapl_data() {
        ResponseEntity<ResultData> entity = testRestTemplate.getForEntity("/finance?symbol=AAPL", ResultData.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        ResultData resultData = entity.getBody();
        assertNotNull(resultData);
        assertEquals("IBM", resultData.getMetaData().getSymbol());
        assertNotNull(resultData.getResponse());
    }
}

package ee.taltech.unity.service;

import ee.taltech.unity.configuration.AlphaVantageConfig;
import ee.taltech.unity.service.alpha.DailyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphaVantageApi {

    public static final String DAILY = "TIME_SERIES_DAILY";
    @Autowired
    private AlphaVantageConfig config;
    @Autowired
    private RestTemplate restTemplate;
    // TODO: Test
    public DailyResponse queryForDaily(final String symbol){
        String url = config.getUrl()
                + "?function=" + DAILY
                + "&symbol=" + symbol
                + "&apikey=" + config.getKey();
        ResponseEntity<DailyResponse> entity = restTemplate.getForEntity(url, DailyResponse.class);
        //todo do some error handling in the future
        return entity.getBody();
    }
}

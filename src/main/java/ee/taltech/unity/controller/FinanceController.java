package ee.taltech.unity.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import ee.taltech.unity.service.FinanceService;
import ee.taltech.unity.service.classes.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/finance")
@RestController
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping()
    // TODO: Test
    public Response getData(@RequestParam(value = "symbol", defaultValue = "IBM") String symbol){
        return financeService.queryForData(symbol);
    }

}

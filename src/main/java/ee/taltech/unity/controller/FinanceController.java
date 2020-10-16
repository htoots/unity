package ee.taltech.unity.controller;

import ee.taltech.unity.service.FinanceService;
import ee.taltech.unity.service.classes.ResultData;
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
    public ResultData getData(@RequestParam(defaultValue = "IBM") String symbol){
        return financeService.queryForData(symbol);
    }

}

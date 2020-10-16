package ee.taltech.unity.controller;

import ee.taltech.unity.service.FinanceResponse;
import ee.taltech.unity.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

@RequestMapping("/finance")
@RestController
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping()
    public Optional<HashMap<LocalDate, FinanceResponse>> getData(@RequestParam(defaultValue = "IBM") String symbol){
        return financeService.queryForData(symbol);
    }

}

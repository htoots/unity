package ee.taltech.unity.service;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

@Data
public class FinanceResponse {

    private BigDecimal open;
    private BigDecimal close;
    private int comparison;
}

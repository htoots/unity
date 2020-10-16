package ee.taltech.unity.service;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FinanceResponse {

    private BigDecimal open;
    private BigDecimal close;
    private int comparison;
}

package ee.taltech.unity.service;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

@Data
public class ResultData {
    private Meta metaData;
    private Optional<HashMap<LocalDate, FinanceResponse>> response;
}

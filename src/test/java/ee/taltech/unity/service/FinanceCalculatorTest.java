package ee.taltech.unity.service;

import ee.taltech.unity.service.alpha.DataPoint;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import static ee.taltech.unity.service.FinanceCalculator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FinanceCalculatorTest {

    public static final LocalDate _2020_10_10 = LocalDate.of(2020, 10, 10);
    public static final LocalDate _2020_10_20 = LocalDate.of(2020, 10, 20);

    @Test
    void no_data_returns_empty_latest_entry() {
        assertTrue(calc(null).isEmpty());
        assertTrue(calc(Map.of()).isEmpty());
    }

//    @Test
//    void data_returns_latest_entry() {
//        Map<LocalDate, DataPoint> map = Map.of(_2020_10_10, new DataPoint(), _2020_10_20, new DataPoint());
//        Optional<Map.Entry<LocalDate, DataPoint>> lastEntry = getLastEntry(map);
//        assertTrue(lastEntry.isPresent());
//        assertEquals(_2020_10_20, lastEntry.get().getKey());
//    }
}

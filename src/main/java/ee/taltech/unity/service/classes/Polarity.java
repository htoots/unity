package ee.taltech.unity.service.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Polarity {
    @JsonProperty("Positive days")
    private int positiveDays;
    @JsonProperty("Positive dates")
    private List<LocalDate> positiveDaysList;
    @JsonProperty("Negative days")
    private int negativeDays;
    @JsonProperty("Negative dates")
    private List<LocalDate> negativeDaysList;
    @JsonProperty("Equal days")
    private int equalDays;
    @JsonProperty("Equal dates")
    private List<LocalDate> equalDaysList;
}

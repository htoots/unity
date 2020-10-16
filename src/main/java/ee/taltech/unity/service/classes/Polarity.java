package ee.taltech.unity.service.classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Polarity {
    private int positiveDays;
    private List<LocalDate> positiveDaysList;
    private int negativeDays;
    private List<LocalDate> negativeDaysList;
    private int equalDays;
    private List<LocalDate> equalDaysList;
}

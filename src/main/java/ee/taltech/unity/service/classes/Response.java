package ee.taltech.unity.service.classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private String error;
    private Meta metaData;
    private Polarity polarity;
}

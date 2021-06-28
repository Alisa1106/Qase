package objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {
    int id;
    String code;
}
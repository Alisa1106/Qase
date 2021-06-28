package objects;

import groovy.transform.builder.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    boolean status;
    Result result;
}
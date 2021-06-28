package objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestProject {
    String title;
    String code;
    String description;
    String access;
    String group;
}
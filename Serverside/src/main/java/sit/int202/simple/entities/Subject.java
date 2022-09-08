package sit.int202.simple.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Subject {
    private String id;
    private String SubjectName;
    private double credit;
}

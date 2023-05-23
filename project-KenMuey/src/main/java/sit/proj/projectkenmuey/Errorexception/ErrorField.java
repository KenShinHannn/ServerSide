package sit.proj.projectkenmuey.Errorexception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorField {
    private String status;
    private String title;
    private String instance;
    private List<MessageToShowError> detail;
}

package sit.proj.projectkenmuey.Errorexception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageToShowError {
    private String field;
    private String errorMessage;
}

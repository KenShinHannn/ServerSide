package sit.proj.projectkenmuey.Errorexception;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import sit.proj.projectkenmuey.Dto.dtoAnnouncementForInsertUpdate;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class convertShowError{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorField handleValidationException( MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<ObjectError> errors = result.getAllErrors();

        List<MessageToShowError> errorDetails = new ArrayList<>();

        for (ObjectError error : errors) {
            MessageToShowError errorField = new MessageToShowError();
           if(error.getCode().equals("validateTime")){
               errorField.setField("closeDate");
           }else {
               FieldError fieldError = (FieldError) error;
               errorField.setField(fieldError.getField());
           }
            errorDetails.add(new MessageToShowError(errorField.getField(), error.getDefaultMessage()));
        }
        ErrorField errorField = new ErrorField(HttpStatus.BAD_REQUEST.toString(), "Announcement attribute validation failed!"
                , "uri=/api/announcements", errorDetails);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorField).getBody();
    }


}
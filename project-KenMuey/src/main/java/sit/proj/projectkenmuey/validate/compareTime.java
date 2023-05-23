package sit.proj.projectkenmuey.validate;

import sit.proj.projectkenmuey.Dto.dtoAnnouncementForInsertUpdate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.time.ZonedDateTime;
import java.util.Date;

public class compareTime implements ConstraintValidator<validateTime, Object> {

    private String publishDate;
    private String closeDate;
    @Override
    public void initialize(validateTime constraintAnnotation) {
        this.publishDate = constraintAnnotation.publishDate();
        this.closeDate = constraintAnnotation.closeDate();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try{
            final Field publishField = value.getClass().getDeclaredField(publishDate);
            publishField.setAccessible(true);

            final Field closeField = value.getClass().getDeclaredField(closeDate);
            closeField.setAccessible(true);
            final ZonedDateTime publishDate = (ZonedDateTime) publishField.get(value);
            final ZonedDateTime closeDate = (ZonedDateTime) closeField.get(value);
            if(publishDate == null || closeDate == null){
                return true;
            }
            if(publishDate.isAfter(closeDate) || publishDate.equals(closeDate)){
                return false;
            }
            return true;
        }
        catch (Exception error){
            error.printStackTrace();

        }

        return false;
    }
}
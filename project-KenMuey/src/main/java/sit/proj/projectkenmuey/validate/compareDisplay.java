package sit.proj.projectkenmuey.validate;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class compareDisplay implements ConstraintValidator<ValidateDisplay, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) {
            return true;
        }
        return value.equals("Y") || value.equals("N");
    }

}

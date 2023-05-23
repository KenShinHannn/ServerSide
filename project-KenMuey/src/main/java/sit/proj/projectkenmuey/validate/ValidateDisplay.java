package sit.proj.projectkenmuey.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Constraint(validatedBy = compareDisplay.class)
@Target({ElementType.TYPE_USE, TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface ValidateDisplay {
    String message() default "{com.tericcabrel.hotel.constraints.validate.message}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
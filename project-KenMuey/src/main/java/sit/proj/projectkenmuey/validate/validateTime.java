package sit.proj.projectkenmuey.validate;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = compareTime.class)
@Target({ElementType.TYPE_USE, TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface validateTime {
    String message() default "must be later than publish date";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String publishDate();
    String closeDate();
}
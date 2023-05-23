package sit.proj.projectkenmuey.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import sit.proj.projectkenmuey.entities.Category;
import sit.proj.projectkenmuey.services.CategoryService;


public class compareCategory implements ConstraintValidator<ValidateCategory, Integer> {
    @Autowired
    private CategoryService categoryService;


    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        try {
            if (value == null) {
                return true;
            } else {
                Category category = categoryService.getCategoryById(value);
                return category != null;
            }
        } catch (Exception error) {
            error.printStackTrace();

        }
        return false;
    }

}

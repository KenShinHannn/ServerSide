package sit.proj.projectkenmuey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sit.proj.projectkenmuey.entities.Category;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    Category findByCategoryID(Integer categoryId);

}

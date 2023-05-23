package sit.proj.projectkenmuey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.proj.projectkenmuey.entities.Category;
import sit.proj.projectkenmuey.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173","http://intproj22.sit.kmutt.ac.th/kk3"})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //get all category
    @GetMapping("/categories")
    public List<Category> getAllCategory(){
        return categoryService.getAll();
    }

    //get category by id
    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);

    }
    @PostMapping("/categories")
    public Category insertCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
}

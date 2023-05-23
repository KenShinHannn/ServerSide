package sit.proj.projectkenmuey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.proj.projectkenmuey.entities.Category;
import sit.proj.projectkenmuey.repositories.CategoryRepo;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    //insert Announcement categoryName doesn't not send
    public Category sendName(Integer categoryId){
        return categoryRepo.findByCategoryID(categoryId);
    }

    //get all cateGory
    public List<Category> getAll(){
        return categoryRepo.findAll();
    }

    //get category by id
    public Category getCategoryById(Integer categoryId){
        try {
            return categoryRepo.findById(categoryId).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, categoryId + "CategoryId id does not exist"));
        }catch (Exception error){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, categoryId + "CategoryId id does not exist");
        }

    }
    //insert category
    public Category addCategory(Category category){
        try {
            return categoryRepo.saveAndFlush(category);

        }catch (Exception error){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't insert");
        }
    }
}

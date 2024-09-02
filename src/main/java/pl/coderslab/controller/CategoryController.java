package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.domain.Category;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryDao dao;

    public CategoryController(CategoryDao dao) {
        this.dao = dao;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getCategory(@PathVariable long id) {
        return Optional.ofNullable(dao.findCategoryById(id))
                .map(Category::toString)
                .orElse("Category not found");
    }

    @GetMapping("/{id}/delete")
    @ResponseBody
    public String deleteCategory(@PathVariable long id) {
        dao.deleteCategoryById(id);
        return "Category deleted";
    }

    @GetMapping("/{id}/updateName/{name}")
    @ResponseBody
    public String updateCategoryName(@PathVariable long id, @PathVariable String name) {
        Category category = dao.findCategoryById(id);
        category.setName(name);
        dao.updateCategory(category);
        return category.toString();
    }

    @GetMapping
    @ResponseBody
    public String saveCategory() {
        Category category = new Category("Category");
        dao.saveCategory(category);
        return "Category id: " + category.getId();
    }

}

package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.domain.Category;

import javax.validation.Valid;

@Controller
@RequestMapping("/categoryForm")
public class CategoryFormController {

    private final CategoryDao categoryDao;

    public CategoryFormController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("category", new Category());
        return "category/form";
    }

    @PostMapping("/form")
    public String saveForm(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/form";
        }
        if (category.getId() != null) {
            categoryDao.updateCategory(category);
        } else {
            categoryDao.saveCategory(category);
        }
        return "redirect:/categoryForm/list";
    }

    @GetMapping("/list")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryDao.findAllCategories());
        return "category/list";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable long id, Model model) {
        Category category = categoryDao.findCategoryById(id);
        model.addAttribute("category", category);
        return "/category/form";
    }

    @GetMapping("/confirmDel/{id}")
    public String confirmDel(@PathVariable long id, Model model) {
        Category category = categoryDao.findCategoryById(id);
        model.addAttribute("category", category);
        return "/category/confirmDel";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable long id) {
        categoryDao.deleteCategoryById(id);
        return "redirect:/categoryForm/list";
    }
}

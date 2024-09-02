package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.dao.ItemDao;
import pl.coderslab.domain.Category;
import pl.coderslab.domain.Item;

import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
    private final ItemDao dao;
    private final CategoryDao categoryDao;

    public ItemController(ItemDao dao, CategoryDao categoryDao) {
        this.dao = dao;
        this.categoryDao = categoryDao;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public String getItem(@PathVariable long id) {
        return Optional.ofNullable(dao.findById(id))
                .map(Item::toString)
                .orElse("Item not found");
    }

    @GetMapping("/{id}/delete")
    @ResponseBody
    public String deleteItem(@PathVariable long id) {
        dao.deleteById(id);
        return "Item deleted";
    }

    @GetMapping("/{id}/updateName/{name}")
    @ResponseBody
    public String updateItem(@PathVariable long id, @PathVariable String name) {
        Item item = dao.findById(id);
        item.setName(name);
        dao.updateItem(item);
        return item.toString();
    }

    @GetMapping
    @ResponseBody
    public String saveItem() {
        Item item = new Item("Name", "Description", "Unit", "Price");
        dao.saveItem(item);
        return "Item id: " + item.getId();
    }

    @GetMapping("/saveWithCategory")
    @ResponseBody
    public String saveItemWithCategory() {
        Category category = new Category("Item category");
        categoryDao.saveCategory(category);
        Item item = new Item("Book with category", "Description with category",
                "Unit with category", "Price with category");
        item.setCategory(category);
        dao.saveItem(item);
        return item.toString();
    }

    @GetMapping("/all")
    @ResponseBody
    public String findAllItems() {
        dao.findAll().forEach(i -> logger.info(i.toString()));
        return "All items";
    }
}

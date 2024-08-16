package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ItemDao;
import pl.coderslab.domain.Item;

import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemDao dao;

    public ItemController(ItemDao dao) {
        this.dao = dao;
    }

    @GetMapping("/{id}")
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
    public String updateName(@PathVariable long id, @PathVariable String name) {
        Item item = dao.findById(id);
        item.setName(name);
        dao.updateItem(item);
        return item.toString();
    }

    @GetMapping
    @ResponseBody
    public String saveItem() {
        Item item = new Item();
        dao.saveItem(item);
        return "Item id: " + item.getId() + " name: " + item.getName();
    }
}

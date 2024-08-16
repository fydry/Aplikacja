package pl.coderslab.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.ItemDao;
import pl.coderslab.domain.Item;

import javax.validation.Valid;

@Controller
@RequestMapping("/itemForm")
public class ItemFormController {

    private final ItemDao itemDao;

    public ItemFormController(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("item", new Item());
        return "item/form";
    }

    @PostMapping("/form")
    public String saveForm(@Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item/form";
        }
        if (item.getId() != null) {
            itemDao.updateItem(item);
        } else {
            itemDao.saveItem(item);
        }
        return "redirect:list";
    }

    @GetMapping("/list")
    public String listItems(Model model) {
        model.addAttribute("items", itemDao.findAll());
        return "item/list";
    }

    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable long id, Model model){
        Item item = itemDao.findById(id);
        model.addAttribute("item", item);
        return "/item/form";
    }

    @GetMapping("/confirmDel/{id}")
    public String confirmDel(@PathVariable long id, Model model){
        Item item = itemDao.findById(id);
        model.addAttribute("item", item);
        return "/item/confirmDel";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable long id){
        itemDao.deleteById(id);
        return "redirect:/itemForm/list";
    }
}

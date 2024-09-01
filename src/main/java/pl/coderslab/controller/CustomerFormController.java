package pl.coderslab.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.CustomerDao;
import pl.coderslab.domain.Customer;

import javax.validation.Valid;

@Controller
@RequestMapping("/customerForm")
public class CustomerFormController {

    private final CustomerDao customerDao;

    public CustomerFormController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/form";
    }

    @PostMapping("/form")
    public String saveForm(@Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer/form";
        }
        if (customer.getId() != null) {
            customerDao.updateCustomer(customer);
        } else {
            customerDao.saveCustomer(customer);
        }
        return "redirect:list";
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerDao.findAllCustomers());
        return "customer/list";
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable long id, Model model) {
        Customer customer = customerDao.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "/customer/form";
    }

    @GetMapping("/confirmDel/{id}")
    public String confirmDel(@PathVariable long id, Model model) {
        Customer customer = customerDao.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "/customer/confirmDel";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable long id, Model model) {
        customerDao.deleteCustomerById(id);
        return "redirect:/customerForm/list";
    }
}

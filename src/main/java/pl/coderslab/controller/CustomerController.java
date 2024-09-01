package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.CustomerDao;
import pl.coderslab.domain.Customer;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerDao dao;

    public CustomerController(CustomerDao dao) {
        this.dao = dao;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getCustomer(@PathVariable long id) {
        return Optional.ofNullable(dao.findCustomerById(id))
                .map(Customer::toString)
                .orElse("Customer not found");
    }

    @GetMapping("/{id}/delete")
    @ResponseBody
    public String deleteCustomer(@PathVariable long id) {
        dao.deleteCustomerById(id);
        return "Customer deleted";
    }

    @GetMapping("/{id}/updateName/{name}")
    @ResponseBody
    public String updateName(@PathVariable long id, @PathVariable String name) {
        Customer customer = dao.findCustomerById(id);
        customer.setName(name);
        dao.updateCustomer(customer);
        return customer.toString();
    }

    @GetMapping
    @ResponseBody
    public String saveCustomer() {
        Customer customer = new Customer();
        dao.saveCustomer(customer);
        return "Customer saved" + customer.getId() + customer.getName();
    }

}

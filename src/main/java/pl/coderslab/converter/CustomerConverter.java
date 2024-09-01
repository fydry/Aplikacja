package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.CustomerDao;
import pl.coderslab.domain.Customer;



public class CustomerConverter implements Converter<String, Customer> {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer convert(String source) {
        return customerDao.findCustomerById(Long.parseLong(source));
    }
}

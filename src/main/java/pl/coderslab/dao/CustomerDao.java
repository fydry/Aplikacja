package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer findCustomerById(long id) {
        return entityManager.find(Customer.class, id);
    }

    public void updateCustomer(Customer customer) {
        entityManager.merge(customer);
    }

    public void deleteCustomerById(long id) {
        entityManager.remove(findCustomerById(id));
    }

    public List<Customer> findAllCustomers() {
        return entityManager.createQuery("SELECT c FROM Customer c").getResultList();
    }
}

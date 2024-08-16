package pl.coderslab.dao;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import pl.coderslab.domain.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ItemDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveItem(Item item) {
        entityManager.persist(item);
    }

    public Item findById(long id) {
        return entityManager.find(Item.class, id);
    }

    public void updateItem(Item item) {
        entityManager.merge(item);
    }

    public void deleteById(long id) {
        entityManager.remove(findById(id));
    }

    public List<Item> findAll() {
        return entityManager.createQuery("SELECT i FROM Item i").getResultList();
    }
}

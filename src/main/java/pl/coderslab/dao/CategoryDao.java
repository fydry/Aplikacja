package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.domain.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveCategory(Category category) {
        entityManager.persist(category);}

    public Category findCategoryById(long id) {
        return entityManager.find(Category.class, id);
    }

    public void updateCategory(Category category) {
        entityManager.merge(category);
    }
    public void deleteCategoryById(long id) {
        entityManager.remove(findCategoryById(id));
    }

    public List<Category> findAllCategories() {
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }
}

package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);
    Item findByCategory(String category);
    List<Item> findByPrice(String price);

    //TODO @Query() findByNameStartingWith
    //TODO findByCategoryStartingWith
}

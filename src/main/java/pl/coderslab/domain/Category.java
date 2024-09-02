package pl.coderslab.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    @OneToMany(mappedBy = "categories")
    Set<Item> Item;
    private Set<Item> item;

    public Set<Item> getItem() {
        return Item;
    }

    public void setItem(Set<Item> item) {
        this.item = item;
    }





    public Category(String name) {this.name = name;}

    public Category() {}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name=" + name+ '\''
                + "}";
    }
}

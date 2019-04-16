package ru.shikhovtsev.videoShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products", schema = "public")
public class Product extends AbstractNamedEntity {
    public Product(String name, String description, Integer cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    @NotBlank
    @Size(min = 10, max = 100)
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "cost")
    private Integer cost;

    @Column(name = "image")
    private String image;

    @ManyToMany
    @JoinTable(name = "orders_products", schema = "public",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"))
    private List<Order> orders;

    @ManyToMany
    @JoinTable(name = "products_category", schema = "public",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<Category> categories;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<User> users;
}

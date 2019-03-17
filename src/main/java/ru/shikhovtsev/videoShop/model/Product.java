package ru.shikhovtsev.videoShop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products", schema = "public")
public class Product extends AbstractNamedEntity {

    public Product(String name, String description, Double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "cost")
    private Double cost;

    @ManyToMany
    @JoinTable(name = "orders_products", schema = "public",
            joinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_order", referencedColumnName = "id"))
    private List<Order> orders;
}

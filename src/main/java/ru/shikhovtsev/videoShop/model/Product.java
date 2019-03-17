package ru.shikhovtsev.videoShop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products", schema = "main")
public class Product extends AbstractNamedEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private BigDecimal cost;

    @ManyToMany
    @JoinTable(name = "orders_products", schema = "public",
            joinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_order", referencedColumnName = "id"))
    private List<Order> orders;
}

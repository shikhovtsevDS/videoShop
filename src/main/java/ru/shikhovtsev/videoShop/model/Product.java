package ru.shikhovtsev.videoShop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "products", schema = "main")
public class Product extends AbstractNamedEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private BigDecimal cost;

}

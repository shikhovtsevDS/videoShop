package ru.shikhovtsev.videoShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders", schema = "public")
public class Order extends AbstractBaseEntity {

    @Column(name = "location")
    private String location;

    @Column(name = "date_create")
    private LocalDate dateCreate;

    @Column(name = "date_delivery")
    private LocalDate dateDelivery;

    @Enumerated
    @Column(name = "state")
    private DeliveryState state;

    @JsonIgnore
    @ManyToMany(mappedBy = "orders")
    private List<Product> products;
}

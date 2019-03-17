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

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "location")
    private String location;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "delivered_date")
    private LocalDate deliveredDate;

    @Enumerated
    @Column(name = "state")
    private DeliveryState state;

    @JsonIgnore
    @ManyToMany(mappedBy = "orders")
    private List<Product> products;
}

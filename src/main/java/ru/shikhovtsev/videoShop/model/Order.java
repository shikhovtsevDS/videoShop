package ru.shikhovtsev.videoShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders", schema = "public")
public class Order extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "delivered_date", nullable = false)
    private LocalDateTime deliveredDate;

    @Enumerated
    @Column(name = "state")
    private DeliveryState state;

    @JsonIgnore
    @ManyToMany(mappedBy = "orders")
    private List<Product> products;
}

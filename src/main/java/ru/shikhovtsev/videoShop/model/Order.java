package ru.shikhovtsev.videoShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders", schema = "public")
public class Order extends AbstractNamedEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @Column(name = "location", nullable = false)
    @NotNull
    private String location;

    @Column(name = "created_date", nullable = false)
    @NotNull
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "delivered_date", nullable = false)
    @NotNull
    private LocalDate deliveredDate = LocalDate.now().plusDays(6);

    @Enumerated
    @Column(name = "state")
    private DeliveryState state;

    @Column(name = "confirmed", nullable = false)
    private boolean confirmed = false;

    @JsonIgnore
    @ManyToMany(mappedBy = "orders")
    private List<Product> products;
}

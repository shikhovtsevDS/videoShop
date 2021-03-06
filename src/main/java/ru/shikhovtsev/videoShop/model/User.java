package ru.shikhovtsev.videoShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users", schema = "public")
public class User extends AbstractBaseEntity {

    @Column(name = "first_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "users_products", schema = "public",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> products;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "registered")
    @NotNull
    @JsonIgnore
    private LocalDate registered = LocalDate.now();

    public User(Integer id, String firstName, String middleName, String lastName, String email, String password, Role role, Role... roles) {
        this(id, firstName, middleName, lastName, email, password, true, LocalDate.now(), EnumSet.of(role, roles));
    }

    public User(Integer id, String firstName, String middleName, String lastName, String email, String password, boolean enabled, LocalDate registered, Collection<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.registered = registered;
        setRoles(roles);
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);
    }
}

package ru.shikhovtsev.videoShop.model;

import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    private Set<UserRole> roles;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "registered")
    @NotNull
    private Date registered = new Date();

    public User(Integer id, String firstName, String middleName, String lastName, String email, String password, UserRole role, UserRole... roles) {
        this(id, firstName, middleName, lastName, email, password, true, new Date(), EnumSet.of(role, roles));
    }

    public User(Integer id, String firstName, String middleName, String lastName, String email, String password, boolean enabled, Date registered, Collection<UserRole> roles) {
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

    public void setRoles(Collection<UserRole> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);
    }
}

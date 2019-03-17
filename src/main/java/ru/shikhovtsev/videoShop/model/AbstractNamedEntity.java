package ru.shikhovtsev.videoShop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractBaseEntity {

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name", nullable = false)
    protected String name;

    @Override
    public String toString() {
        return String.format("Entity %s (%s, '%s')", getClass().getName(), id, name);
    }
}
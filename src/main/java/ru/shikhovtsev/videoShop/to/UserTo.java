package ru.shikhovtsev.videoShop.to;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserTo extends BaseTo {

    @Email
    @NotBlank
    private String email;

    @Size(min = 5, max = 32, message = "length must between 5 and 32 characters")
    private String password;

    @NotBlank
    @Size(min = 2, max = 100)
    private String lastName;

    @NotBlank
    @Size(min = 2, max = 100)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 100)
    private String middleName;

    public UserTo() {
    }

    public UserTo(Integer id, String firstName, String middleName, String lastName, String email, String password) {
        super(id);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}

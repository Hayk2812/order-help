package com.platform.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public static final String NAME_EMPTY_MSG = "Name of user can't be null or empty";
    public static final String NAME_REGEX = "^[A-Za-z]";
    public static final String NAME_REGEX_MSG = "Surname of user can contain letters and hyphen";

    public static final String SURNAME_EMPTY_MSG = "Surname of user can't be null or empty";
    public static final String SURNAME_REGEX = "^[A-Za-z]";
    public static final String SURNAME_REGEX_MSG = "Surname of user can contain letters and hyphen";

    public static final String EMAIL_EMPTY_MSG = "Email of user can't be null or empty";
    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";


    @Schema(description = "unique identifier of the user",hidden = true)
    private UUID userId;

    @NotEmpty(message = NAME_EMPTY_MSG)
    @Pattern(regexp = NAME_REGEX,message = NAME_REGEX_MSG)
    @Schema(description = "Name of user",defaultValue = "Joan")
    private String name;

    @NotEmpty(message = SURNAME_EMPTY_MSG)
    @Pattern(regexp = SURNAME_REGEX,message = SURNAME_REGEX_MSG)
    @Schema(description = "Surname of user",defaultValue = "Liman")
    private String surname;

    @NotEmpty(message = EMAIL_EMPTY_MSG)
    @Pattern(regexp = EMAIL_REGEX)
    @Schema(description = "Email address",defaultValue = "joan@gmail.com")
    private String email;
    private String password;
    private Address address;

}

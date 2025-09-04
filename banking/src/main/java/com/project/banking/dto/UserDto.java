package com.project.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * This class represents a User's data transfer object (DTO). It is used to transfer user information between layers of an application.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String firstname;
    private String lastname;
    private String username;
    private Date dob;
    private long tel;
    /**
     * The user's password.
     * <p>
     * Note: It is recommended to store hashed passwords for security reasons.
     * </p>
     */
    private String password;
    private String gender;
}

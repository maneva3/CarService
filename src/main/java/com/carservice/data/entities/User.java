package com.carservice.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.ToString;

@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @Column(name = "email")
    @Email(regexp = ".+[@].+[\\.].+", message = "Invalid email format!")
    protected String email;

    @Column(name = "first_name")
    @NotBlank(message = "The first name cannot be empty!")
    protected String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "The last name cannot be empty!")
    protected String lastName;

    @Column(name = "phone_number")
    @NotBlank(message = "The phone number cannot be empty!")
    @Pattern(regexp = "^\\+359\\d{9}$", message = "The phone number must be in the format +359xxxxxxxxx!")
    protected String phoneNumber;

    @Column(name = "password")
    @NotBlank(message = "The password cannot be empty!")
    @Size(min = 8, max = 64, message = "The password must contain at least 8 characters!")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "The password must contain at least 1 uppercase letter, 1 lowercase letter and 1 digit!")
    protected String password;

}

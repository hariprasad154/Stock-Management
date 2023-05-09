package com.stockexchange.stockecmarker.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    @NotEmpty
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$",message = "The Name is notEmpty")
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;
    //    @JsonFormat(pattern = "dd-MM-yyyy")
//    private LocalDate registeredDate;
    @NotNull(message = "The email not be  null ")
    private String email;
    @NotNull(message = "The password not be  null ")
    private String password;

    private String stock;

}

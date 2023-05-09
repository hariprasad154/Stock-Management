package com.stockexchange.stockecmarker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stockexchange.stockecmarker.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue
    private int user_id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String email;
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private myModel stock;
    private String password;

    public void updateData(UserDto userDto) {
        this.firstName = userDto.getFirstName();
        this.lastName = userDto.getLastName();
        this.dob = userDto.getDob();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
    }

    public UserModel(UserDto userDto) {
        this.updateData(userDto);
    }
}

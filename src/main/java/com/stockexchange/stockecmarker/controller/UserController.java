package com.stockexchange.stockecmarker.controller;

import com.stockexchange.stockecmarker.dto.Login;
import com.stockexchange.stockecmarker.dto.ResponceDto;
import com.stockexchange.stockecmarker.dto.UserDto;
import com.stockexchange.stockecmarker.srvice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public ResponceDto register(@RequestBody UserDto userDto) {
        return userService.register(userDto);
    }
    @PostMapping("/login")
    public ResponceDto login(@RequestBody Login login) {
        return userService.login(login);
    }
}



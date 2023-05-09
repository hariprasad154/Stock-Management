package com.stockexchange.stockecmarker.srvice;

import com.stockexchange.stockecmarker.dto.Login;
import com.stockexchange.stockecmarker.dto.ResponceDto;
import com.stockexchange.stockecmarker.dto.UserDto;
import com.stockexchange.stockecmarker.model.UserModel;

public interface UserService {
    ResponceDto login(Login login) ;

    ResponceDto register(UserDto userDto);

    UserModel getById(int id);

    UserModel UpdateEmployee(int id, UserDto userDto);

    void delete(int id);
}

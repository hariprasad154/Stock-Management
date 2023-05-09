package com.stockexchange.stockecmarker.srvice;

import com.stockexchange.stockecmarker.dto.Login;
import com.stockexchange.stockecmarker.dto.ResponceDto;
import com.stockexchange.stockecmarker.dto.UserDto;
import com.stockexchange.stockecmarker.model.UserModel;
import com.stockexchange.stockecmarker.model.myModel;
import com.stockexchange.stockecmarker.repository.UserRepo;
import com.stockexchange.stockecmarker.repository.myRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private myRepo stockRepo;
    @Override
    public ResponceDto login(Login login) {
        String email =login.getEmail();
        String password=login.getPassword();
        String varifyPassword=userRepo.getPassword(email);
        UserModel id=userRepo.findEmail(email);
        if (password.equals(varifyPassword) ){
            UserModel data=userRepo.findById(id.getUser_id()).orElseThrow();
            userRepo.save(data);
            return new ResponceDto(login.getEmail() ,"login successfull..... for ");
        }
        else{
            if(varifyPassword!=null){
                return new ResponceDto("The validation not done ","Validate the otp to login");
            }else {
                return new ResponceDto(" check the email and password", "The incorrect credentials");
            }
        }
    }

    @Override
    public ResponceDto register(UserDto userDto) {
        String email=userDto.getEmail();
        UserModel mail=userRepo.findEmail(email);
        if(mail!=null){

            return new ResponceDto("Enter the unique Email id ",userDto.getEmail());
        }else {
            UserModel userData=new UserModel(userDto);
            myModel stock=stockRepo.findStockByName(userDto.getStock());
            System.out.println(stock);
//            int genarateOtp=(int) ((Math.random() * 999999) % 899998) + 100001;
            userData.setStock(stock);
            userRepo.save(userData);
//            emailService.sendEmail(userData.getEmail(),"The is Register done OTP sent  ","hi....."+userData.getFirstName()+userData.getLastName() + "\n The OTP is "+genarateOtp + " ");
            return new ResponceDto(userDto,"The data rigisterd succsusfully") ;
        }
    }

    @Override
    public UserModel getById(int id) {
        return userRepo.findById(id).orElseThrow();
    }

    @Override
    public UserModel UpdateEmployee(int id, UserDto userDto) {
        UserModel addressBookData =this.getById(id);
        addressBookData.updateData(userDto);
        return userRepo.save(addressBookData);
    }

    @Override
    public void delete(int id) {
        UserModel addressBookData =this.getById(id);
        userRepo.delete(addressBookData);
    }
}

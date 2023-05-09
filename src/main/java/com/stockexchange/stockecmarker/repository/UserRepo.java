package com.stockexchange.stockecmarker.repository;

import com.stockexchange.stockecmarker.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer> {
    @Query(value = "select * from user_model where email= :email",nativeQuery = true)
    UserModel findEmail(String email);
    @Query(value = "select password from user_model where email= :email",nativeQuery = true)
    String getPassword(String email);
    @Query(value = "select * from user_model where id= :id",nativeQuery = true)
    List<UserModel> findByStockId(int id);
//    @Query(value = "select varify_otp from user_model where email= :email",nativeQuery = true)
//    boolean getVarifyOtp(String email);
}

package com.stockexchange.stockecmarker.srvice;
import com.stockexchange.stockecmarker.dto.AllertStock;
import com.stockexchange.stockecmarker.dto.Mydto;
import com.stockexchange.stockecmarker.dto.ResponceDto;
import com.stockexchange.stockecmarker.exception.CustomeException;
import com.stockexchange.stockecmarker.model.UserModel;
import com.stockexchange.stockecmarker.model.myModel;
import com.stockexchange.stockecmarker.repository.UserRepo;
import com.stockexchange.stockecmarker.repository.myRepo;

import com.stockexchange.stockecmarker.util.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.LoadingCache;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImp implements service{
    @Autowired
    private myRepo repo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EmailService email;
    @Override
    public ResponceDto addStock(Mydto mydto) {
        myModel name=repo.findStockByName(mydto.getName());
        if(name.getName() == mydto.getName() ){
            return new ResponceDto(mydto.getName(),"The name alredy present please change the name ");
        }else {
            myModel model = new myModel(mydto);
            return new ResponceDto(repo.save(model), "Data added");
        }
    }
    @Override
    public ResponceDto editData(int id,Mydto mydto) {
        myModel model=repo.findById(id).orElseThrow();
        model.update(mydto);
        return new ResponceDto(repo.save(model),"The Data Edited");
    }
    @Override
    public ResponceDto getAllData() {
        List<myModel> data=repo.findAll();
        if(data.isEmpty()){
            return new ResponceDto("The Data not present in the Db","Empty data present");
        }else{
            return new ResponceDto(data,"The All Data");
        }
    }
    @Override
    public ResponceDto getDataById(int id) {
        return new ResponceDto(repo.findById(id).orElseThrow(),"The data for "+id);
    }
    @Override
    public String deleteDataById(int id) {
        repo.deleteById(id);
        return "Deleted the Data"+id;
    }
    @Override
    public AllertStock alert() {
        List<myModel> data=repo.findAll();
        List<myModel> priseHigh=data.stream().filter(i->i.getPrice()>i.getMaxCost()).collect(Collectors.toList());
        List<myModel> priseDrop=data.stream().filter(i->i.getPrice()<i.getMinCost()).collect(Collectors.toList());
        priseDrop.stream().forEach(i->userRepo.findByStockId(i.getId()).forEach(j-> email.sendEmail(j.getEmail(),
                "The Stock allert for the data  "+LocalDate.now(),
                " The price reduced stocks"+j.getStock())));
            priseHigh.stream().forEach(i->userRepo.findByStockId(i.getId()).forEach(j-> email.sendEmail(j.getEmail(),
                "The Stock allert for the data  "+LocalDate.now(),
                " The price increased stocks"+j.getStock())));

         return new AllertStock(priseHigh ,"The Data of stockes rised ",priseDrop,"The data list Dropped Price for the data "+ LocalDate.now());
    }
}


/*
                                        NORMAL WAY DOING OF CODE
 */

///
//The Normal method implimantation is  given bellow
//            for(myModel i:data){//
//            float price=i.getPrice();
//            if(price>i.getMaxCost()){
//                priseHigh.add(i);
//            }
//            else if(price<i.getMinCost()){
//                priseDrop.add(i);
//            }
//        }

//        List<UserModel> userdetailes=priseDrop.stream().reduce(i->userRepo.findByStockId(i.getId()).stream()collect(Collectors.toList()));
//        for(myModel i :priseDrop){
//            List<UserModel> userdetailes=userRepo.findByStockId(i.getId());
//            if(userdetailes.size()!=0){
//                for(UserModel j:userdetailes){
//                    email.sendEmail(j.getEmail(),"The Stock allert for the data  "+LocalDate.now()," The price reduced stocks"+j.getStock());
//                    System.out.println(" The alert sent for "+j.getEmail());
//                }
//            }
//            }
//        for(myModel i :priseHigh){
//            List<UserModel> userdetailes=userRepo.findByStockId(i.getId());
//            if(!userdetailes.isEmpty()){
//                for(UserModel j:userdetailes){
//                    email.sendEmail(j.getEmail(),"The Stock allert for the data  "+LocalDate.now()," The price rised stocks"+j.getStock());
//                    System.out.println(" The alert sent for "+j.getEmail());
//                }
//            }
//        }
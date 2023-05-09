package com.stockexchange.stockecmarker.controller;

import com.stockexchange.stockecmarker.dto.AllertStock;
import com.stockexchange.stockecmarker.dto.Mydto;
import com.stockexchange.stockecmarker.dto.ResponceDto;
import com.stockexchange.stockecmarker.repository.myRepo;
import com.stockexchange.stockecmarker.srvice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {
    @Autowired
    private myRepo myrepo;

    @Autowired
    private service ser;

    @PostMapping("/add")
    public ResponceDto adStock(@RequestBody Mydto mydto){
        return ser.addStock(mydto);
    }
    @PutMapping("/update/{id}")
    public ResponceDto editData(@PathVariable int id,@RequestBody Mydto mydto){
        return ser.editData(id,mydto);
    }
    @GetMapping("/")
    public ResponceDto getAllData(){
        return ser.getAllData();
    }
    @GetMapping("/get/{id}")
    public ResponceDto getData(@PathVariable int id){
        return ser.getDataById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return ser.deleteDataById(id);
    }

    @GetMapping("/Alert")
    public AllertStock alert(){
        return ser.alert();
    }
}

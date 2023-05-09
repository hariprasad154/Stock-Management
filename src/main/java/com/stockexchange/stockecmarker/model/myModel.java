package com.stockexchange.stockecmarker.model;

import com.stockexchange.stockecmarker.dto.Mydto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;


@Entity
@Data
@NoArgsConstructor
public class myModel {


    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private int price;

    private int quantity;

    private LocalDate date;

    private float minCost;

    private float maxCost;

    public void update(Mydto mydto){
        this.name=mydto.getName();
        this.quantity= mydto.getQuantity();
        this.description=mydto.getDescription();
        this.price= mydto.getPrice();
        this.date=LocalDate.now();
        this.maxCost= mydto.getMaxCost();
        this.minCost= mydto.getMinCost();
    }

    public myModel(Mydto mydto){
        this.update(mydto);
    }
}

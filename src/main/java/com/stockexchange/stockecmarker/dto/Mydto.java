package com.stockexchange.stockecmarker.dto;

import lombok.Data;

import javax.swing.text.html.parser.Entity;
import java.util.List;


@Data
public class Mydto {
    private String name;
    private String description;
    private int price;

    private int quantity;

    private float minCost;
    private float maxCost;
}

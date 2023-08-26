package com.carshop.ProjectSite.Models;



import lombok.Data;


@Data

public class Car {

    private int id;
    private String name;
    private String brand;
    private String country;
    private String productionYear;
    private String engineCapacity;
    private String price;
    private String isSold;

}


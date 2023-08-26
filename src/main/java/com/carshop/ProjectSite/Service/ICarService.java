package com.carshop.ProjectSite.Service;

import com.carshop.ProjectSite.Models.Car;

import java.util.List;

public interface ICarService {

    public List<Car> listRates();

    public void saveRate(Car Rate);


    public void deleteRate(int id);

    public Car getRateById(int id);

    public void updateRate(Car Rate);
}

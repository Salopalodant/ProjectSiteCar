package com.carshop.ProjectSite.Repository;

import com.carshop.ProjectSite.Models.Car;

import java.util.List;

public interface ICarRepository {
    public List<Car> getRateData();
    public Car findRateById(int id);
    public void add(Car RateData);
    public void update(Car RateData);
    public void delete(int id);
}

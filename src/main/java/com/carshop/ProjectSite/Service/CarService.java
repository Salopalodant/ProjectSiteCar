package com.carshop.ProjectSite.Service;

import com.carshop.ProjectSite.Models.Car;
import com.carshop.ProjectSite.Repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {
    @Autowired
    private ICarRepository RateDataRepository;
    @Async
    public List<Car> listRates(){
        return RateDataRepository.getRateData();}

    @Async
    public void saveRate(Car rate){
        RateDataRepository.add(rate);
    }
    @Async
    public void deleteRate(int id){
        RateDataRepository.delete(id);
    }

    @Async
    public Car getRateById(int id){
        return RateDataRepository.findRateById(id);
    }
    @Async
    public void updateRate(Car rate){
        RateDataRepository.update(rate);
    }
}

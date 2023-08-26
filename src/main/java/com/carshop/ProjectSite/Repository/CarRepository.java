package com.carshop.ProjectSite.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.carshop.ProjectSite.Models.Car;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CarRepository implements ICarRepository {
    private List<Car> RatesDataList = new ArrayList<>();
    private static String YamlFile_Path = "C:\\Users\\1665833\\Documents\\JavaProjects\\ProjectSite\\src\\main\\resources\\CarData.yml";

    ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
    private int idCount=1;

    public CarRepository(List<Car> ratesDataList, ObjectMapper objectMapper, int idCount) {
        RatesDataList = ratesDataList;
        this.objectMapper = objectMapper;
        this.idCount = idCount;
    }
    public CarRepository() {
    }

    public List<Car> ReadData(){
        try
        {
            RatesDataList = objectMapper.readValue(new File(YamlFile_Path), new TypeReference<>() {});
            for (Car RateData: RatesDataList)
            {
                if (RateData.getId() >= idCount)
                {
                    idCount = RateData.getId()+1;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return new ArrayList<Car>();
    }

    @Async
    public List<Car> getRateData()
    {
        Car RateData;
        return RatesDataList;
    }

    @Async
    public Car findRateById(int id)
    {
        for (Car RateData : RatesDataList)
        {
            if (RateData.getId() == id)
            {
                return RateData;
            }
        }
        return null;
    }

    @Async
    public void add(Car RateData)
    {
        RateData.setId(idCount++);
        RatesDataList.add(RateData);
        save();
    }

    @Async
    public void update(Car RateData)
    {
        idCount=1;
        for (int i = 0; i < RatesDataList.size(); i++)
        {
            RatesDataList.get(i).setId(i+1);
            idCount++;
            if (RatesDataList.get(i).getId() == RateData.getId())
            {
                RateData.setId(idCount);
                RatesDataList.set(i, RateData);
                save();
            }
        }
    }

    @Async
    public void delete(int id)
    {
        RatesDataList.removeIf(wagon -> wagon.getId() == id);
        save();
    }

    private void save()
    {
        try
        {
            objectMapper.writeValue(new File(YamlFile_Path), RatesDataList);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}

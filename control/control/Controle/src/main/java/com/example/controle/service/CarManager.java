package com.example.controle.service;

import com.example.controle.dao.entities.Car;
import com.example.controle.service.dtos.CarDTO;

import java.util.List;

public interface CarManager {
    public List<CarDTO> getCarByModel(String model);
    public List<CarDTO> getCarByModelAndPrice(String model, Float price);
    public CarDTO saveCar(CarDTO carDTO);
    public CarDTO deleteCar(Long id);
}

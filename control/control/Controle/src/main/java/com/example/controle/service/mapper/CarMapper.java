package com.example.controle.service.mapper;

import com.example.controle.dao.entities.Car;
import com.example.controle.service.dtos.CarDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class CarMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Car fromCarDTOtoCar(CarDTO carDTO){
       return this.modelMapper.map(carDTO, Car.class);
    }
    public CarDTO fromCarToCarDTO(Car car){
        return this.modelMapper.map(car, CarDTO.class);
    }
}
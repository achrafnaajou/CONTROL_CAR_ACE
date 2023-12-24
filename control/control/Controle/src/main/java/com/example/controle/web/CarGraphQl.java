package com.example.controle.web;

import com.example.controle.dao.entities.Car;
import com.example.controle.dao.repositories.CarRepository;
import com.example.controle.service.CarManagerAction;
import com.example.controle.service.dtos.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarGraphQl {
    @Autowired
    CarRepository carRepository;
    @Autowired
    CarManagerAction carManagerAction;

    @QueryMapping
    public List<CarDTO> getCarByModel(String model){
       return carManagerAction.getCarByModel(model);
    }
    @QueryMapping
    public List<CarDTO> getCarByModelAndPrice(@Argument String model, @Argument Float price){
        return carManagerAction.getCarByModelAndPrice(model,price);
    }
    @MutationMapping
    public CarDTO saveCar(@Argument CarDTO carDTO){
        return carManagerAction.saveCar(carDTO);
    }
    @MutationMapping
    public CarDTO delete(@Argument Long id){
        return carManagerAction.deleteCar(id);
    }

}
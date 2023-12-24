package com.example.controle.service;

import com.example.controle.dao.entities.Car;
import com.example.controle.dao.repositories.CarRepository;
import com.example.controle.exception.MatriculAlreadyExistsException;
import com.example.controle.service.dtos.CarDTO;
import com.example.controle.service.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarManagerAction implements CarManager{
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarMapper carMapper;
    @Override
    public List<CarDTO> getCarByModel(String model) {
        List<Car> cars = carRepository.findByModel(model);
        List<CarDTO> carDTOS = cars.stream().map(carMapper::fromCarToCarDTO).collect(Collectors.toList());
        return carDTOS;
    }
    @Override
    public List<CarDTO> getCarByModelAndPrice(String model, Float price) {
        List<Car> cars = carRepository.findByModelAndPrice(model, price);
        List<CarDTO> carDTOS = cars.stream().map(carMapper::fromCarToCarDTO).collect(Collectors.toList());
        return carDTOS;
    }
    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        if (carRepository.existsByMatricul(carDTO.getMatricul())) {
            throw new MatriculAlreadyExistsException("La matricule existe déjà");
        }
         Car newCar = carMapper.fromCarDTOtoCar(carDTO);
         carRepository.save(newCar);
         return carDTO;
    }
    @Override
    public CarDTO deleteCar(Long id) {
        Car car=carRepository.findById(id).get();
        carRepository.delete(car);
        return carMapper.fromCarToCarDTO(car);
    }
}

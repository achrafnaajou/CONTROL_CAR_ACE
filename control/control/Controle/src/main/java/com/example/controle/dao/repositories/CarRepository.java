package com.example.controle.dao.repositories;

import com.example.controle.dao.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car,Long> {
    public boolean existsByMatricul(String matricul);
    public List<Car>findByModel(String Model);
    public List<Car>findByModelAndPrice(String Model,Float price);

}

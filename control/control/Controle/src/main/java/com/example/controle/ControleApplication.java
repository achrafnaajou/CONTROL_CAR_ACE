package com.example.controle;

import com.example.controle.dao.entities.Car;
import com.example.controle.dao.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ControleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CarRepository carRepository){
        return args -> {
            for (int i = 0; i < 4; i++) {
                Car car = Car.builder()
                        .price((float) (i+1474))
                        .color("rouge de "+i)
                        .matricul("147-A"+i)
                        .model("1990")
                        .build();
                carRepository.save(car);
            }
        };
    }

}

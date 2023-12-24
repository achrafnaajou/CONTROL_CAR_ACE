package com.example.controle.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @AllArgsConstructor @NoArgsConstructor @Builder @Data
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Car;
    private String model ;
    private String color;
    private String matricul;
    private Float price;

}

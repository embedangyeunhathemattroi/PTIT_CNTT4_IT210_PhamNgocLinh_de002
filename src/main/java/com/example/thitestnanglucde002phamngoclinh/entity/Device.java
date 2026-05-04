package com.example.thitestnanglucde002phamngoclinh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "devices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceName;

    private String modelCode;

    private Double price;

    private LocalDate manufactureDate;

    private String productImage;

    private Boolean isAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
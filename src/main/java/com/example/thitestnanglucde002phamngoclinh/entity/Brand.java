package com.example.thitestnanglucde002phamngoclinh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    private String description;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Device> devices;
}
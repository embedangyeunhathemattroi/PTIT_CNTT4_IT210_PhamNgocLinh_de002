package com.example.thitestnanglucde002phamngoclinh.repository;

import com.example.thitestnanglucde002phamngoclinh.entity.Brand;
import com.example.thitestnanglucde002phamngoclinh.entity.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}


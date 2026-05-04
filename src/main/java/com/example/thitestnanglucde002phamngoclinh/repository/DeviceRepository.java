package com.example.thitestnanglucde002phamngoclinh.repository;

import com.example.thitestnanglucde002phamngoclinh.entity.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    Page<Device> findByDeviceNameContainingIgnoreCase(String keyword, Pageable pageable);
}
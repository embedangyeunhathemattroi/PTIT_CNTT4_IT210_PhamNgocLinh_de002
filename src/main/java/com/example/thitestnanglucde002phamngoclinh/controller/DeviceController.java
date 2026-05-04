package com.example.thitestnanglucde002phamngoclinh.controller;

import com.example.thitestnanglucde002phamngoclinh.entity.Brand;
import com.example.thitestnanglucde002phamngoclinh.entity.Device;
import com.example.thitestnanglucde002phamngoclinh.repository.BrandRepository;
import com.example.thitestnanglucde002phamngoclinh.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping
    public String list(@RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "0") int page,
                       Model model) {

        Pageable pageable = PageRequest.of(page, 5);
        Page<Device> devices;

        if (!keyword.isEmpty()) {
            devices = deviceRepository
                    .findByDeviceNameContainingIgnoreCase(keyword, pageable);
        } else {
            devices = deviceRepository.findAll(pageable);
        }

        model.addAttribute("devices", devices);
        model.addAttribute("keyword", keyword);
        return "device-list";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("device", new Device());
        model.addAttribute("brands", brandRepository.findAll());
        return "device-form";
    }

    // SAVE
    @PostMapping("/save")
    public String save(@ModelAttribute Device device,
                       @RequestParam("brand") Long brandId) {

        Brand brand = brandRepository.findById(brandId).orElse(null);
        device.setBrand(brand);

        deviceRepository.save(device);
        return "redirect:/devices";
    }
}
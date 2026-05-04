package com.example.thitestnanglucde002phamngoclinh.controller;

import com.example.thitestnanglucde002phamngoclinh.entity.Device;
import com.example.thitestnanglucde002phamngoclinh.repository.BrandRepository;
import com.example.thitestnanglucde002phamngoclinh.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/devices")

public class Devicecontroller {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private BrandRepository brandRepository;

    @GetMapping
    public String list(
        @RequestParam(defaultValue="") String keyword,
        @RequestParam(defaultValue="0") int page,
        Model model
    ){
//        int page = 0;
        Pageable pageable = (Pageable) PageRequest.of(page,5);
        Page<Device> devices;

        if(!keyword.isEmpty()){
            devices=deviceRepository.findByDeviceNameContainingIgnoreCase(keyword, (org.springframework.data.domain.Pageable) pageable);
        }else {
            devices=deviceRepository.findAll(pageable);
        }
        model.addAttribute("devices",devices);
        model.addAttribute("keyword",keyword);
        return "device/list";
    }
    @GetMapping("/add")
    public String form(Model model){
        model.addAttribute("devices",new Device());
        model.addAttribute("brands",brandRepository.findAll());
        return "device/form";

    }
    @PostMapping("/save")
    public String save(@ModelAttribute Device device, @RequestParam("file")MultipartFile file) throws IOException{
        if(!file.isEmpty()){
            String fileName =System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get("upload/" +fileName);
            Files.createDirectories(path.getParent());
            Files.write(path,file.getBytes());
            device.setProductImage(fileName);

        }
        deviceRepository.save(device);
        return "redirect:/devices";
    }
}

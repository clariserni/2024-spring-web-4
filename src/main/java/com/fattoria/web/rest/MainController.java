package com.fattoria.web.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fattoria.pojo.Farm;
import com.fattoria.pojo.Farmer;
import com.fattoria.service.FarmService;
import com.fattoria.service.FarmerService;
import com.fattoria.web.dto.FarmerDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/farmers")
public class MainController {

    @Autowired
    FarmerService farmerService;

    @Autowired
    FarmService farmService;

    @GetMapping("/test/add")
    public ResponseEntity<Void> addTest() {
        Farm farm1 = new Farm("Fattoria 1", "Roma");
        Farm farm2 = new Farm("Fattoria 2", "Firenze");
        Farm farm3 = new Farm("Fattoria 3", "Milano");

        farmService.save(farm1);
        farmService.save(farm2);
        farmService.save(farm3);

        Farmer farmer1 = new Farmer("Mario", "Rossi", 40, farm1);
        Farmer farmer2 = new Farmer("Luca", "Verdi", 45, farm2);
        Farmer farmer3 = new Farmer("Sara", "Bianchi", 35, farm2);

        farmerService.save(farmer1);
        farmerService.save(farmer2);
        farmerService.save(farmer3);

        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Farmer>> allFarmers(){

        List<Farmer> farmers = farmerService.findAll();

        return ResponseEntity.ok(farmers);
    }

    @PostMapping("/")
    public ResponseEntity<Farmer> addFarmer(@RequestBody FarmerDTO farmerDTO) {
        
        Farmer farmer = new Farmer(farmerDTO);
        Optional<Farm> farmOpt = farmService.findById(farmerDTO.getFarmId());

        if(farmOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Farm farm = farmOpt.get();
        farmer.setFarm(farm);
        farmerService.save(farmer);
        
        return ResponseEntity.ok(farmer);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id){

        Optional<Farmer> farmOpt = farmerService.findById(id);

        if(farmOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Farmer farmer = farmOpt.get();
        farmerService.delete(farmer);

        return ResponseEntity.ok("id eliminato: "+ id);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Farmer> update(@RequestBody FarmerDTO farmerDTO, @PathVariable int id){
       Optional<Farmer> farmerOpt = farmerService.findById(id);
       
       if(farmerOpt.isEmpty()){
        return ResponseEntity.notFound().build();
       }

       Farmer farmer = farmerOpt.get();
       farmer.update(farmerDTO);

       Optional<Farm> farmOpt = farmService.findById(farmerDTO.getFarmId());

        if(farmOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Farm farm = farmOpt.get();
        farmer.setFarm(farm);
        farmerService.save(farmer);
        
        return ResponseEntity.ok(farmer);
    }

}

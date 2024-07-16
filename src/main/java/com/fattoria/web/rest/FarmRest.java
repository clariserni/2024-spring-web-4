package com.fattoria.web.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fattoria.pojo.Farm;
import com.fattoria.service.FarmService;
import com.fattoria.web.dto.FarmDTO;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/farms")
public class FarmRest {

    @Autowired
    FarmService farmService;

    @GetMapping("/list")
    public ResponseEntity<List<Farm>> allFarms(){

        List<Farm> farms = farmService.findAll();

        return ResponseEntity.ok(farms);
    }

    @PostMapping("/")
    public ResponseEntity<Farm> addFarm(@RequestBody FarmDTO farmDTO) {
        
        Farm farm = new Farm(farmDTO);
        farmService.save(farm);

        return ResponseEntity.ok(farm);
    }

   @PatchMapping("{id}")
   public ResponseEntity<Farm> updateFarm(@RequestBody FarmDTO farmDTO, @PathVariable int id){

        Optional<Farm> farmOpt = farmService.findById(id);

        if(farmOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Farm farm = farmOpt.get();
        farm.update(farmDTO);
        farmService.save(farm);

        return ResponseEntity.ok(farm);
   }
    
}

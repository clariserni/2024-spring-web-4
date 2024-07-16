package com.fattoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fattoria.pojo.Farmer;
import com.fattoria.repository.FarmerRepository;

@Service
public class FarmerService {

    @Autowired 
    private FarmerRepository farmerRepository;

    public Farmer save(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public Optional<Farmer> findById(int id) {
        return farmerRepository.findById(id);
    }

    public List<Farmer> findAll() {
        return farmerRepository.findAll();
    }

    public void delete(Farmer farmer) {
        farmerRepository.delete(farmer);
    }
}

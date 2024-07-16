package com.fattoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fattoria.pojo.Farm;
import com.fattoria.repository.FarmRepository;

@Service
public class FarmService {

    @Autowired 
    FarmRepository farmRepository;

     public Farm save(Farm farm) {
        return farmRepository.save(farm);
    }

    public Optional<Farm> findById(int id) {
        return farmRepository.findById(id);
    }

    public List<Farm> findAll() {
        return farmRepository.findAll();
    }

    public void delete(Farm farm) {
        farmRepository.delete(farm);
    }
}

package com.fattoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fattoria.pojo.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Integer>{

}

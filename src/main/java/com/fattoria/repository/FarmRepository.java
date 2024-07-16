package com.fattoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fattoria.pojo.Farm;

public interface FarmRepository extends JpaRepository<Farm, Integer>{

}

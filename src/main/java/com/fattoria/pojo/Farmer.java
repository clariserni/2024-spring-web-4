package com.fattoria.pojo;

import com.fattoria.web.dto.FarmerDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 64)
    private String name;
    @Column(nullable = false, length = 64)
    private String surname;
    
    private int age;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Farm farm;

    public Farmer() {
    }

    public Farmer(String name, String surname, int age, Farm farm) {
        setName(name);;
        setSurname(surname);
        setAge(age);
        setFarm(farm);
    }

    public Farmer(FarmerDTO farmerDTO){
        update(farmerDTO);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public void update(FarmerDTO farmerDTO){
        setName(farmerDTO.getName());
        setSurname(farmerDTO.getSurname());
        setAge(farmerDTO.getAge());

    }
    @Override
    public String toString() {
        return "Farmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", fattoria=" + farm.getName() +
                '}';
    }
}


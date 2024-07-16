package com.fattoria.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fattoria.web.dto.FarmDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 64)
    private String name;
    @Column(nullable = false, length = 64)
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "farm")
    private List<Farmer> farmers;
    
    public Farm() {
    }

    public Farm(String name, String city) {
        setName(name);
        setCity(city);
    }

    public Farm(FarmDTO farmDTO){
        update(farmDTO);
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }

    public void update(FarmDTO farmDTO){
        setName(farmDTO.getName());
        setCity(farmDTO.getCity());
    }

    @Override
    public String toString() {
        return "Farm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}

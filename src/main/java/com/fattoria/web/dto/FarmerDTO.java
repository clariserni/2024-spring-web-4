package com.fattoria.web.dto;

public class FarmerDTO {

    private String name;
    private String surname;
    private int age;

    private int farmId;

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

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    @Override
    public String toString() {
        return "FarmerDTO [name=" + name + ", surname=" + surname + ", age=" + age + ", farmId=" + farmId + "]";
    }

    
}

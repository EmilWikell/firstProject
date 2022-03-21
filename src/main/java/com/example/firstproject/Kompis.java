package com.example.firstproject;


import lombok.Data;

@Data
public class Kompis {

    int id;
    String name;
    String adress;
    String phoneNumber;

    public Kompis(int id, String name, String adress, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }
}

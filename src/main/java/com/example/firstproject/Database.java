package com.example.firstproject;

/**
 *
 */
import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Kompis> myfriends = new ArrayList<Kompis>();

    public Database(){
        addtolist();
    }

    public List<Kompis> getMyfriends() {
        return myfriends;
    }

    public void addtolist(){
        myfriends.add(new Kompis(1, "Tom Ganemo", "Hammarvägen", "073332434"));
        myfriends.add(new Kompis(2, "Emil Wikell", "Stenvägen", "070476467467"));
        myfriends.add(new Kompis(3, "Johan Ekman", "Slöjvägen", "07645363872"));
        myfriends.add(new Kompis(4, "Daniel Svensson", "Stolsvägen", "0739876535"));
    }



}
package com.example.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ovn1c {


    public int luckyNumber(){
        return (int) (Math.random()*10) +1;
    }

    public String luckyAnimal(){
        List<String> animalList = List.of("Cat","Dog","Sheep","Horse","Cow","Tiger","Pig");
        return animalList.get((int) (Math.random() * animalList.size()));
    }

    @RequestMapping("/LuckyYouPerson")
    public String luckyYouPerson(@RequestParam(required = false)String firstName
            , @RequestParam(required = false)String lastName, @RequestParam(required = true) String luckyType){
        String output = "";
        if (firstName != null) {
            output += firstName;
            if (lastName != null) {
                output += " " + lastName;
            }
        }
        else if(lastName != null){
            output += lastName;
        }
        else{
            output += "Guest";
        }
        if (luckyType.equals("animal")){
            output += "" + luckyAnimal();
        }
        else if(luckyType.equals("number")){
            output += " , your lucky number is " + String.valueOf(luckyNumber());
        }
        else{
            output += " ,You have to enter a luckyType!";
        }
    }
}

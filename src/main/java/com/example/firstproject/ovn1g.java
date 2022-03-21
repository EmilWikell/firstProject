package com.example.firstproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ovn1g {


    public int luckyNumber(){
        return (int) (Math.random()*10) +1;
    }

    public String luckyAnimal(){
        List<String> animalList = List.of("Cat","Dog","Sheep","Horse","Cow","Tiger","Pig");
        return animalList.get((int) (Math.random() * animalList.size()));
    }

    @RequestMapping("/luckyPage/{luckyYou}")
    public String luckyPage(@PathVariable String luckyYou){
        if (luckyYou.equals("animal")){
            return luckyAnimal();
        }
        else if(luckyYou.equals("number")){
            return String.valueOf(luckyNumber());
        }
        return "Wrong param";
    }
}

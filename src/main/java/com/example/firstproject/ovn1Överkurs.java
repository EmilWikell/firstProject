package com.example.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ovn1Överkurs {


    //http://localhost:8080/luckyPageHtml?luckyYou=animal

    public int luckyNumber(){
        return (int) (Math.random()*10) +1;
    }

    public String luckyAnimal(){
        List<String> animalList = List.of("Cat","Dog","Sheep","Horse","Cow","Tiger","Pig");
        return animalList.get((int) (Math.random() * animalList.size()));
    }

    @RequestMapping("/luckyPageHtml2")
    public String luckyPage(@RequestParam String luckyYou){
        String output = "";
        if (luckyYou.equals("animal")){
            output+= luckyAnimal();
        }
        else if(luckyYou.equals("number")){
            output+= String.valueOf(luckyNumber());
        }
        else {
            output += "Wrong param";
        }
        return "<Head><link rel='stylesheet href = 'style.css'/></Head>"
                +"<H1>"+output+"</H1>";
    }
}

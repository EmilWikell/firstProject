package com.example.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ovn1f {

    @RequestMapping("/ovn1f")
    public String availableList(@RequestParam List<Integer> unluckyList){
        return luckyNumber(unluckyList).toString();
    }

    public List<Integer> luckyNumber(List<Integer> unluckyList) {
        List<Integer> toTen = List.of(1,2,3,4,5,6,7,8,9,10);
        return toTen.stream().filter(integer -> !unluckyList.contains(integer)).collect(Collectors.toList());
    }
}

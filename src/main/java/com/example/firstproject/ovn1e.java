package com.example.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ovn1e {

    @RequestMapping("/inParamAsList")
    public String inParamAsList(@RequestParam List<Integer> unluckyNumberList){
        return String.valueOf(luckyNumber(unluckyNumberList));
    }

    public int luckyNumber(List<Integer> unluckyList) {
        while (true) {
            int num = (int) (Math.random() * 10) + 1;
            if (0 == unluckyList.stream().filter(integer -> num == integer).toList().size()) {
                return num;
            }
        }
    }
}

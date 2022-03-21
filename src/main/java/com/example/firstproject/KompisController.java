package com.example.firstproject;

import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class KompisController {
    Database dao =  new Database();

    @RequestMapping("/kompisar")
    public List<Kompis> kompisar(){
        return dao.getMyfriends();
    }

    @RequestMapping("/kompis/{name}")
    public List<Kompis> specifikKompis(@PathVariable String name){
        return dao.getMyfriends().stream().filter(e -> e.getName().contains(name)).collect(Collectors.toList());
    }

    @RequestMapping("/kompis/{name}/delete")
    public ResponseKompis response(@PathVariable("name") String name){
        for (Kompis kompis: dao.getMyfriends()) {
            if (kompis.getName().equals(name)){
                dao.getMyfriends().remove(dao.getMyfriends().stream().filter(e -> e.getName().equals(kompis.getName())).toList().get(0)); // här borde vi kunna delete på namn bara

                return new ResponseKompis("Friend deleted",true);
            }
        }
        return new ResponseKompis("Friend deleted", false);
    }
}

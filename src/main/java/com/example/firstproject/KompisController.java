package com.example.firstproject;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class KompisController {
    Database dao =  new Database();
    List<Kompis> kompisList = dao.getMyfriends();

    @RequestMapping("/kompisar")
    public List<Kompis> kompisar(){
        return kompisList;
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
    @PostMapping("/kompis/addFriend")
    public ResponseKompis addFriend(@RequestBody Kompis kompis){
        ResponseKompis responseKompis = new ResponseKompis("Friend Added",Boolean.FALSE);
        dao.getMyfriends().add(kompis);
        responseKompis.setStatus(Boolean.TRUE);
        return responseKompis;
    }

    @RequestMapping("/kompis/update")
    public ResponseKompis upsertFriend(@RequestBody Kompis kompis) throws Exception {
        ResponseKompis responseKompis = new ResponseKompis("Error", Boolean.FALSE);
        Kompis existingFriend = findFriendById(kompis);
        if (existingFriend !=null){
            kompisList.set(getKompisListIndex(existingFriend),kompis);
            responseKompis.setMessage("Friend Updated");
            responseKompis.setStatus(Boolean.TRUE);
        }else{
            responseKompis.setMessage("Friend added");
            responseKompis.setStatus(Boolean.TRUE);
            dao.getMyfriends().add(kompis);
        }
        return responseKompis;
    }

    public Kompis findFriendById(Kompis kompis){
         if (kompisList.stream().anyMatch(e-> e.getId() == kompis.getId())){
             return kompisList.stream().filter(e-> e.getId() == kompis.getId()).toList().get(0);
         }
         else return null;
    }
    public int getKompisListIndex(Kompis existingFriend) throws Exception {
        for (int i = 0; i < kompisList.size(); i++) {
            if (existingFriend.getId() == kompisList.get(i).getId()) {
                return i;
            }
        }
        throw new Exception();
    }
}

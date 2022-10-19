package com.usa.misiontic23.masterclass4.controller;


import com.usa.misiontic23.masterclass4.entities.Box;
import com.usa.misiontic23.masterclass4.entities.Category;
import com.usa.misiontic23.masterclass4.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Box")

public class BoxController {
    @Autowired
    private BoxService boxService;

    @GetMapping("/all")
    public List<Box> getAll(){
        return boxService.getALL();
    }
    @GetMapping("/{id}")
    public Optional<Box> getTool(@PathVariable("id") int id){
        return boxService.getBox(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Box save(@RequestBody Box p){
        return boxService.save(p);
    }


    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Box update(@RequestBody Box p){
        return BoxService.update(p);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return BoxService.delete(id);
    }

}

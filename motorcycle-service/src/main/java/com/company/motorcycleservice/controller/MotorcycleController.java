package com.company.motorcycleservice.controller;


import com.company.motorcycleservice.model.Motorcycle;
import com.company.motorcycleservice.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/motorcycle")
public class MotorcycleController {

    MotorcycleRepository motorcycleRepository;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Motorcycle addMotorcycle(@RequestBody @Valid Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Motorcycle getMotorcycle(@PathVariable int id) {
        return motorcycleRepository.getOne(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Motorcycle> getAllMotorcycle() {
        return motorcycleRepository.findAll();
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void updateMotorcycle( @RequestBody Motorcycle motorcycle) {
        motorcycleRepository.save(motorcycle);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteMotorcycle(@PathVariable int id) {
        motorcycleRepository.deleteById(id);
    }

}

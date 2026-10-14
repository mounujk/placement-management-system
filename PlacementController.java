package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Placement;
import com.example.demo.service.PlacementService;

@RestController
@RequestMapping("/api/placements")
public class PlacementController {

    @Autowired
    private PlacementService pser;

    @PostMapping("/addplacement")
    public Placement addPlacement(@RequestBody Placement p) {
        return pser.addPlacement(p);
    }

    @GetMapping("/getplacements")
    public List<Placement> getPlacements() {
        return pser.getPlacements();
    }

    @DeleteMapping("/deleteplacement/{id}")
    public void deletePlacement(@PathVariable Integer id) {
        pser.deletePlacement(id);
    }

    @PutMapping("/updateplacement")
    public Placement updatePlacement(@RequestBody Placement p) {
        return pser.updatePlacement(p);
    }
}

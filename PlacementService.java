package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Placement;
import com.example.demo.repository.PlacementRepository;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository prepo;

    public Placement addPlacement(Placement p) {
        return prepo.save(p);
    }

    public List<Placement> getPlacements() {
        return prepo.findAll();
    }

    public void deletePlacement(int id) {
        prepo.deleteById(id);
    }

    public Placement updatePlacement(Placement p) {
        Placement old = prepo.findById(p.getPlacementId())
                .orElseThrow(() -> new RuntimeException("Placement not found: " + p.getPlacementId()));
        old.setCompanyName(p.getCompanyName());
        old.setJobRole(p.getJobRole());
        old.setPackageLpa(p.getPackageLpa());
        old.setLocation(p.getLocation());
        old.setDriveDate(p.getDriveDate());
        old.setStatus(p.getStatus());
        return prepo.save(old);
    }
}

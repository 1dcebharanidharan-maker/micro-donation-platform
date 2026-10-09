package com.microdonation.controller;

import com.microdonation.model.Donation;
import com.microdonation.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/donations")
public class DonationController {
    @Autowired
    private DonationService donationService;
    
    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) {
        return donationService.saveDonation(donation);
    }
    
    @GetMapping
    public List<Donation> getAllDonations() {
        return donationService.getAllDonations();
    }
    
    @GetMapping("/campaign/{campaignId}")
    public List<Donation> getDonationsByCampaign(@PathVariable Long campaignId) {
        return donationService.getDonationsByCampaign(campaignId);
    }
    
    @GetMapping("/user/{userId}")
    public List<Donation> getDonationsByUser(@PathVariable Long userId) {
        return donationService.getDonationsByUser(userId);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable Long id) {
        return donationService.getDonationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
package com.microdonation.controller;

import com.microdonation.model.Campaign;
import com.microdonation.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;
    
    @PostMapping
    public Campaign createCampaign(@RequestBody Campaign campaign) {
        return campaignService.saveCampaign(campaign);
    }
    
    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }
    
    @GetMapping("/active")
    public List<Campaign> getActiveCampaigns() {
        return campaignService.getActiveCampaigns();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaignById(@PathVariable Long id) {
        return campaignService.getCampaignById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
package com.microdonation.controller;

import com.microdonation.service.CampaignService;
import com.microdonation.service.UserService;
import com.microdonation.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {
    @Autowired
    private CampaignService campaignService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private DonationService donationService;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("campaigns", campaignService.getActiveCampaigns());
        return "index";
    }
    
    @GetMapping("/campaigns")
    public String campaigns(Model model) {
        model.addAttribute("campaigns", campaignService.getAllCampaigns());
        return "campaigns";
    }
    
    @GetMapping("/create-campaign")
    public String createCampaign(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "create-campaign";
    }
    
    @GetMapping("/create-user")
    public String createUser() {
        return "create-user";
    }
    
    @GetMapping("/campaign/{id}")
    public String campaignDetails(@PathVariable Long id, Model model) {
        model.addAttribute("campaign", campaignService.getCampaignById(id).orElse(null));
        model.addAttribute("donations", donationService.getDonationsByCampaign(id));
        model.addAttribute("users", userService.getAllUsers());
        return "campaign-details";
    }
    
    @GetMapping("/test")
    public String test() {
        return "index";
    }
}
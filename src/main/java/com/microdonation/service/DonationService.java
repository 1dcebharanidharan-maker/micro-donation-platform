package com.microdonation.service;

import com.microdonation.model.Donation;
import com.microdonation.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;
    
    @Autowired
    private CampaignService campaignService;
    
    public Donation saveDonation(Donation donation) {
        Donation savedDonation = donationRepository.save(donation);
        campaignService.updateRaisedAmount(donation.getCampaign().getCampaignId());
        return savedDonation;
    }
    
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }
    
    public Optional<Donation> getDonationById(Long id) {
        return donationRepository.findById(id);
    }
    
    public List<Donation> getDonationsByCampaign(Long campaignId) {
        return donationRepository.findByCampaign_CampaignId(campaignId);
    }
    
    public List<Donation> getDonationsByUser(Long userId) {
        return donationRepository.findByUser_UserId(userId);
    }
}
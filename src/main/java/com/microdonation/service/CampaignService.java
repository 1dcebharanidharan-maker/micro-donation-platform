package com.microdonation.service;

import com.microdonation.model.Campaign;
import com.microdonation.repository.CampaignRepository;
import com.microdonation.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;
    
    @Autowired
    private DonationRepository donationRepository;
    
    public Campaign saveCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }
    
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }
    
    public Optional<Campaign> getCampaignById(Long id) {
        return campaignRepository.findById(id);
    }
    
    public List<Campaign> getActiveCampaigns() {
        return campaignRepository.findActiveCampaigns();
    }
    
    public void updateRaisedAmount(Long campaignId) {
        BigDecimal totalRaised = donationRepository.getTotalDonationsByCampaign(campaignId);
        if (totalRaised == null) totalRaised = BigDecimal.ZERO;
        
        Optional<Campaign> campaign = campaignRepository.findById(campaignId);
        if (campaign.isPresent()) {
            campaign.get().setRaisedAmount(totalRaised);
            campaignRepository.save(campaign.get());
        }
    }
}
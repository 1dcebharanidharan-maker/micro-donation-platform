package com.microdonation.repository;

import com.microdonation.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByCampaign_CampaignId(Long campaignId);
    List<Donation> findByUser_UserId(Long userId);
    
    @Query("SELECT SUM(d.amount) FROM Donation d WHERE d.campaign.campaignId = ?1 AND d.paymentStatus = 'PAID'")
    BigDecimal getTotalDonationsByCampaign(Long campaignId);
}
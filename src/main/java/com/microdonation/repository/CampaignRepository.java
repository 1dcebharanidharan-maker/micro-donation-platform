package com.microdonation.repository;

import com.microdonation.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findByCreatedBy_UserId(Long userId);
    
    @Query("SELECT c FROM Campaign c WHERE c.endDate >= CURRENT_DATE")
    List<Campaign> findActiveCampaigns();
}
package com.microdonation.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaign_id")
    private Long campaignId;
    
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "goal_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal goalAmount;
    
    @Column(name = "raised_amount", precision = 10, scale = 2)
    private BigDecimal raisedAmount = BigDecimal.ZERO;
    
    @Column(name = "start_date")
    private LocalDate startDate;
    
    @Column(name = "end_date")
    private LocalDate endDate;
    
    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    private User createdBy;
    
    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Donation> donations;
    
    public Long getCampaignId() { return campaignId; }
    public void setCampaignId(Long campaignId) { this.campaignId = campaignId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getGoalAmount() { return goalAmount; }
    public void setGoalAmount(BigDecimal goalAmount) { this.goalAmount = goalAmount; }
    public BigDecimal getRaisedAmount() { return raisedAmount; }
    public void setRaisedAmount(BigDecimal raisedAmount) { this.raisedAmount = raisedAmount; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }
    public List<Donation> getDonations() { return donations; }
    public void setDonations(List<Donation> donations) { this.donations = donations; }
}
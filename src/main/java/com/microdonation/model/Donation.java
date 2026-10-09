package com.microdonation.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donation_id")
    private Long donationId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "campaign_id", referencedColumnName = "campaign_id")
    private Campaign campaign;
    
    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
    
    @PrePersist
    @PreUpdate
    private void validateAmount() {
        if (amount != null && amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Donation amount must be positive");
        }
    }
    
    @Column(name = "donation_date")
    private LocalDateTime donationDate = LocalDateTime.now();
    
    @Column(name = "payment_status", length = 20)
    private String paymentStatus = "PENDING";
    
    @Column(name = "payment_mode", length = 50)
    private String paymentMode;
    
    public Long getDonationId() { return donationId; }
    public void setDonationId(Long donationId) { this.donationId = donationId; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Campaign getCampaign() { return campaign; }
    public void setCampaign(Campaign campaign) { this.campaign = campaign; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public LocalDateTime getDonationDate() { return donationDate; }
    public void setDonationDate(LocalDateTime donationDate) { this.donationDate = donationDate; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }
}
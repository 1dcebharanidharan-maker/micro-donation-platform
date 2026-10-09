package com.microdonation.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name = "contact_no", length = 20)
    private String contactNo;
    
    @Column(name = "join_date")
    private LocalDateTime joinDate = LocalDateTime.now();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Donation> donations;
    
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Campaign> campaigns;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }
    public LocalDateTime getJoinDate() { return joinDate; }
    public void setJoinDate(LocalDateTime joinDate) { this.joinDate = joinDate; }
    public List<Donation> getDonations() { return donations; }
    public void setDonations(List<Donation> donations) { this.donations = donations; }
    public List<Campaign> getCampaigns() { return campaigns; }
    public void setCampaigns(List<Campaign> campaigns) { this.campaigns = campaigns; }
}
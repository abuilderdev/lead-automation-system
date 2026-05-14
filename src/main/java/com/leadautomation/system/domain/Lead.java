package com.leadautomation.system.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    protected Lead() {}

    public static Lead create(String name, String email) {
        Lead lead = new Lead();
        lead.name = name;
        lead.email = email;
        lead.status = LeadStatus.NEW;
        return lead;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public LeadStatus getStatus() { return status; }

    public void setStatus(LeadStatus status) {
        this.status = status;
    }
}

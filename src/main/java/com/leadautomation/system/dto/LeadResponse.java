package com.leadautomation.system.dto;

import com.leadautomation.system.domain.LeadStatus;

public class LeadResponse {
    public Long id;
    public String name;
    public String email;
    public LeadStatus status;

    public LeadResponse(Long id, String name, String email, LeadStatus status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
    }
}
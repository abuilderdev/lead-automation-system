package com.leadautomation.system.service;

import com.leadautomation.system.domain.*;
import com.leadautomation.system.dto.*;
import com.leadautomation.system.exception.LeadNotFoundException;
import com.leadautomation.system.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    private final LeadRepository repo;

    public LeadService(LeadRepository repo) {
        this.repo = repo;
    }

    public LeadResponse create(CreateLeadRequest req) {
        Lead lead = Lead.create(req.name, req.email);
        Lead saved = repo.save(lead);
        return map(saved);
    }

    public List<LeadResponse> getAll() {
        return repo.findAll().stream()
                .map(this::map)
                .toList();
    }

    public LeadResponse getById(Long id) {
        Lead lead = repo.findById(id)
                .orElseThrow(() -> new LeadNotFoundException(id));

        return map(lead);
    }

    public LeadResponse updateStatus(Long id, UpdateLeadStatusRequest req) {
        Lead lead = repo.findById(id)
                .orElseThrow(() -> new LeadNotFoundException(id));

        lead.setStatus(LeadStatus.valueOf(req.status));

        return map(repo.save(lead));
    }

    private LeadResponse map(Lead lead) {
        return new LeadResponse(
                lead.getId(),
                lead.getName(),
                lead.getEmail(),
                lead.getStatus()
        );
    }
}
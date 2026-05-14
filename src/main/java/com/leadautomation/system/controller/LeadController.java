package com.leadautomation.system.controller;

import com.leadautomation.system.dto.*;
import com.leadautomation.system.service.LeadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {

    private final LeadService service;

    public LeadController(LeadService service) {
        this.service = service;
    }

    @PostMapping
    public LeadResponse create(@RequestBody CreateLeadRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<LeadResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LeadResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PatchMapping("/{id}/status")
    public LeadResponse updateStatus(@PathVariable Long id,
                                     @RequestBody UpdateLeadStatusRequest req) {
        return service.updateStatus(id, req);
    }
}

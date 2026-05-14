package com.leadautomation.system.exception;

public class LeadNotFoundException extends RuntimeException {
    public LeadNotFoundException(Long id) {
        super("Lead not found: " + id);
    }
}

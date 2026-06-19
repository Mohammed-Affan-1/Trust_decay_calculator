package com.trust.service;

import org.springframework.stereotype.Service;

@Service
public class TrustService {

    private double trust = 50;

    public double updateTrust(double impact) {
        trust = Math.max(0, Math.min(100, trust + impact));
        return trust;
    }

    public double getTrust() {
        return trust;
    }
}

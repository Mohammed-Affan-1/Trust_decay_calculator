package com.trust.controller;

import com.trust.service.TrustService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trust")
public class TrustController {

    private final TrustService service;

    public TrustController(TrustService service) {
        this.service = service;
    }

    @PostMapping("/event/{impact}")
    public double update(@PathVariable double impact) {
        return service.updateTrust(impact);
    }

    @GetMapping("/score")
    public double score() {
        return service.getTrust();
    }

    @GetMapping("/combined/{score}")
    public Object combined(@PathVariable int score) {

        org.springframework.web.client.RestTemplate restTemplate =
                new org.springframework.web.client.RestTemplate();

        String url = "http://localhost:5000/predict";

        java.util.Map<String, Integer> request = new java.util.HashMap<>();
        request.put("score", score);

        java.util.Map response =
                restTemplate.postForObject(url, request, java.util.Map.class);

        double trust = service.getTrust();
        int careerRisk = Integer.parseInt(response.get("careerRisk").toString());

        String finalRisk;
        if (trust < 40 || careerRisk > 60) {
            finalRisk = "HIGH";
        } else if (trust < 70) {
            finalRisk = "MEDIUM";
        } else {
            finalRisk = "LOW";
        }

        java.util.Map<String, Object> result = new java.util.HashMap<>();
        result.put("trustScore", trust);
        result.put("careerRisk", careerRisk);
        result.put("finalRisk", finalRisk);

        return result;
    }
}
        

package com.trust.service;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class DirectoryService {

    public static class DirectoryInfo {
        public String entityId;
        public String role;
        public String department;
        public String devicePosture;
        public String criticality;

        public DirectoryInfo(String entityId, String role, String department, String devicePosture, String criticality) {
            this.entityId = entityId;
            this.role = role;
            this.department = department;
            this.devicePosture = devicePosture;
            this.criticality = criticality;
        }
    }

    private static final Map<String, DirectoryInfo> DIRECTORY = Map.of(
        "user1", new DirectoryInfo("Mohammed Affan", "Security professional", "Sales=10000", "Compliant=Nope", "High"),
        "user2", new DirectoryInfo("Dharun", "Developer", "IT", "Compliant=Nope", "Medium"),
        "device1", new DirectoryInfo("device1", "Device", "Engineering", "Non-Compliant", "High"),
        "service1", new DirectoryInfo("service1", "Service", "Payments", "N/A", "Critical")
    );

    public DirectoryInfo getInfo(String entityId) {
        return DIRECTORY.getOrDefault(entityId,
            new DirectoryInfo(entityId, "trust", "Account", "Validation", "Monitoring"));
    }
}


 

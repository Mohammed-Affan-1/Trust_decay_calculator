Trust Decay Calculator Prototype
Overview

The Trust Decay Calculator Prototype is a cybersecurity-focused application designed to demonstrate the principles of Zero Trust Architecture (ZTA). The system continuously evaluates trust levels based on user activities and combines them with external risk predictions to determine an overall security risk score.

This prototype simulates how organizations can dynamically adjust access privileges based on trust scores rather than relying on static authentication methods.

Features
Dynamic Trust Score Calculation
Zero Trust Security Model Simulation
REST API-Based Architecture
Risk Classification Engine
Integration with External AI/ML Risk Prediction Service
Real-Time Trust Monitoring
Spring Boot Backend Implementation
Technology Stack
Java 17
Spring Boot
Maven
REST APIs
JSON
Zero Trust Architecture Concepts

System Workflow
User activity generates a trust event.
The Trust Service updates the trust score.
The system retrieves entity information from the Directory Service.
An external AI prediction service calculates career risk.
Trust score and career risk are combined.
Final risk is categorized as:
Trust Score	Career Risk	Final Risk

< 40	Any	HIGH
Any	> 60	HIGH
40 - 69	≤ 60	MEDIUM
≥ 70	≤ 60	LOW

API Endpoints
Update Trust Score
POST /trust/event/{impact}

Example:

POST /trust/event/-10

Response:

40.0
Get Current Trust Score
GET /trust/score

Response:

50.0
Get Combined Risk Assessment
GET /trust/combined/{score}

Example:

GET /trust/combined/75

Response:

{
  "trustScore": 50.0,
  "careerRisk": 35,
  "finalRisk": "LOW"
}
Installation Guide
Prerequisites

Install the following:

Java 17

Verify installation:

java -version

Expected output:

openjdk version "17"
Maven

Verify installation:

mvn -version

Expected output:

Apache Maven 3.x.x
Clone Repository
git clone https://github.com/your-username/trust-decay-calculator.git
cd trust-decay-calculator/trustapp
Build Project
mvn clean install
Run Application
mvn spring-boot:run

Or

java -jar target/trustapp-0.0.1-SNAPSHOT.jar
Access Application

Default Port:

http://localhost:8081

Test endpoint:

http://localhost:8081/trust/score
Sample cURL Commands
Get Trust Score
curl http://localhost:8081/trust/score
Update Trust
curl -X POST http://localhost:8081/trust/event/-15
Combined Risk
curl http://localhost:8081/trust/combined/80
Future Enhancements
Blockchain-based Trust Event Logging
MySQL Database Integration
User Authentication and Authorization
Dashboard Visualization
Machine Learning-Based Risk Prediction
Docker Deployment
Kubernetes Support
Role-Based Access Control (RBAC)
Author

Mohammed Affan JA

Cybersecurity Enthusiast | Zero Trust Security Researcher | B.E CSE (Cyber Security)

package org.example.quickstart.service;

import org.example.quickstart.entity.RequestType;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public String handleRequest(RequestType requestType) {
        return switch (requestType){
            case QUERY -> handleQuery();
            case COMPLAINT -> handleComplaint();
            case SUGGESTION -> handleSuggestion();
        };

    }

    private String handleSuggestion() {
        return "Handling user suggestion";
    }

    private String handleComplaint() {
        return "Handling user complaint";
    }

    private String handleQuery() {
        return "Handling user query...";
    }
}

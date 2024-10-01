package com.example.boulderApp.errors;

public class CompetitionNotFoundException extends RuntimeException {
    public CompetitionNotFoundException() {
        super("Competition not found");
    }
}

package com.example.boulderApp.errors;

public class BoulderNotFoundException extends RuntimeException{
    public BoulderNotFoundException(){
        super("Boulder not found");
    }
}

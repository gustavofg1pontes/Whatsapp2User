package com.ifsp.whatsapp2user.models.message;

public record Message(String message, String username) {

    @Override
    public String toString() {
        return username + ": " + message;
    }
}
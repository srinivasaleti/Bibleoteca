package com.patashala57.model;

public class User {

    private final String name;
    private final String libraryNo;
    private final String password;
    private final String email;
    private final String phoneNumber;

    public User(String name, String libraryNo, String password, String email, String phoneNumber) {
        this.name = name;
        this.libraryNo = libraryNo;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    boolean hasSameCredentials(String libraryNo, String password) {
        return this.libraryNo.equals(libraryNo) && this.password.equals(password);
    }

    String representation() {
       return String.format("%-35s %-35s %-35s",name,email,phoneNumber);
    }

}


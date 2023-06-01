package com.example.demo;

public class Customer {
    private String username;

    private String firstname;
    private String lastname;

    private String subscription;

    private String mail;
    private Movement[] movements;

    private String phone;

    private String address;

    public Customer(String username, String firstname, String lastname, String subscription, String mail, Movement[] movements, String phone, String address) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.subscription = subscription;
        this.mail = mail;
        this.movements = movements;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return username;
    }

    public String getUsername() {
        return username;
    }

    public String getSubscription() {
        return subscription;
    }

    public Movement[] getMovements() {
        return movements;
    }

    public String getMail() {
        return mail;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}

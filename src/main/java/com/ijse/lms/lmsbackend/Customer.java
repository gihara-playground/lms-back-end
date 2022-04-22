package com.ijse.lms.lmsbackend;

import jakarta.json.bind.annotation.JsonbProperty;

public class Customer {

    private String name;
    private String nic;
    private String email;

    public Customer(String nic, String name, String email) {
        this.nic = nic;
        this.name = name;
        this.email = email;
        System.out.println("Customer() - full arg");
    }

    public Customer() {
        System.out.println("Customer() - no arg");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
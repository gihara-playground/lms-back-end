package com.ijse.lms.lmsbackend.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    private String id;
    private String name;
    private String email;
    private String nic;

    public StudentDTO() {
    }

    public StudentDTO(String name, String email, String nic) {
        this.name = name;
        this.email = email;
        this.nic = nic;
    }

    public StudentDTO(String id, String name, String email, String nic) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nic = nic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}

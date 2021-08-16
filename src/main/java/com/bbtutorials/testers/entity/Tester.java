package com.bbtutorials.testers.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tester")
public class Tester {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotNull(message="{NotNull.Tester.firstName}")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message="{NotNull.Tester.lastName}")
    private String lastName;

    @Column(name = "country")
    @NotNull(message="{NotNull.Tester.email}")
    private String country;

    @Column(name = "last_login")
    @NotNull(message="{NotNull.Tester.lastLogin}")
    private String lastLogin;


    public Tester(int id, String firstName, String lastName, String country, String lastLogin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.lastLogin = lastLogin;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "Tester [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +"]";
    }
}

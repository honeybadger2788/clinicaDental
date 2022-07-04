package com.example.clinicaDental.entity;

import javax.persistence.*;

@Entity
@Table(name = "domicilios")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String street;
    private int number;
    private String city;
    private String province;

    public Address() {
    }

    public Address(String street, int number, String city, String province) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}

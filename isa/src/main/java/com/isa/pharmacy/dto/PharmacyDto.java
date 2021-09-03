package com.isa.pharmacy.dto;

import com.isa.pharmacy.domain.Pharmacy;

public class PharmacyDto {

    private String description;
    private String name;
    private Double latitude;
    private Double longitude;
    private String city;
    private String country;
    private String address;
    private String zipCode;
    private Long id;

    public PharmacyDto() {
    }

    public PharmacyDto(Pharmacy pharmacy) {
        this.id = pharmacy.getId();
        this.description = pharmacy.getDescription();
        this.address = pharmacy.getAddress().getStreet();
        this.city = pharmacy.getAddress().getCity().getName();
        this.zipCode = pharmacy.getAddress().getCity().getZipCode();
        this.country = pharmacy.getAddress().getCity().getCountry().getName();
        this.latitude = pharmacy.getAddress().getLocation().getLatitude();
        this.longitude = pharmacy.getAddress().getLocation().getLongitude();
        this.zipCode = pharmacy.getAddress().getCity().getZipCode();
        this.name = pharmacy.getName();
    }

    public PharmacyDto(String description, String name, Double latitude, Double longitude, String city, String country, String address, Long id, String zipCode) {
        this.description = description;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.country = country;
        this.address = address;
        this.id = id;
        this.zipCode = zipCode;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }
}

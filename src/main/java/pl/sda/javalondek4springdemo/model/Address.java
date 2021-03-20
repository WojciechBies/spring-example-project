package pl.sda.javalondek4springdemo.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String city;

    private String street;

    private Long number;

    public Address(String city, String street, Long number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Long getNumber() {
        return number;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}

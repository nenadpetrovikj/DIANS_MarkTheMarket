package mk.finki.ukim.lab.dians_markthemarket.hw3.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String website;
    private String type;
    private String number;
    private String address;
    private String municipality;
    private String rating;
    private String reviews;
    private String hours;
    private String locationLink;

    public Market(String name, String website, String type, String number, String address, String municipality, String rating, String reviews, String hours, String locationLink) {
        this.name = name;
        this.website = website;
        this.type = type;
        this.number = number;
        this.address = address;
        this.municipality = municipality;
        this.rating = rating;
        this.reviews = reviews;
        this.hours = hours;
        this.locationLink = locationLink;
    }

    public Market() {

    }
}

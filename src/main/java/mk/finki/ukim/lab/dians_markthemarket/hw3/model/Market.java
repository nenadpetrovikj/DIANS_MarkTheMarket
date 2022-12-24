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
    private String type;
    private String municipality;
    private String rating;
    private String address;
    private String hours;
    private String website;
    private String number;
    private String reviews;
    private String locationLink;

    public Market(String name, String type, String municipality, String rating, String address, String hours, String website, String number, String reviews, String locationLink) {
        this.name = name;
        this.type = type;
        this.municipality = municipality;
        this.rating = rating;
        this.address = address;
        this.hours = hours;
        this.website = website;
        this.number = number;
        this.reviews = reviews;
        this.locationLink = locationLink;
    }

    public Market() {

    }
}

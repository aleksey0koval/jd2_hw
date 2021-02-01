package it.academy.pojos;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @Column(name = "A_CITY")
    private String city;

    @Column(name = "A_STREET")
    private String street;

    @Column(name = "A_POSTAL_CODE")
    private int postalCode;

}

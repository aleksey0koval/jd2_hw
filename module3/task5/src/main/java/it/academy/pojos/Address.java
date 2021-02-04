package it.academy.pojos;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(generator = "address")
    private Integer id;

    @Column(name = "A_CITY")
    public String city;

    @Column(name = "A_STREET")
    private String street;

    @Column(name = "A_POSTAL_CODE")
    private int postalCode;

}

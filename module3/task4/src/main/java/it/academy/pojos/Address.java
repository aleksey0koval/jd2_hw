package it.academy.pojos;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "T_ADDRESS")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Address {

    private Integer id;

    @Column(name = "A_CITY")
    @Access(AccessType.FIELD)
    private String city;

    @Column(name = "A_STREET")
    @Setter
    @Getter
    private String street;

    @Column(name = "A_POSTAL_CODE")
    @Setter
    @Getter
    private int postalCode;

    @Id
    @GeneratedValue(generator = "address")
    @Column(name = "ADDRESS_ID")
    @Access(AccessType.PROPERTY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}

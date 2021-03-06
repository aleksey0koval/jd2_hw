package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "T_PERSON")
public class Person implements Serializable {

    @Id
    @GeneratedValue(generator = "person")
    @Column(name = "ID_PERSON")
    private Integer id;
    @Column(name = "P_AGE")
    private Integer age;
    @Column(name = "P_NAME", length = 1000)
    private String name;
    @Column(name = "P_SURNAME", length = 1000)
    private String surname;

    @Embedded
    private Address address;
}

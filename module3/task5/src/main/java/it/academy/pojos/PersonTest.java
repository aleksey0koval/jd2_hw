package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PersonTest {

    @Id
    @GeneratedValue(generator = "person")
    @Column(name = "ID_PERSON_TEST")
    private Integer id;

    private String firstName;
    private String lastName;
}

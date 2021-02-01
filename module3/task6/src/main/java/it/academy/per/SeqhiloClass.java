package it.academy.per;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SeqhiloClass {

    @Id
    @GeneratedValue(generator = "seqhilo")
    @GenericGenerator(name = "seqhilo", strategy = "seqhilo")
    private Integer seqhilo;
}

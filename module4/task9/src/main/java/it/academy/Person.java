package it.academy;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {

    private int id;
    private String name;
    private String surname;

    @Autowired
    @Qualifier("addressNewImpl")
    IAddress address;
}

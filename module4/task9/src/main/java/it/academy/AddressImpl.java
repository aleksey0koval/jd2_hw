package it.academy;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AddressImpl implements IAddress {

    private int id1;
    private String city1;
    private String street1;

}

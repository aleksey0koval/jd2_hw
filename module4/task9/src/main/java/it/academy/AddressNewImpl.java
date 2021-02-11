package it.academy;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AddressNewImpl implements IAddress {

    private int id2;
    private String city2;
    private String street2;
}

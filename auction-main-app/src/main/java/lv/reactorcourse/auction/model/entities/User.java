package lv.reactorcourse.auction.model.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document
public class User {

    @Id
    private BigInteger id;

    private String username;

    public User() {
    }

    public User(BigInteger id, String username) {
        this.id = id;
        this.username = username;
    }
}

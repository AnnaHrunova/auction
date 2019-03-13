package lv.reactorcourse.auction.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

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

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

package lv.reactorcourse.auction.model.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Lot {

    @Id
    private String id;

    @DBRef
    private User createdBy;

    private LocalDateTime createdAt;

    public Lot() {
    }

    public Lot(User createdBy, LocalDateTime createdAt) {
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }
}

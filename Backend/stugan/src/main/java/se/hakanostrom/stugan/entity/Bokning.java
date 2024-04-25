package se.hakanostrom.stugan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "bokningar")
@Entity
@Data
public class Bokning {
    @Id
    @GeneratedValue
    private Long ID;
    private Long stuga_id;

    private String namn;
    private String telefon;
    private String epost;
}

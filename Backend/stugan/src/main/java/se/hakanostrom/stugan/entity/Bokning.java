package se.hakanostrom.stugan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "bokningar")
@Entity
@Getter
@Setter
public class Bokning {
    @Id
    @GeneratedValue
    private int ID;

    private String name;

    private String telefon;
    private String epost;
    private int stug_id;
}

package se.hakanostrom.stugan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "stugor")
@Entity
public class Stuga {

    @Id
    @GeneratedValue
    private Long ID;
    private String name;

    public String getName() {
        return name;
    }

    public Stuga setName(String name) {
        this.name = name;
        return this;
    }

    public Long getID() {
        return ID;
    }

    public Stuga setID(Long ID) {
        this.ID = ID;
        return this;
    }

}

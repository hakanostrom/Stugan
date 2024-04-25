package se.hakanostrom.stugan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "stugor")
@Entity
@Data
public class Stuga {

    @Id
    @GeneratedValue
    private Long ID;
    private String name;

}

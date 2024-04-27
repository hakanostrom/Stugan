package se.hakanostrom.stugan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "bokningar")
@Entity
public class Bokning {
    @Id
    @GeneratedValue
    private Long ID;
    private Long stuga_id;
    private String datum;

    private String namn;
    private String telefon;
    private String epost;

    public Long getID() {
        return ID;
    }

    public Bokning setID(Long ID) {
        this.ID = ID;
        return this;
    }

    public Long getStuga_id() {
        return stuga_id;
    }

    public Bokning setStuga_id(Long stuga_id) {
        this.stuga_id = stuga_id;
        return this;
    }

    public String getDatum() {
        return datum;
    }

    public Bokning setDatum(String datum) {
        this.datum = datum;
        return this;
    }

    public String getNamn() {
        return namn;
    }

    public Bokning setNamn(String namn) {
        this.namn = namn;
        return this;
    }

    public String getTelefon() {
        return telefon;
    }

    public Bokning setTelefon(String telefon) {
        this.telefon = telefon;
        return this;
    }

    public String getEpost() {
        return epost;
    }

    public Bokning setEpost(String epost) {
        this.epost = epost;
        return this;
    }
}

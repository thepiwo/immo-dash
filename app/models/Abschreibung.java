package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Philipp on 13.06.2015.
 */
@Entity
public class Abschreibung {

    @Id
    private int id;

    private String name;

    private String beschreibung;

    private double kosten;

    @ManyToOne(fetch = FetchType.LAZY)
    Immobilie immobilie;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public double getKosten() {
        return kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }

    public Immobilie getImmobilie() {
        return immobilie;
    }

    public void setImmobilie(Immobilie immobilie) {
        this.immobilie = immobilie;
    }

    public static Model.Finder<Long, Abschreibung> find = new Model.Finder<>(Long.class, Abschreibung.class);

}

package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Philipp on 13.06.2015.
 */
@Entity
public class Investition extends Model {

    @Id
    private int id;

    private double kosten;

    @Column(columnDefinition = "date")
    private Date datum;

    @Column(columnDefinition = "TEXT")
    private String beschreibung;

    @ManyToOne(fetch = FetchType.LAZY)
    Immobilie immobilie;

    public int getId() {
        return id;
    }

    public double getKosten() {
        return kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Immobilie getImmobilie() {
        return immobilie;
    }

    public void setImmobilie(Immobilie immobilie) {
        this.immobilie = immobilie;
    }

    public static Model.Finder<Long, Investition> find = new Model.Finder<>(Long.class, Investition.class);

}

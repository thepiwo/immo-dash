package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Philipp on 13.06.2015.
 */
@Entity
public class Mieter extends Model {

    @Id
    private int id;

    private String name;

    private double bewertung;

    private double miete;

    @Column(columnDefinition = "date")
    private Date mietStart;

    @Column(columnDefinition = "date")
    private Date mietEnde;

    @Column(columnDefinition = "TEXT")
    private String vertragsDetails;

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

    public double getBewertung() {
        return bewertung;
    }

    public void setBewertung(double bewertung) {
        this.bewertung = bewertung;
    }

    public double getMiete() {
        return miete;
    }

    public void setMiete(double miete) {
        this.miete = miete;
    }

    public Date getMietStart() {
        return mietStart;
    }

    public void setMietStart(Date mietStart) {
        this.mietStart = mietStart;
    }

    public Date getMietEnde() {
        return mietEnde;
    }

    public void setMietEnde(Date mietEnde) {
        this.mietEnde = mietEnde;
    }

    public String getVertragsDetails() {
        return vertragsDetails;
    }

    public void setVertragsDetails(String vertragsDetails) {
        this.vertragsDetails = vertragsDetails;
    }

    public Immobilie getImmobilie() {
        return immobilie;
    }

    public void setImmobilie(Immobilie immobilie) {
        this.immobilie = immobilie;
    }

    public static Model.Finder<Long, Mieter> find = new Model.Finder<>(Long.class, Mieter.class);

}

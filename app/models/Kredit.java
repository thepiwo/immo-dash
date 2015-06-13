package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Philipp on 13.06.2015.
 */
@Entity
public class Kredit extends Model {

    @Id
    private int id;

    private double betrag;

    private double rate;

    @Column(columnDefinition = "date")
    private Date kreditStart;

    @Column(columnDefinition = "date")
    private Date kreditEnde;

    @Column(columnDefinition = "TEXT")
    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    Immobilie immobilie;

    public int getId() {
        return id;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getKreditStart() {
        return kreditStart;
    }

    public void setKreditStart(Date kreditStart) {
        this.kreditStart = kreditStart;
    }

    public Date getKreditEnde() {
        return kreditEnde;
    }

    public void setKreditEnde(Date kreditEnde) {
        this.kreditEnde = kreditEnde;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Immobilie getImmobilie() {
        return immobilie;
    }

    public void setImmobilie(Immobilie immobilie) {
        this.immobilie = immobilie;
    }

    public static Model.Finder<Long, Kredit> find = new Model.Finder<>(Long.class, Kredit.class);

}

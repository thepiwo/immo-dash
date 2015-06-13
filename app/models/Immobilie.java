package models;


import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import play.Logger;
import play.data.Form;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.*;
import java.lang.Double;

/**
 * Created by Philipp on 13.06.2015.
 */
@Entity
public class Immobilie extends Model {

    @Id
    private int id;

    private String name;

    private double kaufPreis;

    @Column(columnDefinition = "date")
    private Date kaufDatum;

    private String typ;

    @Lob
    public String imagePath;

    @JsonBackReference
    @OneToMany(mappedBy = "immobilie", cascade = CascadeType.ALL)
    List<Mieter> mieter;

    @JsonBackReference
    @OneToMany(mappedBy = "immobilie", cascade = CascadeType.ALL)
    List<Investition> investitionen;

    @JsonBackReference
    @OneToMany(mappedBy = "immobilie", cascade = CascadeType.ALL)
    List<Kredit> kredite;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Mieter> getMieter() {
        return mieter;
    }

    public void setMieter(List<Mieter> mieter) {
        this.mieter = mieter;
    }

    public List<Investition> getInvestitionen() {
        return investitionen;
    }

    public void setInvestitionen(List<Investition> investitionen) {
        this.investitionen = investitionen;
    }

    public List<Kredit> getKredite() {
        return kredite;
    }

    public void setKredite(List<Kredit> kredite) {
        this.kredite = kredite;
    }

    public double getKaufPreis() {
        return kaufPreis;
    }

    public void setKaufPreis(double kaufPreis) {
        this.kaufPreis = kaufPreis;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Date getKaufDatum() {
        return kaufDatum;
    }

    public void setKaufDatum(Date kaufDatum) {
        this.kaufDatum = kaufDatum;
    }

    public double getInvestitionenSum() {
        double investitionssum = 0.0;
        for (Investition investition : investitionen) {
            investitionssum += investition.getKosten();
        }
        return investitionssum;
    }

    public double getKrediteSum() {
        double kreditesum = 0.0;
        for (Kredit kredit : kredite) {
            kreditesum += kredit.getBetrag();
        }
        return kreditesum;
    }

    public double getMietSum() {
        double mietsum = 0.0;
        for (Mieter miet : mieter) {
            mietsum += miet.getMiete();
        }
        return mietsum;
    }

    public static Finder<Long, Immobilie> find = new Finder<>(Long.class, Immobilie.class);

    public static Form<Immobilie> immoForm = Form.form(Immobilie.class);

    public double getWert() {
        return getKaufPreis() - getKrediteSum() - getInvestitionenSum() * Math.exp(-0.04);
    }

    public double calculateWert(long ts) {

        Date date = new Date(ts);

        if (kaufDatum == null) {
            return kaufPreis;
        }
        int quartalKaufdatum = 1 + (getKaufDatum().getMonth() - 1) / 3;
        int jahrKaufdatum = 1900 + getKaufDatum().getYear();
        int quartalAktuell = 1 + (date.getMonth() - 1) / 3;
        int jahrAktuell = 1900 + date.getYear();

        Logger.info("quartalKaufdatum: " + quartalKaufdatum);
        Logger.info("jahrKaufdatum: " + jahrKaufdatum);
        Logger.info("quartalAktuell: " + quartalAktuell);
        Logger.info("jahrAktuell: " + jahrAktuell);

        double wertIndexJahr = PreisindexVDP.find.where().eq("quartal", quartalAktuell).eq("jahr", jahrAktuell).setMaxRows(1).findUnique().getValue();

        Logger.info("wertIndexJahr: "+wertIndexJahr);

        double wertIndexKauf = PreisindexVDP.find.where().eq("quartal", quartalKaufdatum).eq("jahr", jahrKaufdatum).setMaxRows(1).findUnique().getValue();

        Logger.info("wertIndexKauf: "+wertIndexKauf);


        double wert = kaufPreis + kaufPreis*((wertIndexJahr - wertIndexKauf)/100);

        Logger.info("Wert: "+wert);

        return wert;
    }
}

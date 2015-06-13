package models;


import com.avaje.ebean.Model;
import play.data.Form;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Philipp on 13.06.2015.
 */
@Entity
public class Immobilie extends Model {

    @Id
    private int id;

    private String name;

    @Lob
    public String imagePath;

    @OneToMany(mappedBy = "immobilie")
    List<Mieter> mieter;

    @OneToMany(mappedBy = "immobilie")
    List<Abschreibung> abschreibungen;

    @OneToMany(mappedBy = "immobilie")
    List<Investition> investitionen;

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

    public List<Abschreibung> getAbschreibungen() {
        return abschreibungen;
    }

    public void setAbschreibungen(List<Abschreibung> abschreibungen) {
        this.abschreibungen = abschreibungen;
    }

    public List<Investition> getInvestitionen() {
        return investitionen;
    }

    public void setInvestitionen(List<Investition> investitionen) {
        this.investitionen = investitionen;
    }

    public static Finder<Long, Immobilie> find = new Finder<>(Long.class, Immobilie.class);

    public static Form<Immobilie> immoForm = Form.form(Immobilie.class);
}

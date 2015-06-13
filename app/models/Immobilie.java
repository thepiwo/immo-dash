package models;


import com.avaje.ebean.Model;

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

    public static Finder<Long, Immobilie> find = new Finder<>(Long.class, Immobilie.class);
}

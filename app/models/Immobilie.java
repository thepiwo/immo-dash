package models;


import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Created by Philipp on 13.06.2015.
 */
@Entity
public class Immobilie extends Model {

    @Id
    private int id;

    private String name;

    @Lob
    public byte[] image;

    public static Finder<Long,Immobilie> find = new Finder<>(Long.class, Immobilie.class);
}

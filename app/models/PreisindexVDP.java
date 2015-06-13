package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by fa on 13.06.15.
 */
@Entity
public class PreisindexVDP {
    @Id
    private int id;
    @Column(columnDefinition = "int")
    private int jahr;
    @Column(columnDefinition = "int")
    private int quartal;
    @Column(columnDefinition = "double")
    private double value;

    public int getJahr() {
        return jahr;
    }

    public int getQuartal() {
        return quartal;
    }

    public double getValue() {
        return value;
    }


    public static Finder<Long, PreisindexVDP> find = new Finder<>(Long.class, PreisindexVDP.class);

}

package models;

import play.data.format.Formats;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Philipp on 13.06.2015.
 */
@Entity
public class Kredit {

    @Id
    private int id;

    private double betrag;

    private double rate;

    @Formats.DateTime(pattern = "yyyy-MM-dd")
    private Date kreditStart;

    @Formats.DateTime(pattern = "yyyy-MM-dd")
    private Date kreditEnde;

    @Column(columnDefinition = "TEXT")
    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    Immobilie immobilie;
}

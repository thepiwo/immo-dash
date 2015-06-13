package models;

import play.data.format.Formats;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Philipp on 13.06.2015.
 */
@Entity
public class Mieter {

    @Id
    private int id;

    private double bewertung;

    private double miete;

    @Formats.DateTime(pattern = "yyyy-MM-dd")
    private Date mietStart;

    @Formats.DateTime(pattern = "yyyy-MM-dd")
    private Date mietEnde;

    @Column(columnDefinition = "TEXT")
    private String vertragsDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    Immobilie immobilie;
}

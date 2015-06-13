package models;

import play.data.format.Formats;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Philipp on 13.06.2015.
 */
@Entity
public class Investition {

    @Id
    private int id;

    private double kosten;

    private double miete;

    @Formats.DateTime(pattern = "yyyy-MM-dd")
    private Date datum;

    @Column(columnDefinition = "TEXT")
    private String beschreibung;

    @ManyToOne(fetch = FetchType.LAZY)
    Immobilie immobilie;
}

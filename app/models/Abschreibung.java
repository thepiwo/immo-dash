package models;

import play.data.format.Formats;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Philipp on 13.06.2015.
 */
@Entity
public class Abschreibung {

    @Id
    private int id;

    private String name;

    private String beschreibung;

    private double kosten;

    @ManyToOne(fetch = FetchType.LAZY)
    Immobilie immobilie;
}

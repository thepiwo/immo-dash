package models;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by fa on 13.06.15.
 */
public class PreisindexVDP {
    @Column(columnDefinition = "jahr")
    private int jahr;

    @Column(columnDefinition = "quartal")
    private int quartal;

    @Column(columnDefinition = "value")
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
}

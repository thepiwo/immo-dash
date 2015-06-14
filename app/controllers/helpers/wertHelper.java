package controllers.helpers;

import models.Immobilie;
import models.Kredit;

import java.util.List;

/**
 * Created by Philipp on 14.06.2015.
 */
public class wertHelper {

    public static double calculateAllWert(long ts) {
        double gesWert = 0.0;
        List<Immobilie> immobilieList = Immobilie.find.findList();
        for (Immobilie immobilie : immobilieList) {
            gesWert += immobilie.calculateWert(ts);
        }
        return gesWert;
    }

    public static double getAllKreditAt(long ts) {
        double gesKredit = 0.0;
        List<Immobilie> immobilieList = Immobilie.find.findList();
        for (Immobilie immobilie : immobilieList) {
            gesKredit += immobilie.getKreditAt(ts);
        }
        return gesKredit;
    }

    public static int getScaleSteps() {
        int maxwert = 1;
        List<Immobilie> immobilieList = Immobilie.find.findList();
        for (Immobilie immobilie : immobilieList) {

            int wert = (int) ((immobilie.getKaufPreis() * 1.20)/100);
            if (wert > maxwert) {
                maxwert = wert;
            }
        }
        return maxwert;
    }
}

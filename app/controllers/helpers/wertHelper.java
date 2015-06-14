package controllers.helpers;

import models.Immobilie;
import models.Kredit;
import play.Logger;

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

    public static double getAllInvestitionAt(long ts) {
        double getInvest = 0.0;
        List<Immobilie> immobilieList = Immobilie.find.findList();
        for (Immobilie immobilie : immobilieList) {
            getInvest += immobilie.getInvestitionAt(ts);
        }
        return getInvest;
    }

    public static int getScaleSteps() {
        int maxwert = 1;
        List<Immobilie> immobilieList = Immobilie.find.findList();
        for (Immobilie immobilie : immobilieList) {
            int wert = (int) ((immobilie.getKaufPreis() * 1.20) / getScale());
            maxwert += wert;
        }
        return maxwert;
    }

    public static int getScale() {
        int scale = 1;
        List<Immobilie> immobilieList = Immobilie.find.findList();
        for (Immobilie immobilie : immobilieList) {
            int wert = (int) (immobilie.getKaufPreis() * 1.20);
            scale += wert;
        }
        String scaleString = scale + "";
        scale = Integer.parseInt("1" + nulltimes(scaleString.length() - 1));
        Logger.info("Scale: "+scale);

        return scale;
    }

    public static String nulltimes(int times) {
        String nul = "";
        for (int i = 0; i < times; i++) {
            nul += "0";
        }
        return nul;
    }
}

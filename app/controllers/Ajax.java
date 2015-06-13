package controllers;

import models.Immobilie;
import models.Investition;
import models.Kredit;
import models.Mieter;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Philipp on 13.06.15.
 */
public class Ajax extends Controller {

    public Result delInvestition(int id) {
        Investition investition = Investition.find.where().eq("id", id).findUnique();
        investition.delete();
        return ok("done");
    }

    public Result delKredit(int id) {
        Kredit kredit = Kredit.find.where().eq("id", id).findUnique();
        kredit.delete();
        return ok("done");
    }

    public Result delMieter(int id) {
        Mieter mieter = Mieter.find.where().eq("id", id).findUnique();
        mieter.delete();
        return ok("done");
    }

    public Result newMieter(int id) {

        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();

        Mieter mieter = new Mieter();
        DynamicForm requestData = Form.form().bindFromRequest();
        String name = requestData.get("new-mieter-name");
        String details = requestData.get("new-mieter-details");
        double bewertung = Double.parseDouble(requestData.get("new-mieter-bewertung"));
        double miete = Double.parseDouble(requestData.get("new-mieter-miete"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date dateVon = new Date();
        Date dateBis = new Date();

        try {
            dateVon = formatter.parse(requestData.get("new-mieter-von"));
            dateBis = formatter.parse(requestData.get("new-mieter-bis"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mieter.setBewertung(bewertung);
        mieter.setImmobilie(immo);
        mieter.setMiete(miete);
        mieter.setName(name);
        mieter.setMietStart(dateVon);
        mieter.setMietEnde(dateBis);
        mieter.setVertragsDetails(details);
        mieter.save();
        return ok(Json.toJson(mieter));
    }

    public Result newInvestition(int id) {

        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();

        Investition investition = new Investition();
        DynamicForm requestData = Form.form().bindFromRequest();
        String beschreibung = requestData.get("new-investition-beschreibung");
        double kosten = Double.parseDouble(requestData.get("new-investition-kosten"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date datum = new Date();

        try {
            datum = formatter.parse(requestData.get("new-investition-datum"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        investition.setBeschreibung(beschreibung);
        investition.setDatum(datum);
        investition.setKosten(kosten);
        investition.setImmobilie(immo);
        investition.save();
        return ok(Json.toJson(investition));
    }

    public Result newKredit(int id) {

        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();

        Kredit kredit = new Kredit();
        DynamicForm requestData = Form.form().bindFromRequest();
        String details = requestData.get("new-kredit-details");
        double betrag = Double.parseDouble(requestData.get("new-kredit-betrag"));
        double rate = Double.parseDouble(requestData.get("new-kredit-rate"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date kreditVon = new Date();
        Date kreditBis = new Date();

        try {
            kreditVon = formatter.parse(requestData.get("new-kredit-von"));
            kreditBis = formatter.parse(requestData.get("new-kredit-bis"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        kredit.setDetails(details);
        kredit.setBetrag(betrag);
        kredit.setRate(rate);
        kredit.setKreditStart(kreditVon);
        kredit.setKreditEnde(kreditBis);
        kredit.setImmobilie(immo);
        kredit.save();
        return ok(Json.toJson(kredit));
    }
}

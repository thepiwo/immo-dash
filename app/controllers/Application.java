package controllers;

import models.Immobilie;
import models.Investition;
import models.Mieter;
import play.*;
import play.mvc.*;

import views.html.*;

import java.util.Date;
import java.util.List;

public class Application extends Controller {

    public Result getTest() {
        return ok(test.render("blub"));
    }

    public Result dashboard() {
        List<Mieter> mieterList = Mieter.find.findList();
        int mietSum = 0;
        for (Mieter mieter : mieterList) {
            mietSum += (int) mieter.getMiete();
        }

        long tsMonth = (long) System.currentTimeMillis() + (30L * 24L * 60L * 60L * 1000L);
        Logger.info("Month: "+ tsMonth);
        List<Investition> investitionList = Investition.find.where().gt("datum", new Date()).lt("datum", new Date(tsMonth)).findList();
        int investitionsSum = 0;
        for (Investition investition : investitionList) {
            investitionsSum += (int) investition.getKosten();
        }

        return ok(index.render(mieterList.size(), mietSum, investitionList.size(), investitionsSum));
    }

    public Result immobilien() {
        List<Immobilie> immobilieList = Immobilie.find.findList();
        return ok(immobilien.render(immobilieList));
    }


    public Result intro() {
        return ok(intro.render());
    }
}

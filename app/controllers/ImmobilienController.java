package controllers;

import models.Immobilie;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.createImmo;
import views.html.showImmo;

public class ImmobilienController extends Controller {

    public Result create() {
        return ok(createImmo.render(Immobilie.immoForm));
    }

    public Result createSubmit() {
        Immobilie immo = Immobilie.immoForm.bindFromRequest().get();
        immo.save();
        immo.refresh();
        return redirect(routes.ImmobilienController.index(immo.getId()));
    }

    public Result index(int id) {
        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();
        if (immo == null) {
            return redirect(routes.ImmobilienController.create());
        }
        return ok(showImmo.render(immo));
    }


    public Result delete(int id){
        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();
        if (immo == null) {
            return redirect(routes.ImmobilienController.create());
        }
        immo.delete();
        return redirect(routes.Application.index());

    }


}

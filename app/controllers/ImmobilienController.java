package controllers;

import models.Immobilie;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import views.html.createImmo;
import views.html.editImmo;
import views.html.showImmo;

import java.io.File;
import java.nio.file.Files;

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

    public Result editSubmit(int id) {
        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();
        Immobilie immoedited = Immobilie.immoForm.bindFromRequest().get();
        immo.setImagePath(immoedited.getImagePath());
        immo.setKaufDatum(immoedited.getKaufDatum());
        immo.setKaufPreis(immoedited.getKaufPreis());
        immo.setName(immoedited.getName());
        immo.setTyp(immoedited.getTyp());
        immo.save();
        return redirect(routes.ImmobilienController.index(immo.getId()));
    }

    public Result index(int id) {
        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();
        if (immo == null) {
            return redirect(routes.ImmobilienController.create());
        }
        return ok(showImmo.render(immo));
    }


    public Result delete(int id) {
        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();
        if (immo == null) {
            return redirect(routes.ImmobilienController.create());
        }
        immo.delete();
        return redirect(routes.Application.index());

    }

    public Result update(int id) {
        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();
        if (immo == null) {
            return redirect(routes.ImmobilienController.create());
        }

        return ok(editImmo.render(Immobilie.immoForm.fill(immo), immo));

    }
    public Result updateSubmit(int id){
        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();
        if (immo == null) {
            return redirect(routes.ImmobilienController.create());
        }
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");

        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File newImage = new File(Play.application().path().getAbsolutePath()+"public/images/immobilien/" + immo.getId()+"_"+fileName);
            File file = picture.getFile();
            file.renameTo(newImage);

            immo.setImagePath(immo.getId()+"_"+fileName);
        }

        immo.save();
        immo.refresh();
        return redirect(routes.ImmobilienController.index(immo.getId()));
    }






}

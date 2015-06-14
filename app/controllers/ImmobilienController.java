package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import me.figo.FigoException;
import me.figo.FigoSession;
import me.figo.models.Transaction;
import models.Immobilie;
import play.Logger;
import play.Play;
import play.libs.F;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import views.html.createImmo;
import views.html.editImmo;
import views.html.showImmo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static controllers.helpers.imageHelper.moveFile;

public class ImmobilienController extends Controller {

    public Result create() {
        return ok(createImmo.render(Immobilie.immoForm));
    }

    public Result createSubmit() {
        Immobilie immo = Immobilie.immoForm.bindFromRequest().get();

        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");

        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File newImage = new File(Play.application().path().getAbsolutePath() + "/public/images/immobilien/" + immo.getId() + "_" + fileName);
            File file = picture.getFile();
            moveFile(file, newImage);

            Logger.info(newImage.getAbsolutePath());

            immo.setImagePath(immo.getId() + "_" + fileName);
        }
        immo.save();
        immo.refresh();
        return redirect(routes.ImmobilienController.index(immo.getId()));
    }

    public Result index(int id) throws FigoException, IOException  {
        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();

        if (immo == null) {
            return redirect(routes.ImmobilienController.create());
        }

        // Letzten Zahlungen abrufen
        FigoSession session = new FigoSession("ASHWLIkouP2O6_bgA2wWReRhletgWKHYjLqDaqb0LFfamim9RjexTo22ujRIP_cjLiRiSyQXyt2kM1eXU2XLFZQ0Hro15HikJQT_eNeT_9XQ");
        ArrayList<String> transactions =new ArrayList<>();

        for (Transaction transaction : session.getTransactions(session.getAccount("A1.1"))) {
            transactions.add(transaction.getPurposeText());
        }

        return ok(showImmo.render(immo, transactions));
    }


    public Result delete(int id) {
        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();
        if (immo == null) {
            return redirect(routes.ImmobilienController.create());
        }
        immo.delete();
        return redirect(routes.Application.immobilien());

    }

    public Result update(int id) {
        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();
        if (immo == null) {
            return redirect(routes.ImmobilienController.create());
        }
        return ok(editImmo.render(Immobilie.immoForm.fill(immo), immo));
    }

    public Result editSubmit(int id) {
        Immobilie immo = Immobilie.find.where().eq("id", id).findUnique();
        Immobilie immoedited = Immobilie.immoForm.bindFromRequest().get();
        immo.setKaufDatum(immoedited.getKaufDatum());
        immo.setKaufPreis(immoedited.getKaufPreis());
        immo.setName(immoedited.getName());
        immo.setTyp(immoedited.getTyp());

        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");

        if (picture != null) {
            String fileName = picture.getFilename();
            Logger.info(picture.getFilename());
            String contentType = picture.getContentType();
            File newImage = new File(Play.application().path().getAbsolutePath() + "/public/images/immobilien/" + immo.getId() + "_" + fileName);
            File file = picture.getFile();
            moveFile(file, newImage);

            Logger.info(newImage.getAbsolutePath());

            immo.setImagePath(immo.getId() + "_" + fileName);
        }

        immo.save();
        immo.refresh();
        return redirect(routes.ImmobilienController.index(immo.getId()));
    }



}

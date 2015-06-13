package controllers;

import models.Immobilie;
import play.mvc.Controller;
import play.mvc.Result;

import scala.xml.Null;
import views.html.createImmo;

public class ImmobilienController extends Controller {

    public Result index(int id){
        Immobilie immo = Immobilie.find.where().eq("id",id).findUnique();
        if(immo== null)return  ok(createImmo.render());
        return TODO;
    }




}

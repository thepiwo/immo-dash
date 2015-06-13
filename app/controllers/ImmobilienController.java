package controllers;

import models.Immobilie;
import play.mvc.Controller;
import play.mvc.Result;
import scala.xml.Null;

/**
 * Created by fa on 13.06.15.
 */
public class ImmobilienController extends Controller {

    public Result index(int id){
        Immobilie immo = Immobilie.find.where().eq("id",id).findUnique();
        if(immo== null)return  badRequest("badRequest");
        return TODO;
    }


}

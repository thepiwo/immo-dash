package controllers;

import models.Immobilie;
import play.*;
import play.mvc.*;

import views.html.*;

import java.util.List;

public class Application extends Controller {

    public Result getTest() {
        return ok(test.render("blub"));
    }

    public Result getImage() {
        return ok();
    }

    public Result index() {
        List<Immobilie> immobilieList = Immobilie.find.findList();
        return ok(index.render(immobilieList));
    }

}

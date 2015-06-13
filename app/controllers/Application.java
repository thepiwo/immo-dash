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

    public Result dashboard(){
        return ok(index.render());
    }

    public Result immobilien() {
        List<Immobilie> immobilieList = Immobilie.find.findList();
        return ok(immobilien.render(immobilieList));
    }


    public Result intro() {
        return ok(intro.render());
    }
}

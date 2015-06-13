package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result getTest() {
        return ok(test.render("blub"));
    }

    public Result getImage() {
        return ok();
    }

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

}

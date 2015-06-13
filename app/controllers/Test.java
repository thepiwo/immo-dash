package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

/**
 * Created by fa on 13.06.15.
 */
public class Test extends Controller {
    public Result index() {
        return ok(test.render("test"));
    }
}

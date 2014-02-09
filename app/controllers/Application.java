package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Login;
import views.html.Register;

public class Application extends Controller {
  
  /**
   * Returns the home page.
   * @return The home page.
   */
  public static Result index() {
    return ok(Index.render("Home"));
  }
 
  /**
   * Returns the login page.
   * @return The login page.
   */
  public static Result login() {
    return ok(Login.render("Login"));
  }
  
  /**
   * Log into the application.
   * @return
   */
  public static Result postLogin() {
    return TODO;
  }

  /**
   * Logout of the application.
   * @return A redirect to the login page.
   */
  public static Result logout() {
    return redirect(routes.Application.login());
  }
  
  /**
   * Returns the Registration page.
   * @return The registration page.
   */
  public static Result register() {
    return ok(Register.render("Register"));
  }
  
}

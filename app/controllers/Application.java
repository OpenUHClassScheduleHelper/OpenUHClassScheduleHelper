package controllers;

import java.util.ArrayList;
import models.UserComment;
import models.UserCommentDB;
import models.UserInfo;
import models.UserInfoDB;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Login;
import views.html.Register;
import views.html.Results;
import views.html.Account;
import views.html.Test;

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
    UserInfo user = UserInfoDB.getUser("jortal");
    return ok(Test.render(user));
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
  
  /**
   * Returns the Results page.
   * @return The results page.
   */
  public static Result getResults() {
    return ok(Results.render("Results"));
  }
  
  /**
   * Returns the personal account page.
   * @return The account page.
   */
  public static Result myAccount() {
    return ok(Account.render("My Account"));
  }
  
}

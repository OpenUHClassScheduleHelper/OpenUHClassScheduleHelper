package controllers;

import models.CourseDB;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Login;
import views.html.Register;
import views.html.Search;
import views.html.Account;
import views.html.Results;

public class Application extends Controller {
  
  /**
   * Returns the home page.
   * @return The home page.
   */
  public static Result index() {
    return ok(Index.render("Home"));
  }

  /**
   * Returns the search results page.
   * @return The search results page.
   */
  public static Result searchResults() {
    return ok(Search.render("Search Results", CourseDB.getCourses()));
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
  
  /**
   * Returns the Account page.
   * @return The account page.
   */
  public static Result account() {
    return ok(Account.render("Account"));
  }
  
  /**
   * Returns the Result page.
   * @return The result page.
   */
  public static Result results() {
    return ok(Results.render("Results"));
  }
  
}

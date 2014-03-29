package controllers;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Login;
import views.html.Register;
import views.html.Results;
import views.html.Account;

public class Application extends Controller {

  private static final String CAS_LOGIN = "https://cas-test.its.hawaii.edu/cas/login";

  private static final String CAS_VALIDATE = "https://cas-test.its.hawaii.edu/cas/serviceValidate";

  private static final String CAS_LOGOUT = "https://cas-test.its.hawaii.edu/cas/logout";
  
  /**
   * Returns the home page.
   * @return The home page.
   */
  public static Result index() {
    return ok(Index.render("Home"));
  }
 

public static Result login() throws Exception {

  Map<String, String[]> query = request().queryString();

  // service url is where you will handle validation after login

  // or getting the user attributes after validation

  String serviceURL = routes.Application.login().absoluteURL(request());

  serviceURL = URLEncoder.encode(serviceURL, "UTF-8");




  // no query means the user needs to login


  if(query.size() == 0) {

    // url to initiate CAS login

    String loginURL = CAS_LOGIN + "?service=" + serviceURL;

    return redirect(loginURL);

  } else {

    // after successful login from CAS, you get the ticket parameter

    String[] tickets = query.get("ticket");

    if(tickets.length > 0) {

      String ticket = tickets[0];

      // url to validate the ticket

      String validateURL = CAS_VALIDATE + "?service=" + serviceURL + "&ticket=" + ticket;

      // this junk is needed to parse the xml response from the CAS server

      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      DocumentBuilder db = dbf.newDocumentBuilder();

      // this is where we make the actual request to validate and parse the response at the same time

      Document doc = db.parse(new URL(validateURL).openStream());

      // check for successful validation

      doc.getElementsByTagName("cas:serviceResponse");

      boolean success = doc.getElementsByTagName("cas:authenticationSuccess").getLength() > 0;

      if(success) {

        // if successful, get the username and save it into your session

        String username = doc.getElementsByTagName("cas:user").item(0).getTextContent();

        session().clear();

        session("username", username);

        User.add(-1, username, "");

        return redirect(routes.Application.appInterface());

      } else {

        // you could redirect to the CAS login here if you want to

      }

    }

    return redirect(routes.Application.index());

  }

}


public static Result logout() throws Exception {

  // clear your session

  session().clear();

  String serviceURL = routes.Application.home().absoluteURL(request());

  serviceURL = URLEncoder.encode(serviceURL, "UTF-8");

  // redirect to CAS logout

  return redirect(CAS_LOGOUT + "?service=" + serviceURL);

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

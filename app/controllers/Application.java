package controllers;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import models.UserInfoDB;
import org.w3c.dom.Document;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
<<<<<<< HEAD
import views.formdata.Days;
import views.formdata.FocusTypes;
import views.formdata.SearchForm;
=======
>>>>>>> b86d5218d324881d01eeb77342a2ea8fec2b9a31
import java.util.List;
import java.util.ArrayList;
import views.html.Index;
import views.html.Register;
import views.html.Results;
import views.html.Search;
import views.html.Account;
import models.Course;
import models.CourseDB;
import models.Meeting;

public class Application extends Controller {

  private static final String CAS_LOGIN = "https://cas-test.its.hawaii.edu/cas/login";

  private static final String CAS_VALIDATE = "https://cas-test.its.hawaii.edu/cas/serviceValidate";

  private static final String CAS_LOGOUT = "https://cas-test.its.hawaii.edu/cas/logout";
  
  private static final Form<SearchForm> searchForm = Form.form(SearchForm.class);
  
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
        
        UserInfoDB.addUserInfo(username, "", "", "");

        return redirect(routes.Application.getResults());

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

  String serviceURL = routes.Application.index().absoluteURL(request());

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
   * Returns the sample resutls page to see if classes are implemented properly.
   * This is only for testing!
   * @return The registration page.
   */
  public static Result searchResults() {
    List<Course> courseList = CourseDB.getCourses();
    return ok(Search.render("Search", true, courseList));
  }
    
  /**
   * Returns the Results page.
   * @return The results page.
   */   
  public static Result getResults() {
    return ok(Results.render("Results", FocusTypes.getFocusTypes(), Days.getDays(), searchForm));
  }
  
  /**
   * Returns the personal account page.
   * @return The account page.
   */
  public static Result myAccount() {
    return ok(Account.render("My Account"));
  }
  

  public static Result classSearch() {
    Form<SearchForm> formData = searchForm.bindFromRequest();
    SearchForm data = formData.get();
    return redirect(routes.Application.index());
  }
  
}

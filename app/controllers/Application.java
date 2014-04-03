package controllers;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import models.UserInfoDB;
import org.w3c.dom.Document;
import play.Routes;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.Days;
import views.formdata.Departments;
import views.formdata.FocusTypes;
import views.formdata.SearchForm;
import java.util.List;
import java.util.ArrayList;
import views.html.Index;
import views.html.Register;
import views.html.Results;
import views.html.Search;
import views.html.Account;
import views.html.MapRoute;
import models.Course;
import models.CourseDB;
import models.Meeting;
import models.ScheduleEvent;
import models.UserComment;
import models.UserCommentDB;
import models.UserInfo;
import views.html.Instructor;

public class Application extends Controller {

  private static String currentUser;
  
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
 
  
  /**
   * Returns the map page.
   * @return the map page
   */
  public static Result map() {
    return ok(MapRoute.render("Campus Map"));
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
        currentUser = username;
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
    Form<SearchForm> formData = searchForm.bindFromRequest();
    SearchForm data = formData.get();
    List<Course> resultsList = new ArrayList<>();
    List<Course> schedule = new ArrayList<>();
    
    if(UserInfoDB.getUser(currentUser) != null) {
      // Lists to print the users schedule
      schedule = UserInfoDB.getUser(currentUser).getSchedule();
    }
    
    if(data != null) {
      resultsList = CourseDB.courseSearchList(data.days, data.focus, data.department, data.course, data.instructor, data.startTime, data.endTime);
    }
    
    // Create Schedule Events
    Boolean conflictExists = false;
    List<ScheduleEvent> events = new ArrayList<>();
    
    if (resultsList.size() > 0 && schedule.size() > 0) {
      for (Course result : resultsList) {
        for (Meeting rMeeting : result.getMeeting()) {
          
          // compare each result meeting with those on the schedule.
          for (Course course : schedule) {
            for (Meeting cMeeting : course.getMeeting()) {
              if (!conflictExists) {
                conflictExists = rMeeting.isOverlapping(cMeeting);
              }
            }  // end of schedule meeting loop
          } // end of schedule loop
          
          // Create a new schedule event object with appropriate attributes.
          ScheduleEvent event = new ScheduleEvent(result.getCrn(),result.getCourseName(), 
                                rMeeting.getFullCalendarStartTime(), rMeeting.getFullCalendarEndTime(), 
                                conflictExists);
          // Add it to the list of events
          events.add(event);
          conflictExists = false;
        } // end of result meeting loop
      } // end of result loop
    }

    return ok(Results.render("Results", FocusTypes.getFocusTypes(), Days.getDays(), Departments.getDepartments(), 
              resultsList, searchForm, schedule, events));
  }
  
  /**
   * Returns the personal account page.
   * @return The account page.
   */
  public static Result myAccount() {
    UserInfo user = UserInfoDB.getUser(currentUser);
    return ok(Account.render("My Account", user, user.getSchedule(), user.getWatchList(),
                              UserCommentDB.getCommentsByUserName(currentUser)));
  }

  /**
   * Return the instructor page.
   * @return The instructor page.
   */
  public static Result instructor() {
    return ok(Instructor.render());
  }
  
  /**
   * Handles the deleting of a comment from the database.
   * @param id The id of the comment to delete.
   * @return The resulting My Account page.
   */
  public static Result deleteComment(long id) {
    UserCommentDB.removeComment(id);
    return redirect(routes.Application.myAccount());
  }
  
  
  /**
   * Handles the deleting of a course from the users watch list.
   * @param crn The crn of the course to delete.
   * @return The resulting My Accoutn page.
   */
  public static Result deleteCourseFromWatchlist(String crn) {
    UserInfoDB.getUser(currentUser).removeFromWatchList(crn);
    return redirect(routes.Application.myAccount());
  }
  
  
  public static Result addCourseToWatchlist(String crn) {
    UserInfoDB.getUser(currentUser).addToWatchList(CourseDB.getCourse(crn));
    return redirect(routes.Application.getResults());
  }
  
  public static Result addCourseToSchedule(String crn) {
    UserInfoDB.getUser(currentUser).addToSchedule(CourseDB.getCourse(crn));
    return redirect(routes.Application.getResults());
  }
 
  
  public static Result classSearch() {
    Form<SearchForm> formData = searchForm.bindFromRequest();
    SearchForm data = formData.get();
    
    return redirect(routes.Application.getResults());
  }
  
  
  public static Result populateInstructorList(String dept) {
    List<String> instructors = CourseDB.getInstructors(dept);
    String instructorddl = "";
    for(int i = 0; i < instructors.size(); i++) {
       String first = instructors.get(i).split(" ")[0];
       String last = instructors.get(i).split(" ")[1];
       instructorddl += "<option>" + last + ", " + first + "</option>" + "\n";
    }
    
    return ok(instructorddl);
    
  }
  
  
  public static Result populateCourseList(String dept) {
    List<String> courses = CourseDB.getCourses(dept);
    String courseddl = "";
    for(int i = 0; i < courses.size(); i++) {
       courseddl += "<option>" + courses.get(i) + "</option>" + "\n";
    }
    
    return ok(courseddl);
    
  }
  
  
  public static Result jsRoutes()
  {
      response().setContentType("text/javascript");
      return ok(Routes.javascriptRouter("appRoutes", //appRoutes will be the JS object available in our view
                                        routes.javascript.Application.populateInstructorList(),
                                        routes.javascript.Application.populateCourseList()));
  }
  
}

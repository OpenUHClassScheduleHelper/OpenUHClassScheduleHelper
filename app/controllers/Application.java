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
import views.formdata.CommentFormData;
import views.formdata.NotificationPreferencesFormData;
import views.formdata.Days;
import views.formdata.Departments;
import views.formdata.FocusTypes;
import views.formdata.SearchForm;
import java.util.List;
import java.util.ArrayList;
import views.html.Index;
import views.html.Results;
import views.html.Account;
import views.html.MapRoute;
import models.Course;
import models.CourseDB;
import models.CourseSearch;
import models.Meeting;
import models.ScheduleEvent;
import models.UserComment;
import models.UserCommentDB;
import models.UserInfo;

public class Application extends Controller {
  
  // Development
  private static final String CAS_LOGIN = "https://cas-test.its.hawaii.edu/cas/login";
  private static final String CAS_VALIDATE = "https://cas-test.its.hawaii.edu/cas/serviceValidate";
  private static final String CAS_LOGOUT = "https://cas-test.its.hawaii.edu/cas/logout";
  
  // Production
  //private static final String CAS_LOGIN = "https://authn.hawaii.edu/cas/login";
  //private static final String CAS_VALIDATE = "https://authn.hawaii.edu/cas/serviceValidate";
  //private static final String CAS_LOGOUT = "https://authn.hawaii.edu/cas/logout";
  
  private static final Form<SearchForm> searchForm = Form.form(SearchForm.class);

  /**
   * Returns the home page.
   * 
   * @return The home page.
   */
  public static Result index() {
    return ok(Index.render("Home", Secured.getUserInfo(ctx()), Secured.isLoggedIn(ctx())));
  }

  /**
   * Returns the map page.
   * @return the map page
   */
  @Security.Authenticated(Secured.class)
  public static Result map() {
    return ok(MapRoute.render("Campus Map", Secured.getUserInfo(ctx()), Secured.isLoggedIn(ctx())));
  }

  /**
   * Returns the login page.
   * @return The Login Page.
   * @throws Exception CAS exception.
   */
  public static Result login() throws Exception {
    
    Map<String, String[]> query = request().queryString();

    // service url is where you will handle validation after login
    // or getting the user attributes after validation
    String serviceURL = routes.Application.login().absoluteURL(request());
    serviceURL = URLEncoder.encode(serviceURL, "UTF-8");

    // no query means the user needs to login
    if (query.size() == 0) {
      // url to initiate CAS login
      String loginURL = CAS_LOGIN + "?service=" + serviceURL;
      return redirect(loginURL);
    }
    else {
      // after successful login from CAS, you get the ticket parameter
      String[] tickets = query.get("ticket");
      if (tickets.length > 0) {
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
        
        if (success) {
          // if successful, get the username and save it into your session
          String userName = doc.getElementsByTagName("cas:user").item(0).getTextContent();
          session().clear();
          session("userName", userName);
          
          // add user to the database if they dont already exist
          UserInfoDB.addUserInfo(userName);
          
          return redirect(routes.Application.search());
        }
        else {
          // you could redirect to the CAS login here if you want to
        }
      }
      return redirect(routes.Application.index());
    }
  }

  /**
   * Retuns the logout page.
   * @return The logout page.
   * @throws Exception CAS exception.
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() throws Exception {
    // clear your session
    session().clear();
    String serviceURL = routes.Application.index().absoluteURL(request());
    serviceURL = URLEncoder.encode(serviceURL, "UTF-8");

    // redirect to CAS logout
    return redirect(CAS_LOGOUT + "?service=" + serviceURL);

  }
  
  /**
   * Returns the search page with an empty results table.
   * @return The results page with an empty results table.
   */
  public static Result search() {
    return redirect(routes.Application.getResults(-1));
  }
  
  
  /**
   * Returns the Results page.
   * @return The results page.
   */
  @Security.Authenticated(Secured.class)
  public static Result getResults(int pageNum) {
    
    Form<SearchForm> formData = searchForm.bindFromRequest();
    SearchForm data = formData.get();
    
    Form<CommentFormData> commentForm = Form.form(CommentFormData.class).bindFromRequest();
    String currentDept = "";
    String currentInstructor = "";
    String currentCourse ="";
    int startPage = 0, endPage = 0;
    List<Course> resultList = new ArrayList<>();
    List<Course> schedule = new ArrayList<>();
    List<String> instructorList = new ArrayList<>();
    List<String> courseList = new ArrayList<>();
    int pageCount = 0;
    int courseCount = 0;
    
  
    //UserInfo user = Secured.getUserInfo(ctx());
    //schedule = user.getSchedule();
        
    /*if (data != null) {
      //resultsList =
      //   CourseDB.courseSearchList(data.days, data.focus, data.department, data.course, data.instructor,
      //        data.startTime, data.endTime);
      
      // Because we changed the way the department string is formatted in the search form select box,
      // we need to parse out the department abbreviation before passing it to this method.
      String dept = data.department;
      if (data.department.indexOf(":") > 0) {
        dept = data.department.substring(0, data.department.indexOf(":"));
          //instructorList = (List<String>) populateInstructorList(dept);
          //courseList = (List<String>) populateCourseList(dept);
      }
      CourseDB.page(data.days, data.focus, dept, data.course, data.instructor,
          data.startTime, data.endTime);
      resultsList = CourseDB.getCoursesInPage(pageNum-1);
      pageCount = CourseDB.getPageCount();
      courseCount = CourseDB.getCourseCount();
    }
    

    // Create Schedule Events
    Boolean conflictExists = false;
    List<ScheduleEvent> events = new ArrayList<>();

    if (resultsList.size() > 0) {
      for (Course result : resultsList) {
        for (Meeting rMeeting : result.getMeeting()) {
          // compare each result meeting with those on the schedule.
          for (Course course : schedule) {
            for (Meeting cMeeting : course.getMeeting()) {
              if (!conflictExists) {
                conflictExists = rMeeting.isOverlapping(cMeeting);
              }
            } // end of schedule meeting loop
          } // end of schedule loop

          // Create a new schedule event object with appropriate attributes.
          ScheduleEvent event =
              new ScheduleEvent(result.getCrn(), result.getCourseName(), rMeeting.getFullCalendarStartTime(),
                  rMeeting.getFullCalendarEndTime(), conflictExists);
          // Add it to the list of events
          events.add(event);
          conflictExists = false;
        } // end of result meeting loop
      } // end of result loop
    }

    return ok(Results.render("Results", user, FocusTypes.getFocusTypes(), Days.getDays(), Departments.getDepartments(),
        resultsList, searchForm.bindFromRequest(), schedule, events, courseCount, pageCount, pageNum, 
        instructorList, courseList));
  }*/
  
  
  /**
   * Returns the Search page.
   * @return The results page.
   */
  /*@Security.Authenticated(Secured.class)
  public static Result search() {
    Form<SearchForm> formData = searchForm.bindFromRequest();
    SearchForm data = formData.get();
    List<Course> resultsList = new ArrayList<>();
    List<Course> schedule = new ArrayList<>();*/
    String dept = data.department;
    if (data.department.indexOf(": ") > 0) {
      dept = data.department.substring(0, data.department.indexOf(": "));
    }
    
    switch (pageNum) {
      case -1:   // Navigated to page from link - no search performed.
        resultList.clear();
        break;
      case 0:    // Search requested; query database and return page 1 of results.
        CourseSearch.page(data.days, data.focus, data.department, data.course, data.instructor,
            data.startTime, data.endTime);
        currentDept = CourseSearch.getParamDept();
        currentInstructor = CourseSearch.getParamInstructor();
        currentCourse = CourseSearch.getParamCourse();
        resultList = CourseSearch.getResultsByPage(0);
        pageNum = 1;
        break;
      default:   // User has requested a specific page of results.
        currentDept = CourseSearch.getParamDept();
        resultList = CourseSearch.getResultsByPage(pageNum - 1);
        break;
    }
    
    if(! currentDept.equals("")) {
      //instructorList = (List<String>) populateInstructorList(currentDept);
      //courseList = (List<String>) populateCourseList(currentDept);
    }
    
    // Calculate Pagination range
    if (CourseSearch.getPageCount() <= 5) {
      startPage = 1;
      endPage = CourseSearch.getPageCount();
    }
    else {
      if (pageNum <= 3) {
        startPage = 1;
        endPage = 5;
      }
      else if (pageNum >= CourseSearch.getPageCount() - 2) {
        endPage = CourseSearch.getPageCount();
        startPage = endPage - 4;
      }
      else {
        startPage = (pageNum - 2);
        endPage = (pageNum + 2);
      }
    }
    
    UserInfo user = Secured.getUserInfo(ctx());
    boolean isLoggedIn = Secured.isLoggedIn(ctx());
    
    schedule = user.getSchedule();

    // Create Schedule Events
    Boolean conflictExists = false;
    List<ScheduleEvent> events = new ArrayList<>();

    if (resultList.size() > 0) {
      for (Course result : resultList) {
        for (Meeting rMeeting : result.getMeeting()) {
          // compare each result meeting with those on the schedule.
          for (Course course : schedule) {
            for (Meeting cMeeting : course.getMeeting()) {
              if (!conflictExists) {
                conflictExists = rMeeting.isOverlapping(cMeeting);
              }
            } // end of schedule meeting loop
          } // end of schedule loop

          // Create a new schedule event object with appropriate attributes.
          ScheduleEvent event =
              new ScheduleEvent(result.getCrn(), result.getCourseName(), rMeeting.getFullCalendarStartTime(),
                  rMeeting.getFullCalendarEndTime(), conflictExists);
          // Add it to the list of events
          events.add(event);
          conflictExists = false;
        } // end of result meeting loop
      } // end of result loop
    }
    //System.out.println(CourseSearch.getResultsCount());
    return ok(Results.render("Results", user, isLoggedIn, FocusTypes.getFocusTypes(), Days.getDays(), 
              Departments.getDepartments(currentDept), resultList, searchForm, schedule, events, 
              CourseSearch.getResultsCount(), CourseSearch.getPageCount(), startPage, endPage, pageNum,
              CourseDB.getInstructorMap(dept, currentInstructor), CourseDB.getCoursesMap(dept, currentCourse),
              commentForm));
  }
  
  /**
   * Returns the personal account page.
   * @return The account page.
   */
  @Security.Authenticated(Secured.class)
  public static Result myAccount() {
    UserInfo user = Secured.getUserInfo(ctx());
    boolean isLoggedIn = Secured.isLoggedIn(ctx());
    Form<CommentFormData> commentForm = Form.form(CommentFormData.class);
    NotificationPreferencesFormData preferencesFormData = new NotificationPreferencesFormData(user);
    Form<NotificationPreferencesFormData> preferencesForm = Form.form(NotificationPreferencesFormData.class).fill(preferencesFormData);
    
    // Get late breaking news for all courses in the users schedule
    List<UserComment> breakingNewsSchedule = getBreakingNews_Schedule();
    List<UserComment> breakingNewsWatchlist = getBreakingNews_Watchlist();
    
    return ok(Account.render("My Account", user, isLoggedIn, user.getSchedule(), user.getWatchList(),
        UserCommentDB.getCommentsByUserName(user.getUserName()), breakingNewsSchedule, breakingNewsWatchlist, 
                                            commentForm, preferencesForm));
  }

  /**
   * Get a list of breaking news for each course in the users schedule.
   * @return A list of UserComments associated with each course in the users schedule.
   */
  private static List<UserComment> getBreakingNews_Schedule() {
    UserInfo user = Secured.getUserInfo(ctx());
    List<Course> courses = user.getSchedule();
    List<UserComment> breakingNews = new ArrayList<UserComment>();
    for (Course course : courses) {
      breakingNews.addAll(UserCommentDB.getCommentsByCrn(course.getCrn()));
    }
    return breakingNews;
  }
  
  /**
   * Get a list of breaking news for each course in the users watchlist.
   * @return A list of UserComments associated with each course in the users watchlist.
   */
  private static List<UserComment> getBreakingNews_Watchlist() {
    UserInfo user = Secured.getUserInfo(ctx());
    List<Course> courses = user.getWatchList();
    List<UserComment> breakingNews = new ArrayList<UserComment>();
    for (Course course : courses) {
      breakingNews.addAll(UserCommentDB.getCommentsByCrn(course.getCrn()));
    }
    return breakingNews;
  }
  
  
  /**
   * Update the current users notification preferences.
   * @return The My Account page with updated notification preferences.
   */
  @Security.Authenticated(Secured.class)
  public static Result updateNotificationPreferences() {
    UserInfo user = Secured.getUserInfo(ctx());   
    boolean isLoggedIn = Secured.isLoggedIn(ctx());
    Form<CommentFormData> commentForm = Form.form(CommentFormData.class);
    Form<NotificationPreferencesFormData> preferencesForm = Form.form(NotificationPreferencesFormData.class).bindFromRequest();
    if (preferencesForm.hasErrors()) {
      // Get late breaking news for all courses in the users schedule
      List<UserComment> breakingNewsSchedule = getBreakingNews_Schedule();
      List<UserComment> breakingNewsWatchlist = getBreakingNews_Watchlist();
      return badRequest(Account.render("My Account", user, isLoggedIn, user.getSchedule(), user.getWatchList(),
          UserCommentDB.getCommentsByUserName(user.getUserName()), breakingNewsSchedule, breakingNewsWatchlist,
                                              commentForm, preferencesForm));
    }
    else {
      NotificationPreferencesFormData formData = preferencesForm.get();
      user.setNotificationPreference(formData.userPreference);
      user.setEmail(formData.userEmail);
      user.setTelephone(formData.userPhone);
      user.setCarrier(formData.userCarrier);
      user.save();
      
      // Send the user a confirmation email/txt if they've opted in
      if (user.wantsNotification()) {
        // send confirmation text
        if (!user.getTelephone().equals("")) {
          SendEmail.SendConfirmationBySms(user.getTelephone(), user.getCarrier());
        }
        if (!user.getEmail().equals("")) {
          SendEmail.SendConfirmationByEmail(user.getEmail());
        }
      }
    }
    return redirect(routes.Application.myAccount());
  }
  
  /**
   * Edit a comment in the users CommentDB. Called from the MyAccount page.
   */
  @Security.Authenticated(Secured.class)
  public static Result editComment() {
    Form<CommentFormData> commentForm = Form.form(CommentFormData.class).bindFromRequest();
    if (commentForm.hasErrors()) {
      // This wont actually work since theres no validate method.
      // Do nothing, just reload My account page.
    }
    else {
      CommentFormData commentFormData = commentForm.get();

      String id = commentFormData.id;
      String newComment = commentFormData.comment;

      // Get the old comment and use it to create the new comment.
      UserComment oldComment = UserCommentDB.getCommentById(id);
      UserCommentDB.addComment(oldComment.getCrn(), oldComment.getUserName(), newComment);

      // Remove the old comment.
      UserCommentDB.removeComment(id);
    }
    return redirect(routes.Application.myAccount());
  }
  
  
  /**
   * Edit a comment in the users CommentDB. Called from the MyAccount page.
   */
  @Security.Authenticated(Secured.class)
  public static Result addComment() {
    Form<CommentFormData> commentForm = Form.form(CommentFormData.class).bindFromRequest();
    UserInfo user = Secured.getUserInfo(ctx());
    if (commentForm.hasErrors()) {
      // This wont actually work since theres no validate method.
      // Do nothing, just reload My account page.
      System.out.println("eror");
    }
    else {
      CommentFormData commentFormData = commentForm.get();

      String crn = commentFormData.crn;
      String username = user.getUserName();
      String newComment = commentFormData.comment;

      // Get the old comment and use it to create the new comment.
      //UserComment oldComment = UserCommentDB.getCommentById(id);
      UserCommentDB.addComment(crn, username, newComment);

    }
    return redirect(routes.Application.getResults(1));
  }
  
  /**
   * Handles the deleting of a comment from the database.
   * 
   * @param id The id of the comment to delete.
   * @return The resulting My Account page.
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteComment(long id) {
    UserCommentDB.removeComment(id);
    return redirect(routes.Application.myAccount());
  }

  /**
   * Handles the deleting of a course from the users watch list.
   * @param crn The crn of the course to delete.
   * @return The resulting My Account page.
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteCourseFromWatchlist(String crn) {
    UserInfo user = Secured.getUserInfo(ctx());
    user.removeFromWatchList(crn);
    return redirect(routes.Application.myAccount());
  }
  
/**
 * Handles adding a course to the users watchlist.
 * @param crn The CRN of the course to add
 * @return Redirects to the Results page.
 */
  public static Result addCourseToWatchlist(String crn) {
    UserInfo user = Secured.getUserInfo(ctx());
    user.addToWatchList(CourseDB.getCourse(crn));
    return redirect(routes.Application.getResults(1));
  }

  /**
   * Handles adding a course to the users schedule.
   * @param crn The CRN of the course to add.
   * @return Redirects to the Results page.
   */
  public static Result addCourseToSchedule(String crn) {
    UserInfo user = Secured.getUserInfo(ctx());
    user.addToSchedule(crn);
    return redirect(routes.Application.getResults(1));
  }
  
  /**
   * Handles the deleting of a course from the users watch list.
   * @param crn The crn of the course to delete.
   * @return The resulting My Account page.
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteCourseFromSchedule(String crn) {
    UserInfo user = Secured.getUserInfo(ctx());
    user.removeFromSchedule(crn);
    return redirect(routes.Application.myAccount());
  }
  
  /**
   * Generate a list of instructors teaching in the specified department.
   * @param dept The department.
   * @return A list of instructors teaching in the specified department.
   */
  public static Result populateInstructorList(String dept) {
    dept = dept.substring(0, dept.indexOf(":"));
    List<String> instructors = CourseDB.getInstructors(dept);
    String instructorddl = "";
    String name = "";
    for (int i = 0; i < instructors.size(); i++) {
      if (instructors.get(i).indexOf(" ") > 0) {
        String first = instructors.get(i).split(" ")[0];
        String last = instructors.get(i).split(" ")[1];
        name = last + ", " + first;
      }
      else {
        name = instructors.get(i);
      }
      instructorddl += "<option>" + name + "</option>" + "\n";
    }
    return ok(instructorddl);
  }
  
/**
 * Generates a list of courses offered by the specified department.
 * @param dept The department.
 * @return A list of courses offered by the specified department.
 */
  public static Result populateCourseList(String dept) {
    dept = dept.substring(0, dept.indexOf(":"));
    List<String> courses = CourseDB.getCourses(dept);
    String courseddl = "";
    for (int i = 0; i < courses.size(); i++) {
      courseddl += "<option>" + courses.get(i) + "</option>" + "\n";
    }
    return ok(courseddl);
  }
  
  /**
   * 
   * @return
   */
  public static Result jsRoutes() {
    response().setContentType("text/javascript");
    return ok(Routes.javascriptRouter("appRoutes", // appRoutes will be the JS object available in our view
        routes.javascript.Application.populateInstructorList(), routes.javascript.Application.populateCourseList()));
  }

}

import java.util.ArrayList;
import java.util.List;
import play.Application;
import play.GlobalSettings;
import models.UserCommentDB;
import models.Course;
import models.CourseDB;
import models.UserInfo;
import models.UserInfoDB;
import models.Meeting;
import views.formdata.CourseFormData;

/**
 * Global settings for the Play application.
 *  
 * @author Rob Namahoe
 */
public class Global extends GlobalSettings {

  /**
   * Overrides the onStart method.
   * 
   * @param app The Play application.
   */
  public void onStart(Application app) {
    
    // Add students to the database
    UserInfoDB.addUserInfo("rnamahoe", "Robert", "Namahoe");
    UserInfoDB.addUserInfo("ek26", "Evan", "Komiyama");
    UserInfoDB.addUserInfo("jortal", "Jon", "Ortal");
    
    // Add instructors to the database
    UserInfoDB.addUserInfo("rnarayan", "Ravi", "Narayan");
    UserInfoDB.addUserInfo("sugihara", "Kazuo", "Sugihara");
    UserInfoDB.addUserInfo("julia4", "Julia", "Patriarche");
    
    // Add User Comments to the database
    UserCommentDB.addComment("84935", "jortal", "Professor Narayan is in the process of trying to make ICS 111 a WI credit.");
    
    UserCommentDB.addComment("84935", "rnamahoe", "Tough class but you sure do learn a lot!");
    UserCommentDB.addComment("86041", "rnamahoe", "I thought ICS111 was hard...this class is impossible!");
    
    UserCommentDB.addComment("84935", "rnarayan", "This class will now be available with a WI credit.");
    UserCommentDB.addComment("84494", "julia4", "This class will be conducted as an online course.");
    
    
    /** list object **/
    List<Meeting> meeting = new ArrayList<Meeting>();

    /**
     * Adds a course. A new meeting list is needed for each course at this time.
     **/
    // ICS101B
    meeting.add(new Meeting("T", "0900a", "1015a", "BIL152"));
    meeting.add(new Meeting("T", "1030a", "1145a", "POST318A"));
    meeting.add(new Meeting("R", "1030a", "1145a", "POST318A"));

    CourseDB.addCourse(new CourseFormData(null, "85248", "ICS 101B", "003", "Tools Inf Age: General", "K Binsted",
        "4", meeting, "BIL152"));

    // ICS101B
    
    /** list object **/
    List<Meeting> meeting2 = new ArrayList<Meeting>();
    
    meeting2.add(new Meeting("T", "0900a", "1015a", "BIL152"));
    meeting2.add(new Meeting("T", "1200p", "0115p", "POST318A"));
    meeting2.add(new Meeting("R", "1200p", "0115p", "POST318A"));

    CourseDB.addCourse(new CourseFormData(null, "85251", "ICS 101B", "006", "Tools Inf Age: General", "K Binsted",
        "0", meeting2, "BIL152"));


    // ICS110
    List<Meeting> meeting3 = new ArrayList<Meeting>();
    
    meeting3.add(new Meeting("T", "1030a", "1145a", "POST319"));
    meeting3.add(new Meeting("R", "1030a", "1145a", "POST319"));

    CourseDB.addCourse(new CourseFormData(null, "86041", "ICS 110", "001", "Programming through Animations",
        "G Poisson", "12", meeting3, "POST319"));

    // ICS111
    List<Meeting> meeting4 = new ArrayList<Meeting>();    
    
    meeting4.add(new Meeting("M", "0530p", "0800p", "BIL152"));
    meeting4.add(new Meeting("W", "0530p", "0645p", "POST319"));

    CourseDB.addCourse(new CourseFormData(null, "84935", "ICS 111", "003", "Intro to Computer Science I",
        "R Narayan", "4", meeting4, "POST127"));

    // ICS141
    List<Meeting> meeting5 = new ArrayList<Meeting>();    
    
    meeting5.add(new Meeting("T", "0130p", "0245p", "BIL150"));
    meeting5.add(new Meeting("R", "0130p", "0245p", "BIL150"));
    meeting5.add(new Meeting("F", "1200p", "0115p", "MSB114"));

    CourseDB.addCourse(new CourseFormData(null, "84095", "ICS 141", "002", "Discrete Math for CS I", "K Sugihara",
        "7", meeting5, "BIL150"));

    // ICS211
    List<Meeting> meeting6 = new ArrayList<Meeting>();
    List<String> focusList = new ArrayList<>();
    focusList.add("ETH");
       
    meeting6.add(new Meeting("M", "1030a", "1145a", "MSB114"));
    meeting6.add(new Meeting("W", "1030a", "1145a", "MSB114"));
    meeting6.add(new Meeting("W", "0300p", "0415p", "POST319"));
    meeting6.add(new Meeting("F", "0300p", "0415p", "POST319"));

    CourseDB.addCourse(new CourseFormData(focusList, "84095", "ICS 211", "001", "Intro to Computer Science II",
        "C Moore", "3", meeting6, "MSB114"));
    
    
    // Create schedules and watch lists for users
    UserInfo user = UserInfoDB.getUser("rnamahoe");
    user.addToSchedule(CourseDB.getCourse("85248"));
    user.addToWatchList(CourseDB.getCourse("86041"));
    user.addToSchedule(CourseDB.getCourse("84095"));

  }
}

import play.Application;
import play.GlobalSettings;
import models.MeetingDB;
import models.UserCommentDB;
import models.CourseDB;
import models.UserInfo;
import models.UserInfoDB;

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
    
    


    // ICS101B
    MeetingDB.addMeeting("85248", "T", "0900a", "1015a", "BIL152");
    MeetingDB.addMeeting("85248", "T", "1030a", "1145a", "POST318A");
    MeetingDB.addMeeting("85248", "R", "1030a", "1145a", "POST318A");

    CourseDB.addCourse("", "85248", "ICS 101B", "003", "Tools Inf Age: General", "3", "K Binsted");

    // ICS101B
    
    
    MeetingDB.addMeeting("85251","T", "0900a", "1015a", "BIL152");
    MeetingDB.addMeeting("85251","T", "1200p", "0115p", "POST318A");
    MeetingDB.addMeeting("85251","R", "1200p", "0115p", "POST318A");

    CourseDB.addCourse("", "85251", "ICS 101B", "006", "Tools Inf Age: General", "3", "K Binsted");

    
    MeetingDB.addMeeting("86041","T", "1030a", "1145a", "POST319");
    MeetingDB.addMeeting("86041","R", "1030a", "1145a", "POST319");

    CourseDB.addCourse("", "86041", "ICS 110", "001", "Programming through Animations", "3", "G Poisson");
  
    
    MeetingDB.addMeeting("84935", "M", "0530p", "0800p", "BIL152");
    MeetingDB.addMeeting("84935", "W", "0530p", "0645p", "POST319");

    CourseDB.addCourse("", "84935", "ICS 111", "003", "Intro to Computer Science I", "3", "R Narayan");

    MeetingDB.addMeeting("84095", "T", "0130p", "0245p", "BIL150");
    MeetingDB.addMeeting("84095", "R", "0130p", "0245p", "BIL150");
    MeetingDB.addMeeting("84095", "F", "1200p", "0115p", "MSB114");

    CourseDB.addCourse("", "84095", "ICS 141", "002", "Discrete Math for CS I", "4", "K Sugihara");

       
    MeetingDB.addMeeting("84095", "M", "1030a", "1145a", "MSB114");
    MeetingDB.addMeeting("84095", "W", "1030a", "1145a", "MSB114");
    MeetingDB.addMeeting("84095", "W", "0300p", "0415p", "POST319");
    MeetingDB.addMeeting("84095", "F", "0300p", "0415p", "POST319");

    CourseDB.addCourse("WI", "84095", "ICS 211", "001", "Intro to Computer Science II", "3", "C Moore");
    
    // Create schedules and watch lists for users
    UserInfo user = UserInfoDB.getUser("rnamahoe");
    user.addToSchedule(CourseDB.getCourse("85248"));
    user.addToWatchList(CourseDB.getCourse("86041"));
    user.addToSchedule(CourseDB.getCourse("84095"));

  }
}

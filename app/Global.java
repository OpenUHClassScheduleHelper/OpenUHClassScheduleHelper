import java.util.ArrayList;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import controllers.JauntObj;
import controllers.JauntRowItem;
import controllers.SendEmail;
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
    UserCommentDB.removeAllComments();
    UserCommentDB.addComment("84935", "jortal", "Professor Narayan is in the process of trying to make ICS 111 a WI credit.");
    UserCommentDB.addComment("84935", "rnamahoe", "Tough class but you sure do learn a lot!");
    UserCommentDB.addComment("86041", "rnamahoe", "I thought ICS111 was hard...this class is impossible!");
    UserCommentDB.addComment("84935", "rnarayan", "This class will now be available with a WI credit.");
    UserCommentDB.addComment("84494", "julia4", "This class will be conducted as an online course.");
    
    // Populate database
    populateTables("https://www.sis.hawaii.edu/uhdad/avail.classes?i=MAN&t=201430&s=ICS");
    populateTables("https://www.sis.hawaii.edu/uhdad/avail.classes?i=MAN&t=201430&s=ENG");

  }
  
  private void populateTables(String url) {
    JauntObj jaunt = new JauntObj(url);
    ArrayList<JauntRowItem> results = JauntObj.getResults();
    ArrayList<JauntRowItem> meetings = JauntObj.getMeeting();
    for (JauntRowItem item : results) {
      CourseDB.addCourse(item.getFocus(), item.getCrn(), item.getCourse(), item.getSection(), item.getTitle(),
                          "", item.getInstructor());
    }
    for (JauntRowItem meet : meetings) {
      MeetingDB.addMeeting(meet.getCrn(), meet.getDays(), meet.getStart(), meet.getEnd(), meet.getLocation());
    }
  }
  
}

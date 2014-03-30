import play.Application;
import play.GlobalSettings;
import models.UserCommentDB;
import models.UserInfoDB;

/**
 * Global settings for the Play application.
 * @author Rob Namahoe
 */
public class Global extends GlobalSettings {

  /**
   * Overrides the onStart method.
   * @param app The Play application.
   */
  public void onStart(Application app) {
    
    // Add students to the database
    UserInfoDB.addUserInfo("rnamahoe", "Robert", "Namahoe", "student");
    UserInfoDB.addUserInfo("ekomiyama", "Evan", "Komiyama", "student");
    UserInfoDB.addUserInfo("jortal", "Jon", "Ortal", "student");
    
    // Add instructors to the database
    UserInfoDB.addUserInfo("rnarayan", "Ravi", "Narayan", "faculty");
    UserInfoDB.addUserInfo("sugihara", "Kazuo", "Sugihara", "faculty");
    UserInfoDB.addUserInfo("julia4", "Julia", "Patriarche", "faculty");
    
    // Add User Comments to the database
    UserCommentDB.addComment("84935", "jortal", "Professor Narayan is in the process of trying to make ICS 111 a WI credit.");
    UserCommentDB.addComment("84935", "rnarayan", "This class will now be available with a WI credit.");
    UserCommentDB.addComment("84494", "julia4", "This class will be conducted as an online course.");
  }
}

import play.Application;
import play.GlobalSettings;
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
    
  }
}

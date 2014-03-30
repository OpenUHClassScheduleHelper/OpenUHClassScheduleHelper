import play.Application;
import play.GlobalSettings;
import models.UserInfoDB;
import models.UserCommentDB;

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
    
    // Add users to the database
    UserInfoDB.addUserInfo("Rob Namahoe", "rnamahoe@hawaii.edu", "password");
    UserInfoDB.addUserInfo("Evan Komiyama", "evkomiyama@gmail.com", "password");
    UserInfoDB.addUserInfo("Jon Ortal", "jortal@hawaii.edu", "password");
    
    // Add User Comments
    UserCommentDB.addComment("1", "rcn", "this is a test.");
    
    
    
  }
}

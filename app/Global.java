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
    
    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
    
  }
}

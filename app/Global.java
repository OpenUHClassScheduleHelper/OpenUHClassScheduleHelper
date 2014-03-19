import play.Application;
import play.GlobalSettings;
import models.CourseDB;
import models.UserInfoDB;
import views.formdata.CourseFormData;

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
    
    /** Adds a user. **/
    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
    
    /** Adds a course. **/
    CourseDB.addCourse(new CourseFormData("85248", "ICS 101B", "003", "Tools Inf Age: General", "K Binsted", "BIL 152"));
    CourseDB.addCourse(new CourseFormData("85251", "ICS 101B", "006", "Tools Inf Age: General", "K Binsted", "BIL 152"));
    CourseDB.addCourse(new CourseFormData("85242", "ICS 101B", "007", "Tools Inf Age: General", "K Binsted", "BIL 152"));
    CourseDB.addCourse(new CourseFormData("85254", "ICS 101B", "011", "Tools Inf Age: General", "K Binsted", "BIL 152"));
    CourseDB.addCourse(new CourseFormData("85255", "ICS 101B", "012", "Tools Inf Age: General", "K Binsted", "BIL 152"));
    
  }
}

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
    
    /** 
	 *  Adds a course. 
	 *  CRN, course name, section, course title, credits, instructor, seats, days, time 
	**/
	
    CourseDB.addCourse(new CourseFormData("85248", "ICS 101B", "003", "Tools Inf Age: General", "4", 
					                     +"K Binsted", "4", "TR", "0900-1015a"));
    CourseDB.addCourse(new CourseFormData("85251", "ICS 101B", "006", "Tools Inf Age: General", "4", 
					                     +"K Binsted", "0", "TR", "0900-1015a"));
    CourseDB.addCourse(new CourseFormData("86041", "ICS 110", "001", "Programming through Animations", "3", 
					                     +"G Poisson", "12", "TR", "1030-1145a"));
    CourseDB.addCourse(new CourseFormData("84935", "ICS 111", "003", "Intro to Computer Science I", "4", 
					                     +"R Narayan", "4", "MW", "0530-0800p"));
    CourseDB.addCourse(new CourseFormData("84095", "ICS 141", "002", "Discrete Math for CS I", "3", 
					                     +"K Sugihara", "7", "TRF", "0130-0245p"));
    CourseDB.addCourse(new CourseFormData("84095", "ICS 211", "001", "Intro to Computer Science II", "3", 
					                     +"C Moore", "3", "MWF", "1030-1145a"));
	/** add more here 
    CourseDB.addCourse(new CourseFormData("85248", "ICS 101B", "003", "Tools Inf Age: General", "4", 
					                     +"K Binsted", "4", "T TR", "0900-1015a"));
    CourseDB.addCourse(new CourseFormData("85248", "ICS 101B", "003", "Tools Inf Age: General", "4", 
					                     +"K Binsted", "4", "T TR", "0900-1015a"));
    CourseDB.addCourse(new CourseFormData("85248", "ICS 101B", "003", "Tools Inf Age: General", "4", 
					                     +"K Binsted", "4", "T TR", "0900-1015a"));
    CourseDB.addCourse(new CourseFormData("85248", "ICS 101B", "003", "Tools Inf Age: General", "4", 
					                     +"K Binsted", "4", "T TR", "0900-1015a"));
    CourseDB.addCourse(new CourseFormData("85248", "ICS 101B", "003", "Tools Inf Age: General", "4", 
					                     +"K Binsted", "4", "T TR", "0900-1015a"));
    **/										 
  }
}

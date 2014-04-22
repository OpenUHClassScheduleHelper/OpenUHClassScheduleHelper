import java.util.ArrayList;
import java.util.List;
import controllers.JauntCourseItem;
import controllers.JauntMeetingItem;
import controllers.JauntObj;
import play.Application;
import play.GlobalSettings;
import models.Course;
import models.Meeting;
import models.MeetingDB;
import models.UserCommentDB;
import models.CourseDB;
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
    
    // Add User Comments to the database
    UserCommentDB.removeAllComments();
    UserCommentDB.addComment("84935", "jortal", "Professor Narayan is in the process of trying to make ICS 111 a WI credit.");
    UserCommentDB.addComment("84935", "rnamahoe", "Tough class but you sure do learn a lot!");
    UserCommentDB.addComment("86041", "rnamahoe", "I thought ICS111 was hard...this class is impossible!");


    // If tables are empty then scrape data from all pages
    ArrayList<JauntObj> scrapers = new ArrayList<JauntObj>();
    if (Course.find().all().size() < 1) {
      String url = "https://www.sis.hawaii.edu/uhdad/avail.classes?i=MAN&t=201510";
      ArrayList<String> links = JauntObj.getLinks(url);
      for (String link : links) {
        JauntObj ps = new JauntObj(link);
        ps.start();
        scrapers.add(ps);
      }
      for (JauntObj scraper : scrapers) {
        try {
          scraper.join();
        }
        catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      
      List<JauntCourseItem> courses = JauntObj.getCourses();
      List<JauntMeetingItem> meetings = JauntObj.getMeetings();
      
      for (JauntCourseItem jauntCourseItem : courses) {
        CourseDB.addCourse(new Course(jauntCourseItem));
      }
      
      for (JauntMeetingItem jauntMeetingItem : meetings) {
        MeetingDB.addMeeting(new Meeting(jauntMeetingItem));
      }
     
      System.out.println("Done scraping.");
    }
  }
}

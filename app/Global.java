import java.util.ArrayList;
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

    // Scrape data from a single page
    //populateTablesFromPage("https://www.sis.hawaii.edu/uhdad/avail.classes?i=MAN&t=201430&s=ICS");
    //populateTablesFromPage("https://www.sis.hawaii.edu/uhdad/avail.classes?i=MAN&t=201430&s=ENG");

    // If tables are empty then scrape data from all pages
    if (Course.find().all().size() == 0) {
      populateTablesFromPages("https://www.sis.hawaii.edu/uhdad/avail.classes?i=MAN&t=201430");
    }  
  }
  
  /**
   * Scrape course information from all links on the target page.
   * @param url The url of the target page.
   */
  private void populateTablesFromPages(String url) {
    JauntObj jaunt = new JauntObj();
    jaunt.scrapeLinks(url);
    ArrayList<JauntCourseItem> courses = jaunt.getCourses();
    ArrayList<JauntMeetingItem> meetings = jaunt.getMeetings();
    
    for (JauntCourseItem jauntCourseItem : courses) {
      CourseDB.addCourse(new Course(jauntCourseItem));
    }
    for (JauntMeetingItem jauntMeetingItem : meetings) {
      Meeting meeting = new Meeting(jauntMeetingItem);
      MeetingDB.addMeeting(meeting);
    }
  }
  
  /**
   * Scrape course information from the target page.
   * @param url The url of the target page.
   */
  private void populateTablesFromPage(String url) {
    JauntObj jaunt = new JauntObj();
    jaunt.scrapeUrl(url);
    
    ArrayList<JauntCourseItem> courses = jaunt.getCourses();
    ArrayList<JauntMeetingItem> meetings = jaunt.getMeetings();
    
    for (JauntCourseItem jauntCourseItem : courses) {
      CourseDB.addCourse(new Course(jauntCourseItem));
    }
    for (JauntMeetingItem jauntMeetingItem : meetings) {
      Meeting meeting = new Meeting(jauntMeetingItem);
      MeetingDB.addMeeting(meeting);
    }
  }
  
}

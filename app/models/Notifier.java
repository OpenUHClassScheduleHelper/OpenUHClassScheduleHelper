package models;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.TimerTask;
import controllers.SendEmail;

public class Notifier extends TimerTask {

  /**
   * Generate texts/emails to users who have opted-in to receive notification of late breaking news.
   */
  public void run() {
    // Get a list of all users who have opted-in to receive notification.
    List<UserInfo> users = UserInfo.find().where().eq("notificationPreference", "Opt-in").findList();
    if (users.size() > 0) {
      // Calculate the parameter date; yesterday at 5pm.
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DATE, -1);    
      cal.setTimeZone(TimeZone.getTimeZone("HST"));    
      cal.set(Calendar.HOUR_OF_DAY, 17);
      cal.set(Calendar.MINUTE, 00);
      cal.set(Calendar.SECOND, 0);
      long postTime = cal.getTimeInMillis();
      
      // Query database for comments made after the parameter date.
      List<UserComment> comments = UserComment.find().where().gt("postTime", postTime).findList();
      
      // Add comments to a hashmap to remove duplicates.
      HashMap<String, String> commentMap = new HashMap<String, String>();
      for (UserComment comment : comments) {
        commentMap.put(comment.getCrn(), comment.getComment());
      }
      
      // For each user, build a message string.
      for (UserInfo user : users) {
        String crn = "";
        String message = "";
        
        List<Course> courses = user.getSchedule();
        courses.addAll(user.getWatchList());  // add all courses in the watchlist.
        for (Course course : courses) {
          // If there is a comment, add it to the results list.
          crn = course.getCrn();
          if (commentMap.containsKey(crn)) {
            message += "CRN: " + crn + "(" + course.getCourseTitle() + ")" + ", ";
          }
          // If there is new late breaking news, notify the user.
          
          if (!message.equals("")) {
            if (!user.getEmail().equals("")) {
              // send and email
              SendEmail.SendByEmail(user.getEmail(), message);
            }
            
            if (!user.getTelephone().equals("")) {
              // send a text
              SendEmail.SendBySms(user.getTelephone(), user.getCarrier(),  message);
            }
          }
        }
      }
    }
  }
}

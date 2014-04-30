package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import controllers.SendEmail;

/**
 * A repository to store user comment information.
 * @author Rob Namahoe.
 */
public class UserCommentDB { 
  
  /**
   * Add a comment to the comment database.
   * @param crn The course CRN.
   * @param user The user adding the comment.
   * @param theComment The comment to add.
   */
  public static void addComment(String crn, String user, String theComment) {
    UserComment comment = new UserComment(crn, user, theComment);
    comment.save(); 
  }
  
  /**
   * Remove a comment from the comment database.
   * @param id The id of the comment.
   */
  public static void removeComment(long id) {
    UserComment comment = getCommentById(id);
    comment.delete();
  }
  
  /**
   * Remove a comment from the comment database.
   * @param id The comment of the id to remove.
   */
  public static void removeComment(String id) {
    removeComment(Long.parseLong(id));
  }
  
  /**
   * Remove all comments from the database.
   */
  public static void removeAllComments() {
    List<UserComment> comments = UserComment.find().all();
    Iterator<UserComment> it = comments.iterator();
    while (it.hasNext()) {
      UserComment comment = it.next();
      comment.delete();
    }
  }
  
  
  /**
   * Get a list of all comments associated with a CRN.
   * @param crn The CRN of the course.
   * @return A list of UserComment objects associated with the given CRN.
   */
  public static List<UserComment> getCommentsByCrn(String crn) {
    return UserComment.find().where().eq("crn", crn).orderBy("postTime desc").findList();
  }
  
  
  /**
   * Get a list of all comments associated with a CRN reverse chronological.
   * @param crn The CRN of the course.
   * @return A list of UserComment objects associated with the given CRN.
   */
  public static List<UserComment> getCommentsByCrnReverse(String crn) {
    List<UserComment> tempList = UserComment.find().where().eq("crn", crn).orderBy("postTime desc").findList();
    return tempList;
  }
  
  /**
   * Get the comment with the specified id number.
   * @param id The id of the comment to retrieve.
   * @return The comment.
   */
  public static UserComment getCommentById(long id) {
    return UserComment.find().byId(id);
  }
  
  /**
   * Get the comment with the specified id (passed as a string).
   * @param id The id of the comment to retrieve.
   * @return The comment.
   */
  public static UserComment getCommentById(String id) {
    return getCommentById(Long.parseLong(id));
  }
  
  /**
   * Get a list of all comments associated with a user.
   * @param userName The users UH username.
   * @return A list of UserComment objects associated with the given user.
   */
  public static List<UserComment> getCommentsByUserName(String userName) {
    return UserComment.find().where().eq("userName", userName).orderBy("postTime desc").findList();
  }
  
  /**
   * Generate texts/emails to users who have opted-in to receive notification of late breaking news.
   */
  public static void issueNotices() {
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

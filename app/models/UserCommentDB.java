package models;

import java.util.ArrayList;

/**
 * An in-memory repo to store user comments
 * @author rckndn
 */
public class UserCommentDB { 
  
  private static ArrayList<UserComment> comments = new ArrayList<UserComment>();
  
  /**
   * Add a comment to the comment database.
   * @param crn The course CRN.
   * @param user The user adding the comment.
   * @param theComment The comment to add.
   */
  public static void addComment(String crn, String user, String theComment) {
    UserComment comment = new UserComment(crn, user, theComment);
    comments.add(comment);
  }
  
  /**
   * Get a list of all comments associated with a CRN.
   * @param crn The CRN of the course.
   * @return A list of UserComment objects associated with the given CRN.
   */
  public static ArrayList<UserComment> getCommentsByCrn(String crn) {
    ArrayList<UserComment> results = new ArrayList<UserComment>();
    for (UserComment comment : comments) {
      if (comment.getCrn().equals(crn)) {
        results.add(comment);
      }
    }
    return results;
  }
  
  /**
   * Get a list of all comments associated with a user.
   * @param userName The users UH username.
   * @return A list of UserComment objects associated with the given user.
   */
  public static ArrayList<UserComment> getCommentsByUserName(String userName) {
    ArrayList<UserComment> results = new ArrayList<UserComment>();
    for (UserComment comment : comments) {
      if (comment.getUserName().equals(userName)) {
        results.add(comment);
      }
    }
    return results;
  }
 
}

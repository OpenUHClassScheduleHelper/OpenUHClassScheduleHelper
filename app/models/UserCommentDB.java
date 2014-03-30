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
    System.out.println(comment.getDate());
    System.out.println(comment.getTime());
    comments.add(comment);
  }
  
  /**
   * Get a list of all comments associated with a CRN.
   * @param crn The CRN of the course.
   * @return A list of UserComment objects associated with the given CRN.
   */
  public ArrayList<UserComment> getCommentsByCrn(String crn) {
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
   * @param user The user name.
   * @return A list of UserComment objects associated with the given user.
   */
  public ArrayList<UserComment> getCommentsByUser(String user) {
    ArrayList<UserComment> results = new ArrayList<UserComment>();
    for (UserComment comment : comments) {
      if (comment.getUser().equals(user)) {
        results.add(comment);
      }
    }
    return results;
  }
  
}

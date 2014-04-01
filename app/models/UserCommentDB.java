package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * An in-memory repo to store user comments
 * @author Rob Namahoe
 */
public class UserCommentDB { 
  
  //private static ArrayList<UserComment> comments = new ArrayList<UserComment>();
  private static Map<Long, UserComment> comments = new HashMap<Long, UserComment>();
  
  /**
   * Add a comment to the comment database.
   * @param crn The course CRN.
   * @param user The user adding the comment.
   * @param theComment The comment to add.
   */
  public static void addComment(String crn, String user, String theComment) {
    long id = getNextId();
    UserComment comment = new UserComment(crn, user, theComment);
    comments.put(id, comment);
  }
  
  /**
   * Remove a comment from the comment database.
   * @param id The id of the comment.
   */
  public static void removeComment(long id) {
    comments.remove(id);
  }
  
  /**
   * Get a list of all comments associated with a CRN.
   * @param crn The CRN of the course.
   * @return A list of UserComment objects associated with the given CRN.
   */
  public static List<UserComment> getCommentsByCrn(String crn) {
    ArrayList<UserComment> results = new ArrayList<UserComment>();
    for (Map.Entry<Long, UserComment> cursor : comments.entrySet()) {
      UserComment comment = cursor.getValue();
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
    for (Map.Entry<Long, UserComment> cursor : comments.entrySet()) {
      UserComment comment = cursor.getValue();
      if (comment.getUserName().equals(userName)) {
        results.add(comment);
      }
    }
    return results;
  }
 
  /**
   * Get the next available comment id.
   * @return The next available id.
   */
  public static long getNextId() {
    long nextId = 0;
    
    for (Long cursor : comments.keySet()) {
      if (nextId <= cursor) {
        nextId = cursor;
      }
    }
    nextId++;
    return nextId;
  }
  
}

package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    return UserComment.find().where().eq("crn", crn).findList();
  }
  
  
  /**
   * Get a list of all comments associated with a CRN reverse chronological.
   * @param crn The CRN of the course.
   * @return A list of UserComment objects associated with the given CRN.
   */
  public static List<UserComment> getCommentsByCrnReverse(String crn) {
    List<UserComment> tempList = UserComment.find().where().eq("crn", crn).findList();
    List<UserComment> newList = new ArrayList<>();
    for(int i = tempList.size()-1; i == 0; i--) {
      newList.add(tempList.get(i));
    }
    return newList;
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
    return UserComment.find().where().eq("userName", userName).findList();
  }
 
}

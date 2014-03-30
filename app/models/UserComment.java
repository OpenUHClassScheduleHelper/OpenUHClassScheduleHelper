package models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * An object to store comment information.
 * @author rckndn
 */
public class UserComment {

  private String crn;
  private String user;
  private String comment;
  private long currentTime;
  
  /**
   * The constructor method.
   * @param crn The course CRN
   * @param user The user adding the comment
   * @param comment The comment
   */
  public UserComment(String crn, String user, String comment) {
    this.crn = crn;
    this.user = user;
    this.comment = comment;
    this.currentTime = System.currentTimeMillis();
  }
  
  /**
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }
  
  /**
   * @param crn the crn to set
   */
  public void setCrn(String crn) {
    this.crn = crn;
  }
  
  /**
   * @return the user
   */
  public String getUser() {
    return user;
  }
  
  /**
   * @param user the user to set
   */
  public void setUser(String user) {
    this.user = user;
  }
  
  /**
   * @return the comment
   */
  public String getComment() {
    return comment;
  }
  
  /**
   * @param comment the comment to set
   */
  public void setComment(String comment) {
    this.comment = comment;
  }
  
  /**
   * @return the day
   */
  public String getDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
    Date resultdate = new Date(this.currentTime);
    return sdf.format(resultdate);
  }
  
  /**
   * @return the time
   */
  public String getTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Date resultdate = new Date(this.currentTime);
    return sdf.format(resultdate);
  }
  
  
}

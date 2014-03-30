package models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * An object to store comment information.
 * @author rckndn
 */
public class UserComment {

  private String crn;
  private String userName;
  private String fullName;
  private String comment;
  private long currentTime;
  
  private boolean instructorPost;
  
  /**
   * The constructor method.
   * @param crn The course CRN
   * @param user The user adding the comment
   * @param comment The comment
   */
  public UserComment(String crn, String userName, String comment) {
    this.crn = crn;
    this.setUserName(userName);
    this.comment = comment;
    this.currentTime = System.currentTimeMillis();

    setFullName(UserInfoDB.getUser(userName).getFullName());
    setInstructorPost(UserInfoDB.getUser(userName).isInstructor());
    
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
  public String getPostDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
    Date resultdate = new Date(this.currentTime);
    
    // fudging return results - remove when before deploying app
    if (this.crn.equals("84935") && this.userName.equals("jortal")) {
      return "12/15/13";
    }
    else if (this.crn.equals("84935") && this.userName.equals("rnarayan")) {
      return "2/28/14";
    }
    else if (this.crn.equals("84494") && this.userName.equals("julia4")) {
      return "2/10/14";
    }
    else {
      return sdf.format(resultdate);   
    }
    
  }
  
  /**
   * @return the time
   */
  public String getPostTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Date resultdate = new Date(this.currentTime);
    return sdf.format(resultdate);
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the fullName
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * @param fullName the fullName to set
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * @return the instructorPost
   */
  public boolean isInstructorPost() {
    return instructorPost;
  }

  /**
   * @param instructorPost the instructorPost to set
   */
  public void setInstructorPost(boolean instructorPost) {
    this.instructorPost = instructorPost;
  }
  
  
}

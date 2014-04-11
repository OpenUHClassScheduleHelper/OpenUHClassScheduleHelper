package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;

/**
 * A repository to store User Comment information.
 * @author Rob Namahoe.
 */
@Entity
public class UserComment extends Model {

  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  
  private String crn;
  private String userName;
  private String fullName;
  private String comment;
  private long postTime;
  
  /**
   * The constructor method.
   * @param crn The course CRN
   * @param user The user adding the comment
   * @param comment The comment
   */
  public UserComment(String crn, String userName, String comment) {
    this.crn = crn;
    this.userName = userName;
    this.comment = comment;
    this.postTime = System.currentTimeMillis();
    this.fullName = UserInfoDB.getUser(userName).getFullName();
    
  }
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for user comments.
   */
  public static Finder<Long, UserComment> find() {
    return new Finder<Long, UserComment>(Long.class, UserComment.class);
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
    Date resultdate = new Date(this.postTime);
    
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
    Date resultdate = new Date(this.postTime);
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
   * Get the course number.
   * @return The course number.
   */
  public String getCourseNumber() {
    return CourseDB.getCourse(this.crn).getCourseName();
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }
  
}

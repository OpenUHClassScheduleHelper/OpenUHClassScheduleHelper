package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * Represents an event on the FullCalendar component.
 * @author rckndn
 */
@Entity
public class CourseRoster extends Model {
  
  private static final long serialVersionUID = 1L;

  @Id
  private long id;
  
  @ManyToOne
  private UserInfo userInfo;
  
  @ManyToOne
  private Course course;
  
  private String status;
  
  public CourseRoster(UserInfo userInfo, Course course, String status) {
    this.userInfo = userInfo;
    this.course = course;
    this.status = status;
  }
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for users.
   */
  public static Finder<Long, CourseRoster> find() {
    return new Finder<Long, CourseRoster>(Long.class, CourseRoster.class);
  }
  
  /**
   * @return the userInfo
   */
  public UserInfo getUserInfo() {
    return userInfo;
  }
  /**
   * @param userInfo the userInfo to set
   */
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }
  /**
   * @return the course
   */
  public Course getCourse() {
    return course;
  }
  /**
   * @param course the course to set
   */
  public void setCourse(Course course) {
    this.course = course;
  }
  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }
  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }
  
}

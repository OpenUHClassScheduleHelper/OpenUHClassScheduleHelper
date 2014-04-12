package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;

/**
 * A class to keep track of which comments a user has seen.
 * @author Rob Namahoe
 */
@Entity
public class ViewedComment extends Model {

  private static final long serialVersionUID = 1L;
  
  @Id
  private long Id;
  
  private String userName;
  private String crn;
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for courses.
   */
  public static Finder<Long, ViewedComment> find() {
    return new Finder<Long, ViewedComment>(Long.class, ViewedComment.class);
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
   * @return the id
   */
  public long getId() {
    return Id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    Id = id;
  }
 
}

package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import play.db.ebean.Model;

/**
 * Represents users of the application.
 * @author Rob Namahoe
 */
@Entity
public class UserInfo extends Model {
 
  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  
  private String userName;   
  private String firstName; 
  private String lastName;
  private String notificationPreference;
  private String email;
  private String telephone;
  private String carrier;
  
  
  // One of me (user) maps to many of the following (courses) in the schedule.
  @OneToMany(mappedBy="userInfo")
  private List<Course> schedule = new ArrayList<>();
  
  /**
   * Creates a new UserInfo instance.
   * @param userName The UH username of the user.
   * @param firstName The users first name.
   * @param lastName The users last name.
   */
  public UserInfo(String userName, String firstName, String lastName) {
    this.userName = userName;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Creates a new UserInfo instance.
   * @param userName The UH username of the current user.
   */
  public UserInfo(String userName) {
    this.userName = userName;
  }
  
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for users.
   */
  public static Finder<Long, UserInfo> find() {
    return new Finder<Long, UserInfo>(Long.class, UserInfo.class);
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
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the telephone
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * @param telephone the telephone to set
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * Get the users full name.
   * @return The users first and last name.
   */
  public String getFullName() {
    String fullName = this.firstName + " " + this.lastName;
    return (fullName.trim().length() == 0) ? "N/A" : fullName;
  }
  
  /**
   * Add a course to the current users schedule.
   * @param course The course to add.
   */
  public void addToSchedule(Course course) {
    course.setUserInfo(UserInfoDB.getUser(this.userName));
    course.save();
    this.schedule.add(course);
  }
  
  /**
   * Add a course to the users schedule by crn.
   * @param crn The crn of the course to add.
   */
  public void addToSchedule(String crn) {
    addToSchedule(CourseDB.getCourseByCrn(crn));
  }
  
  /**
   * Remove a course from the current users schedule.
   * @param course The course to remove.
   */
  public void removeFromSchedule(Course course) {
    // If the course is in the schedule, then remove it.
    Iterator<Course> it = this.schedule.iterator();
    while (it.hasNext()) {
      Course scheduledCourse = it.next();
      if (scheduledCourse.getCrn().equals(course.getCrn())) {
        scheduledCourse.setUserInfo(null);
        scheduledCourse.save();
        it.remove();
      }
    }
  }
  
  /**
   * Remove a course from the current users schedule by CRN.
   * @param crn The crn of the course to remove.
   */
  public void removeFromSchedule(String crn) {
    Course course = CourseDB.getCourse(crn);
    removeFromSchedule(course);
  }
  
  /**
   * Add a course to the current users watch list.
   * @param course The course to watch.
   */
  public void addToWatchList(Course course) {
    course.setWatching(true);
    addToSchedule(course);
  }
  
  /**
   * Add a course to the users watchlist by crn.
   * @param crn The crn of the course to add.
   */
  public void addToWatchList(String crn) {
    addToWatchList(CourseDB.getCourseByCrn(crn));
  }
  
  /**
   * Remove a course from the current users watch list.
   * @param course The course to remove.
   */
  public void removeFromWatchList(Course course) {
    // If the course exists in the watch list, then remove it.
    removeFromSchedule(course);
  }
  
  /**
   * Remove a course from the current users watchlist by CRN.
   * @param crn The crn of the course to remove.
   */
  public void removeFromWatchList(String crn) {
    Course watchedCourse = CourseDB.getCourse(crn);
    removeFromWatchList(watchedCourse);
  }
  
  /**
   * Get the list of courses in the users schedule.
   * @return A list of courses in the users schedule.
   */
  public List<Course> getSchedule() {
    return getList(false);
  }
  
  /**
   * Get the list of courses in the users watch list.
   * @return A list of courses in the users watch list.
   */
  public List<Course> getWatchList() {
    return getList(true);
  }
  
  /**
   * A private method to retrieve the required course list.
   * @param isWatching true to retrieve the watchlist, false to retrieve the schedule.
   * @return A list of courses.
   */
  private List<Course> getList(boolean isWatching) {
    List<Course> results = new ArrayList<Course>();
    Iterator<Course> it = this.schedule.iterator();
    while (it.hasNext()) {
      Course scheduledCourse = it.next();
      if (scheduledCourse.isWatching() == isWatching) {
        results.add(scheduledCourse);
      }
    }
    return results;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the carrier
   */
  public String getCarrier() {
    return carrier;
  }

  /**
   * @param carrier the carrier to set
   */
  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  /**
   * @return the notificationPreference
   */
  public String getNotificationPreference() {
    return notificationPreference;
  }

  /**
   * @param notificationPreference the notificationPreference to set
   */
  public void setNotificationPreference(String notificationPreference) {
    this.notificationPreference = notificationPreference;
  }
  
  /**
   * Finds out if the user wants to be notified of new late breaking news.
   * @return true if the user wants to be notified, false otherwise.
   */
  public boolean wantsNotification() {
    return this.notificationPreference.equals("Opt-in");
  }
  
}

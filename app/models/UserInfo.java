package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Represents users of the application.
 * @author Rob Namahoe
 */
public class UserInfo {
 
  private String userName;   
  private String firstName; 
  private String lastName;
  private String role;    
  private String telephone;
  
  private static Map<String, Course> schedule = new HashMap<String, Course>();
  private static Map<String, Course> watchList = new HashMap<String, Course>();
  
  /**
   * Creates a new UserInfo instance.
   * @param userName The UH username of the user.
   * @param firstName The users first name.
   * @param lastName The users last name.
   * @param role The users eduPersonAffiliation - student, faculty, etc.
   */
  public UserInfo(String userName, String firstName, String lastName, String role) {
    this.userName = userName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
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
   * @return the role
   */
  public String getRole() {
    return role;
  }

  /**
   * @param role the role to set
   */
  public void setRole(String role) {
    this.role = role;
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
    return this.firstName + " " + this.lastName;
  }
  
  /**
   * Determines if the current user is faculty.
   * @return true if the current user is a faculty member, false otherwise.
   */
  public boolean isInstructor() {
    return role.equals("faculty");
  }
  
  /**
   * Add a course to the current users schedule.
   * @param course The course to add.
   */
  public void addToSchedule(Course course) {
    schedule.put(course.getCourseNumber(), course);
  }
  
  /**
   * Remove a course from the current users schedule.
   * @param course The course to remove.
   */
  public void removeFromSchedule(Course course) {
    // If the course is in the schedule, then remove it.
    if (schedule.containsKey(course.getCourseNumber())) {
      schedule.remove(course.getCourseNumber());
    }
  }
  
  /**
   * Add a course to the current users watch list.
   * @param course The course to watch.
   */
  public void addToWatchList(Course course) {
    watchList.put(course.getCourseNumber(), course);
  }
  
  /**
   * Remove a course from the current users watch list.
   * @param course The course to remove.
   */
  public void removeFromWatchList(Course course) {
    // If the course exists in the watch list, then remove it.
    if (watchList.containsKey(course.getCourseNumber())) {
      watchList.remove(course.getCourseNumber());
    }
  }
  
  /**
   * Get the list of courses in the users schedule.
   * @return A list of courses in the users schedule.
   */
  public static ArrayList<Course> getSchedule() {
    return new ArrayList<Course>(schedule.values());
  }
  
  /**
   * Get the list of courses in the users watch list.
   * @return A list of courses in the users watch list.
   */
  public static ArrayList<Course> getWatchList() {
    return new ArrayList<Course>(watchList.values());
  }
  
  
  
}

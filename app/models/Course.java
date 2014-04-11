package models;

import java.util.List;
import models.Meeting;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

@Entity
public class Course extends Model {

  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  
  // Many of me (courses) maps to One of the following (userinfo)
  @ManyToOne
  private UserInfo userInfo;
  
  
  // Many of me (courses) maps to One of the following (userinfo)
  @ManyToOne
  private UserInfo userInfoWatch;
  
  private List<String> genFocus;
  private String courseNumber;  // CRN
  private String courseName;
  private String section;
  private String courseTitle;
  private String credits;
  private String instructor;
  private List<Meeting> meeting;
  private String room;

  /**
   * default constructor.
   */
  public Course() {
    // default constructor
  }

  /**
   * Constructor.
   * 
   * @param genFocus
   * @param courseNumber
   * @param courseName
   * @param section
   * @param courseTitle
   * @param credits
   * @param instructor
   * @param meeting object (todo)
   * @param department
   * @param room TODO: add new parameters, get/set them
   */
  public Course(List<String> genFocus, String courseNumber, String courseName, String section, String courseTitle,
      String credits, String instructor, List<Meeting> meeting, String room) {

    this.setGenFocus(genFocus);
    this.setCourseNumber(courseNumber);
    this.setCourseName(courseName);
    this.setSection(section);
    this.setCourseTitle(courseTitle);
    this.setCredits(credits);
    this.setInstructor(instructor);
    this.setRoom(room);
    this.setMeeting(meeting);

  }

  public List<String> getGenFocus() {
    return genFocus;
  }
  
  public String printGenFocusList() {
    String list = "";
    if(this.genFocus == null) {
      return list;
    }
    
    for(int i = 0; i < this.genFocus.size(); i++) {
      if(i < this.genFocus.size() - 1) {
        list += this.genFocus.get(i) + ", ";
      }else {
        list += this.genFocus.get(i);
      }
    }
    return list;
  }

  public void setGenFocus(List<String> genFocus) {
    this.genFocus = genFocus;
  }

  public String getCredits() {
    return credits;
  }

  public void setCredits(String credits) {
    this.credits = credits;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public String getInstructor() {
    return instructor;
  }

  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

  public String getCourseTitle() {
    return courseTitle;
  }

  public void setCourseTitle(String courseTitle) {
    this.courseTitle = courseTitle;
  }

  public String getSection() {
    return section;
  }

  public void setSection(String section) {
    this.section = section;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getCourseNumber() {
    return courseNumber;
  }

  public void setCourseNumber(String courseNumber) {
    this.courseNumber = courseNumber;
  }

  public List<Meeting> getMeeting() {
    return meeting;
  }

  public void setMeeting(List<Meeting> meeting) {
    this.meeting = meeting;
  }
  
  public String getCourseDept() {
    return this.courseName.split(" ")[0];
  }
  
  public String printMeeting() {
    String meetingString = "";
    return meetingString;
  }
  
  public String printRooms() {
    String rooms = "";
    for(Meeting newMeeting : meeting) {
      if(rooms != "") {
        rooms = rooms + ", " + newMeeting.getRoom();
      }else {
        rooms = newMeeting.getRoom();
      }
    }
    return rooms;
  }
  
  /**
   * Get the CRN for the current course.
   * @return The crn of the current course.
   */
  public String getCrn() {
    return this.courseNumber;
  }
  
  /**
   * @return The userInfo
   */
  public UserInfo getUserInfo() {
    return userInfo;
  }
  
  /**
   * Set the userInfo object.
   * @param userInfo the userInfo to set.
   */
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }
  
}
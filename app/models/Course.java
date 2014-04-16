package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Course extends Model {

  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  
  // Many of me (courses) maps to One of the following (userinfo)
  @ManyToOne
  private UserInfo userInfo;
  
  private String genFocus;
  private String crn;  // CRN
  private String courseName;
  private String section;
  private String courseTitle;
  private String credits;
  private String instructor;
  private String department;
  
  private boolean watching = false;
  
  /**
   * default constructor.
   */
  public Course() {
    // default constructor
  }

  /**
   * Constructor.
   * @param genFocus The General focus attributes, if applicable.
   * @param crn The crn of the course.
   * @param courseName The name of the course, i.e. 'ICS 311'.
   * @param section The section of the course.
   * @param courseTitle The title of the course, i.e. 'Algorithms'.
   * @param credits The number of credits.
   * @param instructor The instructor.
   */
  public Course(String genFocus, String crn, String courseName, String section, String courseTitle, String credits, String instructor) {

    this.setGenFocus(genFocus);
    this.setCourseNumber(crn);
    this.setCourseName(courseName);
    this.setSection(section);
    this.setCourseTitle(courseTitle);
    this.setCredits(credits);
    this.setInstructor(instructor);
    
    // parse department from course name.
    if(courseName.contains(" ")){
      this.department = courseName.substring(0, courseName.indexOf(" ")).trim(); 
   }
  }

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for courses.
   */
  public static Finder<Long, Course> find() {
    return new Finder<Long, Course>(Long.class, Course.class);
  }
  
  public String getGenFocus() {
    return genFocus;
  }
  
  public void setGenFocus(String genFocus) {
    this.genFocus = genFocus;
  }

  public String getCredits() {
    return credits;
  }

  public void setCredits(String credits) {
    this.credits = credits;
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
    return this.crn;
  }

  public void setCourseNumber(String courseNumber) {
    this.crn = courseNumber;
  }
  
  public String printMeeting() {
    String meetingString = "";
    return meetingString;
  }
  
  public String printRooms() {
    return "todo";
  }
  
  public String printGenFocusList() {
    return this.genFocus;
  }
  
  /**
   * Get the CRN for the current course.
   * @return The crn of the current course.
   */
  public String getCrn() {
    return this.crn;
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

  /**
   * @return the watching
   */
  public boolean isWatching() {
    return watching;
  }

  /**
   * @param watching the watching to set
   */
  public void setWatching(boolean watching) {
    this.watching = watching;
  }

  /**
   * @return the department
   */
  public String getDepartment() {
    return department;
  }

  /**
   * @param department the department to set
   */
  public void setDepartment(String department) {
    this.department = department;
  }
  
  /**
   * Get a list of meetings for this course.
   * @return A list of meeting objects for this course.
   */
  public List<Meeting> getMeeting() {
    return Meeting.find().where().eq("crn", this.crn).findList();
  }
  
  
  public List<Meeting> getConcatMeetings() {
    List<Meeting> currentMeetingList = getMeeting();
    List<Meeting> newMeetingList = new ArrayList<>();
    boolean separate = true;
    for(Meeting meeting : currentMeetingList) {
      separate = true;
      for(int i = 0; i < newMeetingList.size(); i++) {
        if(meeting.getStart().equals(newMeetingList.get(i).getStart()) && 
           meeting.getEnd().equals(newMeetingList.get(i).getEnd()) && 
           meeting.getRoom().equals(newMeetingList.get(i).getRoom())) {
           separate = false;
           String oldDay = newMeetingList.get(i).getDay();
           newMeetingList.get(i).setDay(oldDay + meeting.getDay());
        }
      }
      
      if(separate) {
        newMeetingList.add(meeting);
      }    
    }
    
    
    return newMeetingList;
  }
  
  
  /**
   * 
   * @return
   */
  public List<String> getMeetingTimes() {
    List<Meeting> meeting = Meeting.find().where().eq("crn", this.crn).findList(); // meeting list
    List<Meeting> meetingCopy = Meeting.find().where().eq("crn", this.crn).findList(); // copy of list for comparison
    List<Meeting> meetingCollapsed = new ArrayList<>(); // collapsed list to be returned
    int n = meeting.size();   
    
    for (int i = 0; i < n; i++) {

      for (int j = 0; j < n; j++) {        
        if (meetingCopy.get(i).getRoom().equals(meeting.get(j).getRoom()) &&
            meetingCopy.get(i).getStart().equals(meeting.get(j).getStart()) &&
            meetingCopy.get(i).getEnd().equals(meeting.get(j).getEnd()) &&
            (!meetingCopy.get(i).getDay().equals(meeting.get(j).getDay()))) {
          meetingCollapsed.add(meetingCopy.get(i));
        }
      }
    }
        
    // meetingCollapsed contains the days to be collapsed
    String mCat = "";
    int m = meetingCollapsed.size(); // size of day string
    
    // special case
    if (m == 6) {
      mCat += meetingCollapsed.get(0).getDay();
      mCat += meetingCollapsed.get(2).getDay();
      mCat += meetingCollapsed.get(4).getDay();
    }
    
    else { 
      for (int i = 0; i < m; i++) {
        mCat += meetingCollapsed.get(i).getDay();
      }
    }
    
    if (meetingCollapsed.size() > 0) {
      // construct concatenated meeting object
      Meeting newCat = new Meeting();
      newCat.setRoom(meetingCollapsed.get(0).getRoom());
      newCat.setStart(meetingCollapsed.get(0).getStart());
      newCat.setEnd(meetingCollapsed.get(0).getEnd());
      newCat.setDay(mCat);
    
      meetingCollapsed.clear();
      meetingCollapsed.add(newCat);
    }
    
    // add the meeting times that weren't concatenated
    for (int i = 0; i < n; i++) {
      if (meetingCollapsed.size() == 0) { // there were no days to concat; return the original list
        meetingCollapsed.addAll(meeting);
        break;
      }      
      if (!meeting.get(i).getRoom().equals(meetingCollapsed.get(0).getRoom())) {
        meetingCollapsed.add(meeting.get(i));
      }
    }
    
    List<String> meetingTimes = new ArrayList<>();
    for (int i = 0; i < meetingCollapsed.size(); i++) {
      meetingTimes.add(meetingCollapsed.get(i).getMeetingString());
      if (meetingCollapsed.get(i).getStart().equals("1130p")) {
        meetingCollapsed.get(i).setStart("1130a");
      }
    }
   
    return meetingTimes;  
  }
}
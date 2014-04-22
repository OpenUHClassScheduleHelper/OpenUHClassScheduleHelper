package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import controllers.JauntCourseItem;
import play.db.ebean.Model;

@Entity
public class Course extends Model {

  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;

  @OneToMany(mappedBy="course", cascade=CascadeType.ALL)
  private List<CourseRoster> students;
  
  private String genFocus;
  private String crn;
  private String courseName;
  private String section;
  private String courseTitle;
  private String credits;
  private String instructor;
  private String department;
  private String semester;
  private String campus;
  
  /**
   * default constructor.
   */
  public Course() {
    // default constructor
  }

  /**
   * Constructor method.
   * @param course A JauntCourseItem.
   */
  public Course(JauntCourseItem course) {
    this.genFocus = course.getFocus();
    this.crn = course.getCrn();
    this.courseName = course.getCourse();
    this.section = course.getSection();
    this.courseTitle = course.getTitle();
    this.credits = course.getCredits();
    this.instructor = course.getInstructor();
    this.semester = course.getSemester();
    this.campus = course.getCampus();
    
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
   * @param semester The current semester.
   * @param campus The campus the course is being offered at.
   */
  public Course(String genFocus, String crn, String courseName, String section, String courseTitle, String credits, 
                String instructor, String semester, String campus) {

    this.setGenFocus(genFocus);
    this.setCourseNumber(crn);
    this.setCourseName(courseName);
    this.setSection(section);
    this.setCourseTitle(courseTitle);
    this.setCredits(credits);
    this.setInstructor(instructor);
    this.setSemester(semester);
    this.setCampus(campus);
    
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
    // parse department from course name.
    if(courseName.contains(" ")){
      this.department = courseName.substring(0, courseName.indexOf(" ")).trim(); 
   }
  }

  public String getCourseNumber() {
    return this.crn;
  }

  public void setCourseNumber(String courseNumber) {
    this.crn = courseNumber;
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
   * @return the semester
   */
  public String getSemester() {
    return semester;
  }

  /**
   * @param semester the semester to set
   */
  public void setSemester(String semester) {
    this.semester = semester;
  }
  
  /**
   * @return the campus
   */
  public String getCampus() {
    return campus;
  }

  /**
   * @param crn The CRN of the course.
   */
  public void setCrn(String crn) {
    this.crn = crn;
  }
  
  /**
   * @param campus the campus to set
   */
  public void setCampus(String campus) {
    this.campus = campus;
  }
  
  /**
   * Get a list of meetings for this course.
   * @return A list of meeting objects for this course.
   */
  public List<Meeting> getMeeting() {
    return Meeting.find().where().eq("crn", this.crn).findList();
  }
  
  /**
   * Get a "collapsed" list of meeting times. 
   * @return A list of meeting times.
   */
  public List<String> getMeetingTimes() {
    
    String key = "";
    String days = "";
    ArrayList<String> results = new ArrayList<String>();
    Map<String, String> hs = new HashMap<String, String>();
    
    List<Meeting> meetings = Meeting.find().where().eq("crn", this.crn).findList();

    for (Meeting meeting : meetings) {
      if (meeting.getStart().equalsIgnoreCase("tba")) {
        key = "TBA" + " " + meeting.getRoom();
        days = meeting.getDay();
      }
      else {
        key = meeting.getStart() + "-" + meeting.getEnd() + " " + meeting.getRoom();
        days = "";
        if (hs.containsKey(key)) {
          days = hs.get(key);
        }
        days = days + meeting.getDay();
      }
      hs.put(key, days);
    }
    
    for (Map.Entry<String, String> entry : hs.entrySet()) {
      results.add(entry.getValue() + " " + entry.getKey());
    }
    return results;
  }

}

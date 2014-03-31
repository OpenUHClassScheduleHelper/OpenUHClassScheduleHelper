package views.formdata;
 
import java.util.ArrayList;
import java.util.List;
import models.Course;
import models.Meeting;

/**
 * Class that stores form data for the course.
 */
public class CourseFormData {

  /** gen/focus. */
  public String genFocus = "";
  /** course number. */
  public String courseNumber = "";
  /** course name. */
  public String courseName = "";
  /** course section. */
  public String section = "";
  /** course title. */
  public String courseTitle = "";
  /** credits. */
  public String credits = "0";
  /** course instructor. */
  public String instructor = "";
  /** seats. */
  public String seats = "0";
  /** meeting times. */
  public List<Meeting> meeting = null;
  /** course room number. **/
  public String room = "";

  /**
   * Default constructor.
   */
  public CourseFormData() {

  }

  /**
   * Constructor.
   * 
   * @param genFocus - gen/focus requirements
   * @param courseNumber - the course number
   * @param courseName - the course name
   * @param section - the section
   * @param courseTitle - the course title
   * @param credits - course credits
   * @param instructor - the course instructor
   * @param seats - seats available
   * @param meeting - meeting times
   * @param room - the room the course is in TODO: remove room from constructor as room will be in the meeting object
   */
  public CourseFormData(String genFocus, String courseNumber, String courseName, String section, String courseTitle,
      String credits, String instructor, String seats, List<Meeting> meeting, String room) {

    this.genFocus = genFocus;
    this.courseNumber = courseNumber;
    this.courseName = courseName;
    this.section = section;
    this.courseTitle = courseTitle;
    this.credits = credits;
    this.instructor = instructor;
    this.seats = seats;
    this.meeting = meeting;
    this.room = room;        
  }

  /**
   * Constructor form course.
   * 
   * @param course - the course.
   */
  public CourseFormData(Course course) {
    this.genFocus = course.getGenFocus();
    this.courseNumber = course.getCourseNumber();
    this.courseName = course.getCourseName();
    this.section = course.getSection();
    this.courseTitle = course.getCourseTitle();
    this.credits = course.getCredits();
    this.instructor = course.getInstructor();
    this.seats = course.getSeats();
    this.meeting = course.getMeeting();
    this.room = course.getRoom();
    
  }

}

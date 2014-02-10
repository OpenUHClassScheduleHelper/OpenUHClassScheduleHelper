package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Course;

/**
 * Class that stored form data for textbook.
 * @author Owner
 *
 */
public class CourseFormData {

  /** course number. */
  public String courseNumber = "";
  /** course name. */
  public String courseName = "";
  /** course section. */
  public String section = "";
  /** course title. */
  public String courseTitle = "";
  /** course instructor. */
  public String instructor = "";
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
   * @param courseNumber - the course number
   * to do later
   */
  public CourseFormData(String courseNumber, String courseName, String section, String courseTitle, String instructor, 
      String room) {
    
    this.courseNumber = courseNumber;
    this.courseName = courseName;
    this.section = section;
    this.courseTitle = courseTitle;
    this.instructor = instructor;
    this.room = room;
    
  }
  
  /**
   * Constructor form course.
   * @param course - the course.
   */
  public CourseFormData(Course course) {
    this.courseNumber = course.getCourseNumber();    
    this.courseName = course.getCourseName();
    this.section = course.getSection();
    this.courseTitle = course.getCourseTitle();
    this.instructor = course.getInstructor();
    this.room = course.getRoom();
  }
  
}

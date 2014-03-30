package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.CourseFormData;

/**
 * Class that stores a DB of the courses.
 */
public class CourseDB {
  
  private static Map<String, Course> courses = new HashMap<>();
  
  /**
   * Adds new course to the database.
   * @param formData The course data.
   * @return The course.
   */
  public static Course addCourse(CourseFormData formData) {
    String crn = formData.courseNumber;
  
    Course course = new Course(formData.genFocus, formData.courseNumber, formData.courseName, formData.section,
      formData.courseTitle, formData.credits, formData.instructor, formData.seats, formData.meeting, formData.room);
    
    courses.put(crn, course);
    
    return course;
  }
  
  /**
   * Gets the List of courses.
   * @return List of courses.
   */
  public static List<Course> getCourses() {
    return new ArrayList<>(courses.values());
  }
  
  /**
   * Gets a course based on CRN.
   * @param crn the course number.
   * @return The course.
   */
  public static Course getCourse(String crn) {
    Course course = courses.get(crn);

    if (course == null) {
      throw new RuntimeException("Invalid class: " + crn);
    }
    
    return course;
  }
  
 
  
}

package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.CourseFormData;

/**
 * Class that stores a DB of textbooks.
 *
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
  
    Course course = new Course(formData.courseNumber, formData.courseName, formData.section,
      formData.courseTitle, formData.instructor, formData.room);
    
    courses.put(crn, course);
    
    return course;
  }
  
  /**
   * Gets the List of textbooks.
   * 
   * @return List of text books.
   */
  public static List<Course> getCourses() {
    return new ArrayList<>(courses.values());
  }
  
  /**
   * Gets a textbook based on ISBN.
   * @param ISBN the isbn.
   * @return textbook the textbook to return.
   */
  public static Course getCourse(String crn) {
    Course course = courses.get(crn);

    if (course == null) {
      throw new RuntimeException("Invalid class: " + crn);
    }
    
    return course;
  }
  
}

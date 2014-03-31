package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.avaje.ebean.Page;
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
  
  public static List<String> getCourses(String dept) {
    List<String> courseDeptList = new ArrayList<>();
    List<Course> courseList = CourseDB.getCourses();
    for (Course course : courseList) {
      String courseDept = course.getCourseName().split(" ")[0];
      if(courseDept.equals(dept)) {
        courseDeptList.add(course.getCourseTitle() + " (" + course.getCourseName() + ")"); 
      }
    }
    return courseDeptList;
  }
  
  
  public static List<String> getInstructors(String dept) {
    List<String> instructorMap = new ArrayList<>();
    List<Course> courseList = CourseDB.getCourses();
    for (Course course : courseList) {
      String courseDept = course.getCourseName().split(" ")[0];
      String courseInstructor = course.getInstructor();
      if(courseDept.equals(dept) && (! instructorMap.contains(courseInstructor))) {
        instructorMap.add(courseInstructor); 
      }
    }
    return instructorMap;
  }
  
  
  public static List<Course> courseSearchList(String[] days, String[] genFocus, String department, String courseTitleandName, String instructor, String startTime, String endTime) {
    List<Course> courseList = CourseDB.getCourses();
    List<Course> tempCourseList = new ArrayList<>();
    List<Course> finalCourseList = new ArrayList<>();
    if(! department.equals("Any Department")) {
       for(Course course : courseList) {
         String thisDept = course.getCourseName().split(" ")[0];
         if(thisDept.equals(department)) {
           finalCourseList.add(course);
         }
       }
       
       if(! instructor.equals("Any Instructor") && (! instructor.equals(""))) {
         String first = instructor.split(", ")[1];
         String last = instructor.split(", ")[0];
         String instructorNameFirstLast = first + " " + last;
         for(Course course : finalCourseList) {
           if(! instructorNameFirstLast.equals(course.getInstructor())) {
             tempCourseList.add(course);
           }
         }
       }
       
       
       if(! courseTitleandName.equals("Any Course") && (! courseTitleandName.equals(""))) {
         String courseTitleNoCourseName = courseTitleandName.split(" \\(")[0];
         for(Course course : finalCourseList) {
           if(! courseTitleNoCourseName.equals(course.getCourseTitle())) {
             tempCourseList.add(course);
           }
         }
       }
       
       for(Course course : tempCourseList) {
         finalCourseList.remove(course);
       }
       
    }
    
    return finalCourseList;
    
  }
  
 
  
}

package views.formdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Course;
import models.CourseDB;

/**
 * List of all departments.
 * @author Evan Komiyama
 *
 */
public class Departments {


  public static Map<String, Boolean> getDepartments() {
    Map<String, Boolean> deptMap = new HashMap<>();
    List<Course> courseList = CourseDB.getCourses();
    for (Course course : courseList) {
      String courseDept = course.getCourseName().split(" ")[0];
      if(! deptMap.containsKey(courseDept)) {
        deptMap.put(courseDept, false); 
      }
    }
    return deptMap;
    
  }
}
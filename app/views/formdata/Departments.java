package views.formdata;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import models.CourseDB;

/**
 * List of all departments.
 * @author Evan Komiyama
 *
 */
public class Departments {


  public static Map<String, Boolean> getDepartments() {
    // A TreeMap imposes a sorted order of key values.
    TreeMap<String, Boolean> deptMap = new TreeMap<String, Boolean>();
    List<String> deptList = CourseDB.getDepartmentList();
    for (String dept : deptList) {
      deptMap.put(dept, false);
    }
    return deptMap;
    
  }
}
package models;

import java.util.List;
import views.formdata.SearchForm;
import com.avaje.ebean.PagingList;

/**
 * Provides the search function as well as stores the results for pagination.
 * @author Rob Namahoe
 */
public class CourseSearch {
  
  private static String paramDept = "";
  private static String paramInstructor = "";
  private static String paramCourse = "";
  
  private static final int PAGINATION_MAX = 5; // Allow a maximum of 5 results per page.
  private static PagingList<Course> pages;
  
  /**
   * Query the database for surfers matching the search criteria.
   * @param data The search criteria.
   */
  public static void queryDatabase(SearchForm data) {

    String dept = data.department;
    String instructor = data.instructor;
    String courseTitle = data.course;
  
    setParamDept(dept);
    setParamInstructor(instructor);
    setParamCourse(courseTitle);
    
    // Manipulate dept String to a queryable format.
    if (dept.equalsIgnoreCase("Any Department")) {
      dept = ""; 
    } 
    else {
      if (dept.indexOf(":") > 0) { // This is needed to account for TBA entries
        dept = dept.substring(0, dept.indexOf(":")).trim(); // parse out dept abbreviation
      }
    }
    
    // Manipulate instructor string to a queryable format.
    if (instructor.equalsIgnoreCase("Any Instructor")) {
      instructor = "";
    } 
    else {
      if (instructor.indexOf(",") > 0) { // This is needed to account for TBA entries
        String name[] = instructor.split(",");
        instructor = name[1].trim() + " " + name[0].trim(); // [first initial] [last name]
      }
    }
    
    // Manipulate course
    if (courseTitle.equalsIgnoreCase("Any Course")) {
      courseTitle = "";
    }
    
    // Perform search
    if (!dept.equals("")) {
      if (!instructor.equals("")) {
        if (!courseTitle.equals("")) {
          pages = Course.find().where().eq("department", dept)
                                       .eq("instructor", instructor)
                                       .eq("courseTitle", courseTitle).findPagingList(PAGINATION_MAX);
        }
        else {
          pages = Course.find().where().eq("department", dept)
                                       .eq("instructor", instructor).findPagingList(PAGINATION_MAX);
        }
      }
      else {
        pages = Course.find().where().eq("department", dept).findPagingList(PAGINATION_MAX);
      }
    }
  }

  /**
   * @param results The pages to set
   */
  public static void setPages(PagingList<Course> results) {
    pages = results;
  }
  
  /**
   * Get the specified results page.
   * @param page The page to retrieve.
   * @return The specified results page.
   */
  public static List<Course> getResultsByPage(int page) {
    return pages.getPage(page).getList();
  }
  
  /**
   * Get the total number of pages of results.
   * @return The number of result pages.
   */
  public static int getPageCount() {
    if (pages == null){
      return 0;
    }
    return pages.getTotalPageCount();
  }
  
  /**
   * Get the total number of results (courses).
   * @return The number of results.
   */
  public static int getResultsCount() {
    if (pages == null) {
      return 0;
    }
    return pages.getTotalRowCount();
  }

  /**
   * @return the paramDept
   */
  public static String getParamDept() {
    return paramDept;
  }

  /**
   * @param paramDept the paramDept to set
   */
  public static void setParamDept(String paramDept) {
    CourseSearch.paramDept = paramDept;
  }

  /**
   * @return the paramInstructor
   */
  public static String getParamInstructor() {
    return paramInstructor;
  }

  /**
   * @param paramInstructor the paramInstructor to set
   */
  public static void setParamInstructor(String paramInstructor) {
    CourseSearch.paramInstructor = paramInstructor;
  }

  /**
   * @return the paramCourse
   */
  public static String getParamCourse() {
    return paramCourse;
  }

  /**
   * @param paramCourse the paramCourse to set
   */
  public static void setParamCourse(String paramCourse) {
    CourseSearch.paramCourse = paramCourse;
  }

}

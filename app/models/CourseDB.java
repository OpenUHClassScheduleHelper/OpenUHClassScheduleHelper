package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.PagingList;
import com.avaje.ebean.Query;
import controllers.JauntCourseItem;


/**
 * Class that stores a DB of the courses.
 */
public class CourseDB {
  
  private static final int PAGINATION_MAX = 5;
  private static PagingList<Course> pages;
  
  /**
   * Add a course to the database of courses.
   * @param focus The General focus attributes, if applicable.
   * @param crn The crn of the course.
   * @param name The name of the course, i.e. 'ICS 311'.
   * @param section The section of the course.
   * @param title The title of the course, i.e. 'Algorithms'.
   * @param credits The number of credits.
   * @param instructor The instructor.
   * @param semester The current semester.
   */
  public static void addCourse(Course newCourse) {
    
    Course course = getCourseByCrn(newCourse.getCrn());
    
    // If the course is already in the database, then update the fields.
    if (course != null) {
      course.setGenFocus(newCourse.getGenFocus());
      course.setCourseNumber(newCourse.getCourseNumber());
      course.setCourseName(newCourse.getCourseName());
      course.setSection(newCourse.getSection());
      course.setCourseTitle(newCourse.getCourseTitle());
      course.setCredits(newCourse.getCredits());
      course.setInstructor(newCourse.getInstructor());  
      course.setSemester(newCourse.getSemester());
      course.save();
    }
    else {
      newCourse.save();
    }
  }

  /**
   * Get the course by the crn.
   * @param crn The crn.
   * @return The course with the specified crn.
   */
  public static Course getCourseByCrn(String crn) {
    return Course.find().where().eq("crn", crn).findUnique();
  }
  
  /**
   * Gets the List of courses.
   * @return List of courses.
   */
  public static List<Course> getCourses() {
    return Course.find().all();
  }
  
  /**
   * Gets a course based on CRN.
   * @param crn The course number.
   * @return The course.
   */
  public static Course getCourse(String crn) {
    return Course.find().where().eq("crn", crn).findUnique();
  }
  
  /**
   * Get a list of courses by department.
   * @param dept The department.
   * @return A list of courses offered by the specified department.
   */
  public static List<Course> getCoursesByDept(String dept) {
    return Course.find().where().eq("department", dept).findList();
  }
  
  /**
   * Get a list of courses in a specified department formatted for the Search Form.
   * @param dept The department of interest.
   * @return A list of courses offered by department formatted for the Search Form.
   */
  public static List<String> getCourses(String dept) {
    List<String> results = new ArrayList<>();
    HashSet<String> hs = new HashSet<String>();
    // Add courses to a hash set to remove duplicates.
    for (Course course : getCoursesByDept(dept)) {
      hs.add(course.getCourseName() + ": " + course.getCourseTitle());
    }
    results.addAll(hs);
    // Sort with a custom comparator.
    Collections.sort(results, new CourseComparator());
    return results;
  }
  
  /**
   * Get a list of instructors in a department.
   * @param dept The department of interest.
   * @return A list of instructors from a specified department.
   */
  public static List<String> getInstructors(String dept) {
    List<String> results = new ArrayList<String>();
    HashSet<String> hs = new HashSet<String>();
    // Add instructor names to a hash set to remove duplicates.
    for (Course course : Course.find().where().eq("department", dept).findList()) {
      hs.add(course.getInstructor());
    }
    results.addAll(hs);
    // Sort the results list with a custom comparator that will product a list
    // sorted by last name.
    Collections.sort(results, new InstructorComparator());
    return results;
  }
  
  /**
   * A custom comparator to sort instructor names (i.e. H Casanova) by last name.
   * @author Rob Namahoe
   */
  static class InstructorComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
      return s1.substring(2, 3).compareTo(s2.substring(2,3));
    }
  } 

  /**
   * A custom comparator to sort course names/title by course number.
   * @author Rob Namahoe
   */
  static class CourseComparator implements Comparator<String> {
    public int compare(String str1, String str2) {
      String s1 = str1.substring(str1.indexOf(" ") + 1, str1.indexOf(" ") + 4).trim();
      String s2 = str2.substring(str2.indexOf(" ") + 1, str2.indexOf(" ") + 4).trim();
      return s1.compareTo(s2);
    }
  } 
  
  public static void page(String[] days, String[] genFocus, String department, String courseTitleandName, String instructor, String startTime, String endTime) {
    boolean noQueryCheck = true;
    int daycheck = 0;
    int focuscheck = 0;
    Query<Course> query = Ebean.createQuery(Course.class);
    CourseDB.setPages(pages);
    
    if(! department.equals("")) {
      noQueryCheck = false;
      query.where().eq("department", department);
    }
    
    if(! instructor.equals("Any Instructor") && ! instructor.equals("")) {
      noQueryCheck = false;
      String comparableInstName = instructor.split(", ")[1] + " " + instructor.split(", ")[0];
      query.where().eq("instructor", comparableInstName);
    }
    
    if(! courseTitleandName.equals("Any Course") && ! courseTitleandName.equals("")) {
      noQueryCheck = false;
      String comparableCourseName = "";
      if(courseTitleandName.split(": ").length > 2) {
        comparableCourseName = courseTitleandName.split(": ")[1] + ": " + courseTitleandName.split(": ")[2];
      }else {
        comparableCourseName = courseTitleandName.split(": ")[1];
      }
      query.where().eq("courseTitle", comparableCourseName);
    }
    
    if(days != null) {
    for(String day : days) {
      if(day == null) {
        daycheck++;
      }
    }
    }
    
    if(genFocus != null) {
      for(String focus : genFocus) {
        if(focus == null) {
          focuscheck++;
        }
      }
    }
    
    if(genFocus != null && genFocus.length > 0 && focuscheck != 4) {
      noQueryCheck = false;
      for(String focus : genFocus) {
        if(focus != null) {
          if(focus.equals("ETH")) {
            query.where().contains("genFocus", "ETH");
          }
          if(focus.equals("WI")) {
            query.where().contains("genFocus", "WI");
          }
          if(focus.equals("OC")) {
            query.where().contains("genFocus", "OC");
          }
          if(focus.equals("HAP")) {
            query.where().contains("genFocus", "HAP");
          }
        }
      }
      }
    
    
    /*if(days != null && days.length > 0 && daycheck != 4) {
      noQueryCheck = false;
      if(! department.equals("") || focuscheck != 4) {
        queryString += "and ";
      }
      int index = 0;
      for(String day : days) {
        if(day != null) {
          index++;
          if(index > 1) {
          queryString += "and ";
          }
          if(day.equals("M")) {
            queryString += "genFocus like :m ";
          }
          if(day.equals("T")) {
            queryString += "genFocus like :t ";
          }
          if(day.equals("W")) {
            queryString += "genFocus like :w ";
          }
          if(day.equals("R")) {
            queryString += "genFocus like :r ";
          }
          if(day.equals("F")) {
            queryString += "genFocus like :f ";
          }
          if(day.equals("Sa")) {
            queryString += "genFocus like :sa ";
          }
          if(day.equals("Su")) {
            queryString += "genFocus like :su ";
          }
        }
      }
    }*/
    
    if(noQueryCheck) {
      query.findList();
    }
    
     pages = query.findPagingList(PAGINATION_MAX);
     CourseDB.setPages(pages);
    
  }
  
  
  /*public static void page(String[] days, String[] genFocus, String department, String courseTitleandName, String instructor, String startTime, String endTime) {
    String queryString = "find course where ";
    boolean noQueryCheck = true;
    int daycheck = 0;
    int focuscheck = 0;
    if(! department.equals("")) {
      noQueryCheck = false;
      queryString += "department = :dept ";
    }
    
    if(! instructor.equals("Any Instructor") && ! instructor.equals("")) {
      noQueryCheck = false;
      queryString += "and instructor = :inst ";
    }
    
    if(! courseTitleandName.equals("Any Course") && ! courseTitleandName.equals("")) {
      noQueryCheck = false;
      queryString += "and courseTitle = :title ";
    }
    
    if(days != null) {
    for(String day : days) {
      if(day == null) {
        daycheck++;
      }
    }
    }
    
    if(genFocus != null) {
      for(String focus : genFocus) {
        if(focus == null) {
          focuscheck++;
        }
      }
    }
    
    if(genFocus != null && genFocus.length > 0 && focuscheck != 4) {
      noQueryCheck = false;
      if(! department.equals("")) {
        queryString += "and ";
      }
      int index = 0;
      for(String focus : genFocus) {
        if(focus != null) {
          index++;
          if(index > 1) {
          queryString += "OR ";
          }
          if(focus.equals("ETH")) {
            //queryString += "genFocus like :eth ";
            queryString += "FIND_IN_SET(:eth, genFocus) > 0 ";
          }
          if(focus.equals("WI")) {
            queryString += "FIND_IN_SET(:wi, genFocus) > 0 ";
          }
          if(focus.equals("OC")) {
            queryString += "FIND_IN_SET(:oc, genFocus) > 0 ";
          }
          if(focus.equals("HAP")) {
            queryString += "FIND_IN_SET(:hap, genFocus) > 0 ";
          }
        }
      }
    }
    
    
    /*if(days != null && days.length > 0 && daycheck != 4) {
      noQueryCheck = false;
      if(! department.equals("") || focuscheck != 4) {
        queryString += "and ";
      }
      int index = 0;
      for(String day : days) {
        if(day != null) {
          index++;
          if(index > 1) {
          queryString += "and ";
          }
          if(day.equals("M")) {
            queryString += "genFocus like :m ";
          }
          if(day.equals("T")) {
            queryString += "genFocus like :t ";
          }
          if(day.equals("W")) {
            queryString += "genFocus like :w ";
          }
          if(day.equals("R")) {
            queryString += "genFocus like :r ";
          }
          if(day.equals("F")) {
            queryString += "genFocus like :f ";
          }
          if(day.equals("Sa")) {
            queryString += "genFocus like :sa ";
          }
          if(day.equals("Su")) {
            queryString += "genFocus like :su ";
          }
        }
      }
    }
    
    if(noQueryCheck) {
      queryString = "find course *";
    }
    
    
    
    Query<Course> query = Ebean.createQuery(Course.class, queryString);  
    if(! department.equals("")) {
    query.setParameter("dept", department);
    query.setParameter("w", "W");
    }
    
    if(! instructor.equals("Any Instructor") && ! instructor.equals("")) {
    String comparableInstName = instructor.split(", ")[1] + " " + instructor.split(", ")[0];
    query.setParameter("inst", comparableInstName);
    }
    
    if(! courseTitleandName.equals("Any Course") && ! courseTitleandName.equals("")) {
      String comparableCourseName = "";
      if(courseTitleandName.split(": ").length > 2) {
        comparableCourseName = courseTitleandName.split(": ")[1] + ": " + courseTitleandName.split(": ")[2];
      }else {
        comparableCourseName = courseTitleandName.split(": ")[1];
      }
    query.setParameter("title", comparableCourseName);
    }
   
    if(genFocus != null && genFocus.length > 0 && focuscheck != 4) {
      for(String focus : genFocus) {
        if(focus != null) {
          if(focus.equals("ETH")) {
            query.setParameter("eth", "ETH");
          }
          if(focus.equals("WI")) {
            query.setParameter("wi", "WI");
          }
          if(focus.equals("OC")) {
            query.setParameter("oc", "OC");
          }
          if(focus.equals("HAP")) {
            query.setParameter("hap", "HAP");
          }
        }
      }
    }
    
    pages = query.findPagingList(PAGINATION_MAX);
    CourseDB.setPages(pages);
  }*/
  
  
  public static List<Course> courseSearchList(String[] days, String[] genFocus, String department, String courseTitleandName, String instructor, String startTime, String endTime) {
    String queryString = "find course where ";
    boolean noQueryCheck = true;
    int daycheck = 0;
    int focuscheck = 0;
    if(! department.equals("")) {
      noQueryCheck = false;
      queryString += "department = :dept ";
    }
    
    if(! instructor.equals("Any Instructor") && ! instructor.equals("")) {
      noQueryCheck = false;
      queryString += "and instructor = :inst ";
    }
    
    if(! courseTitleandName.equals("Any Course") && ! courseTitleandName.equals("")) {
      noQueryCheck = false;
      queryString += "and courseTitle = :title ";
    }
    
    if(days != null) {
    for(String day : days) {
      if(day == null) {
        daycheck++;
      }
    }
    }
    
    if(genFocus != null) {
      for(String focus : genFocus) {
        if(focus == null) {
          focuscheck++;
        }
      }
    }
    
    if(genFocus != null && genFocus.length > 0 && focuscheck != 4) {
      noQueryCheck = false;
      if(! department.equals("")) {
        queryString += "and ";
      }
      int index = 0;
      for(String focus : genFocus) {
        if(focus != null) {
          index++;
          if(index > 1) {
          queryString += "OR ";
          }
          if(focus.equals("ETH")) {
            //queryString += "genFocus like :eth ";
            queryString += "FIND_IN_SET(:eth, genFocus) > 0 ";
          }
          if(focus.equals("WI")) {
            queryString += "FIND_IN_SET(:wi, genFocus) > 0 ";
          }
          if(focus.equals("OC")) {
            queryString += "FIND_IN_SET(:oc, genFocus) > 0 ";
          }
          if(focus.equals("HAP")) {
            queryString += "FIND_IN_SET(:hap, genFocus) > 0 ";
          }
        }
      }
    }
    
    
    /*if(days != null && days.length > 0 && daycheck != 4) {
      noQueryCheck = false;
      if(! department.equals("") || focuscheck != 4) {
        queryString += "and ";
      }
      int index = 0;
      for(String day : days) {
        if(day != null) {
          index++;
          if(index > 1) {
          queryString += "and ";
          }
          if(day.equals("M")) {
            queryString += "genFocus like :m ";
          }
          if(day.equals("T")) {
            queryString += "genFocus like :t ";
          }
          if(day.equals("W")) {
            queryString += "genFocus like :w ";
          }
          if(day.equals("R")) {
            queryString += "genFocus like :r ";
          }
          if(day.equals("F")) {
            queryString += "genFocus like :f ";
          }
          if(day.equals("Sa")) {
            queryString += "genFocus like :sa ";
          }
          if(day.equals("Su")) {
            queryString += "genFocus like :su ";
          }
        }
      }
    }*/
    
    if(noQueryCheck) {
      queryString = "find course *";
    }
    
    
    
    Query<Course> query = Ebean.createQuery(Course.class, queryString);  
    if(! department.equals("")) {
    query.setParameter("dept", department);
    query.setParameter("w", "W");
    }
    
    if(! instructor.equals("Any Instructor") && ! instructor.equals("")) {
    String comparableInstName = instructor.split(", ")[1] + " " + instructor.split(", ")[0];
    query.setParameter("inst", comparableInstName);
    }
    
    if(! courseTitleandName.equals("Any Course") && ! courseTitleandName.equals("")) {
      String comparableCourseName = "";
      if(courseTitleandName.split(": ").length > 2) {
        comparableCourseName = courseTitleandName.split(": ")[1] + ": " + courseTitleandName.split(": ")[2];
      }else {
        comparableCourseName = courseTitleandName.split(": ")[1];
      }
    query.setParameter("title", comparableCourseName);
    }
   
    if(genFocus != null && genFocus.length > 0 && focuscheck != 4) {
      for(String focus : genFocus) {
        if(focus != null) {
          if(focus.equals("ETH")) {
            query.setParameter("eth", "ETH");
          }
          if(focus.equals("WI")) {
            query.setParameter("wi", "WI");
          }
          if(focus.equals("OC")) {
            query.setParameter("oc", "OC");
          }
          if(focus.equals("HAP")) {
            query.setParameter("hap", "HAP");
          }
        }
      }
    }
    
    List<Course> courseList = query.findList();
    
    return courseList;
    /*
    List<Course> courseList = CourseDB.getCourses();
    List<Course> tempCourseList = new ArrayList<>();
    List<Course> finalCourseList = new ArrayList<>();
    boolean passed = false;
    if(! department.equals("")) {
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
       
    }else {
      finalCourseList = courseList;
    }
    
    
    tempCourseList = new ArrayList<>();
    int failed = 0;
    int daycheck = 0;
    int focuscheck = 0;
    
    if(days != null) {
    for(String day : days) {
      if(day == null) {
        daycheck++;
      }
    }
    }
    
    if(genFocus != null) {
      for(String focus : genFocus) {
        if(focus == null) {
          focuscheck++;
        }
      }
    }
    
    if(daycheck != 7) {
      for(Course course : finalCourseList) {
        passed = false;
        for(String day : days) {
          for(int i = 0; i < course.getMeeting().size(); i++) {
             if(day != null && day.equals(course.getMeeting().get(i).getDay())) {
               passed = true;
               i = course.getMeeting().size();
             }
          }
        }
        if(! passed) {
          if(! tempCourseList.contains(course)) {
            tempCourseList.add(course);
            }
        }
      }
      
    }
    
    
    if(focuscheck != 4) {
      for(Course course : finalCourseList) {
        passed = false;
        for(String focus : genFocus) {
          if(course.getGenFocus() != null) {
          for(int i = 0; i < course.getGenFocus().size(); i++) {
             if(focus != null && focus.equals(course.getGenFocus().get(i))) {
               passed = true;
               i = course.getGenFocus().size();
             }
          }
          }
        }
        if(! passed) {
           if(! tempCourseList.contains(course)) {
           tempCourseList.add(course);
           }
        }
      }
      
    }
    
    /*if(days != null && daycheck != 7) {
      for(Course course : finalCourseList) {
        passed = true;
        failed = 0;
        for(String day : days) {
          for(int i = 0; i < course.getMeeting().size(); i++) {
            if(day != null && ! day.equals(course.getMeeting().get(i).getDay())) {
              failed++;
            }
          }
          if(failed == course.getMeeting().size()-1) {
            passed = false;
          }
        }
        if(! passed && (finalCourseList.contains(course))) {
           tempCourseList.add(course);
        }
      }
      
    }
    
    for(Course course : tempCourseList) {
      finalCourseList.remove(course);
    }
    
    return finalCourseList;
    */
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
    public static List<Course> getCoursesInPage(int page) {
      return pages.getPage(page).getList();
    }
    
    /**
  * Get the total number of pages of results.
  * @return The number of result pages.
  */
    public static int getPageCount() {
      return pages.getTotalPageCount();
    }
    
    /**
  * Get the total number of results (surfers).
  * @return The number of surfers.
  */
    public static int getCourseCount() {
      return pages.getTotalRowCount();
    }
  
 
  
}

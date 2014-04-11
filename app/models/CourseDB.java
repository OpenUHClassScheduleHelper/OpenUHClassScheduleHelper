package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


/**
 * Class that stores a DB of the courses.
 */
public class CourseDB {
  
  
  /**
   * Add a course to the database of courses.
   * @param focus The General focus attributes, if applicable.
   * @param crn The crn of the course.
   * @param name The name of the course, i.e. 'ICS 311'.
   * @param section The section of the course.
   * @param title The title of the course, i.e. 'Algorithms'.
   * @param credits The number of credits.
   * @param instructor The instructor.
   */
  public static void addCourse(String focus, String crn, String name, String section, 
                               String title, String credits, String instructor) {
    
    Course course = getCourseByCrn(crn);
    
    // If the course is not in the database, then create a new entry
    if (course == null) {
      course = new Course(focus, crn, name, section, title, credits, instructor);
    }
    else {
    // The course already exists in the database, so update the fields.
      course.setGenFocus(focus);
      course.setCourseName(name);
      course.setSection(section);
      course.setCourseTitle(title);
      course.setCredits(credits);
      course.setInstructor(instructor);
    }
    course.save();
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
  
  public static List<Course> courseSearchList(String[] days, String[] genFocus, String department, String courseTitleandName, String instructor, String startTime, String endTime) {
    return getCourses();
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
  
 
  
}

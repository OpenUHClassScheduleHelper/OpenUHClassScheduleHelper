package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.SearchForm;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.PagingList;
import com.avaje.ebean.Query;

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
  /*public static void queryDatabase(SearchForm data) {

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
  }*/
  
  public static void page(String[] days, String[] genFocus, String department, String courseTitleandName, String instructor, String startTime, String endTime) {
    setParamDept(department);
    setParamInstructor(instructor);
    setParamCourse(courseTitleandName);
    int index = 0;
    int daycheck = 0;
    int focuscheck = 0;
    Query<Course> query = Ebean.createQuery(Course.class);
    Query<Course> secondQuery = null;
    Query<Course> finalQuery = null;
    String secondQueryString = "find course where ";
    String finalQueryString = "find course where ";
    //pages = null;
    //CourseDB.setPages(pages);
    
    if(! department.equals("")) {
      query.where().eq("department", department);
    }
    
    if(! instructor.equals("Any Instructor") && ! instructor.equals("")) {
      String comparableInstName = instructor.split(", ")[1] + " " + instructor.split(", ")[0];
      query.where().eq("instructor", comparableInstName);
    }
    
    if(! courseTitleandName.equals("Any Course") && ! courseTitleandName.equals("")) {
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
    
    
    List<String> crnList = new ArrayList<>();
    if(days != null && days.length > 0 && daycheck != 7) {
      secondQuery = Ebean.createQuery(Course.class);
      List<Course> courseList = query.findList();
      for(String day : days) {
        if(day != null) {
          if(day.equals("M")) {
            for(Course course : courseList) {
              for(Meeting meeting: course.getMeeting()) {
                if(meeting.getDay().contains("M")) {
                  if(! crnList.contains(course.getCrn())) {
                    crnList.add(course.getCrn());
                  }
                }
              }
            }
            
          }
          if(day.equals("T")) {
            for(Course course : courseList) {
              for(Meeting meeting: course.getMeeting()) {
                if(meeting.getDay().contains("T")) {
                  if(! crnList.contains(course.getCrn())) {
                    crnList.add(course.getCrn());
                  }
                }
              }
            }
          }
          if(day.equals("W")) {
            for(Course course : courseList) {
              for(Meeting meeting: course.getMeeting()) {
                if(meeting.getDay().contains("W")) {
                  if(! crnList.contains(course.getCrn())) {
                    crnList.add(course.getCrn());
                  }
                }
              }
            }
          }
          if(day.equals("R")) {
            for(Course course : courseList) {
              for(Meeting meeting: course.getMeeting()) {
                if(meeting.getDay().contains("R")) {
                  if(! crnList.contains(course.getCrn())) {
                    crnList.add(course.getCrn());
                  }
                }
              }
            }
          }
          if(day.equals("F")) {
            for(Course course : courseList) {
              for(Meeting meeting: course.getMeeting()) {
                if(meeting.getDay().contains("F")) {
                  if(! crnList.contains(course.getCrn())) {
                    crnList.add(course.getCrn());
                  }
                }
              }
            }
          }
          if(day.equals("Sa")) {
            for(Course course : courseList) {
              for(Meeting meeting: course.getMeeting()) {
                if(meeting.getDay().contains("S")) {
                  if(! crnList.contains(course.getCrn())) {
                    crnList.add(course.getCrn());
                  }
                }
              }
            }
          }
          if(day.equals("Su")) {
            for(Course course : courseList) {
              for(Meeting meeting: course.getMeeting()) {
                if(meeting.getDay().contains("U")) {
                  if(! crnList.contains(course.getCrn())) {
                    crnList.add(course.getCrn());
                  }
                }
              }
            }
          }
        }
      }  
      for(String crn : crnList) {
        String indexParameter = ":crn" + index;
        if(index < crnList.size()-1) {
          secondQueryString += "crn = " + indexParameter + " OR ";
        }else {
          secondQueryString += "crn = " + indexParameter;
        }
        index++;
      }
      secondQuery = Ebean.createQuery(Course.class, secondQueryString);
      index = 0;
      for(String crn : crnList) {
        String indexParameter = "crn" + index;
        index++;
        secondQuery.setParameter(indexParameter, crn);
      }
    }
    
    
    List<Course> initialCourseList = new ArrayList<>();
    List<String> finalCrnList = new ArrayList<>();
    if(secondQuery == null) {
      initialCourseList = query.findList();
    }else {
      initialCourseList = secondQuery.findList();
    }
    
    //================================================================================================================
    if(startTime.equals("") || endTime.equals("")) {
      //Use crnList as finalCrnList
      finalCrnList = crnList;
    }else {
    String start = startTime.split(" ")[0].replace(":", "");
    String startAbbreviation =  startTime.split(" ")[1];
    String end = endTime.split(" ")[0].replace(":", "");
    String endAbbreviation =  endTime.split(" ")[1];
    System.out.println(start.substring(1,2));
    for(Course course : initialCourseList) {
      boolean allDaysAvailable = true;
      List<Meeting> meetingList = course.getMeeting();
      for(int i =0; i < meetingList.size(); i++) {
        String startMeeting = meetingList.get(i).getStart().substring(0, meetingList.get(i).getStart().length()-2);
        String startAbbreviationMeeting =  meetingList.get(i).getStart().charAt(meetingList.get(i).getStart().length()-1) + "";
        String endMeeting = meetingList.get(i).getStart().substring(0, meetingList.get(i).getEnd().length()-1);
        String endAbbreviationMeeting =  meetingList.get(i).getStart().charAt(meetingList.get(i).getStart().length()-1) + "";
        if(startAbbreviation.equals("AM") && startAbbreviationMeeting.equals("a")) {
          if(start.length() == 3) {
            start = "0" + start; 
          }
          if(start.compareTo(startMeeting) <= 0) {
          //Do nothing: meeting start time is fine
          }else {
            allDaysAvailable = false;
          }
        }else if (startAbbreviation.equals("AM") && startAbbreviationMeeting.equals("p")) {
          //Do nothing: meeting start time is fine
        }else if (startAbbreviation.equals("PM") && startAbbreviationMeeting.equals("a")) {
          allDaysAvailable = false;
        }else if (startAbbreviation.equals("PM") && startAbbreviationMeeting.equals("p")) {
          if(start.substring(1,2).equals("12")) {
            start = "00" + start.substring(3,4);
          }else {
            if(start.length() == 3) {
            start = "0" + start;
            }
          }
          if(startMeeting.substring(1,2).equals("12")) {
            startMeeting = "00"+ start.substring(3,4);
          }
          
          if(start.compareTo(startMeeting) <= 0) {
            //Do nothing: meeting start time is fine
            }else {
              allDaysAvailable = false;
            }
        }
        
        
        if(endAbbreviation.equals("AM") && endAbbreviationMeeting.equals("a")) {
          if(end.length() == 3) {
            end = "0" + end;
          }
          if(end.compareTo(endMeeting) <= 0) {
            //Do nothing: meeting start time is fine
            }else {
              allDaysAvailable = false;
            }
        }else if (endAbbreviation.equals("AM") && endAbbreviationMeeting.equals("p")) {
          allDaysAvailable = false;
        }else if (endAbbreviation.equals("PM") && endAbbreviationMeeting.equals("a")) {
        //Do nothing: meeting end time is fine
        }else if (endAbbreviation.equals("PM") && endAbbreviationMeeting.equals("p")) {
          if(end.substring(1,2).equals("12")) {
            end = "00"+ start.substring(3,4);
          }else {
            if(end.length() == 3) {
              end = "0" + start;
              }
          }
          if(endMeeting.substring(1,2).equals("12")) {
            endMeeting = "00"+ start.substring(3,4);
          }
          if(end.compareTo(endMeeting) <= 0) {
            //Do nothing: meeting start time is fine
            }else {
              allDaysAvailable = false;
            }
        }
        
        
      }
      if(allDaysAvailable) {
        finalCrnList.add(course.getCrn());
      }
    }
    }
    
    //================================================================================================================

    index = 0;
    for(String crn : finalCrnList) {
      String indexParameter = ":crn" + index;
      if(index < finalCrnList.size()-1) {
        finalQueryString += "crn = " + indexParameter + " OR ";
      }else {
        finalQueryString += "crn = " + indexParameter;
      }
      index++;
    }
    
    if(finalQueryString.equals("find course where ")) {
      finalQueryString = "find course *";  
    }
    
    finalQuery = Ebean.createQuery(Course.class, finalQueryString);
    index = 0;
    for(String crn : finalCrnList) {
      String indexParameter = "crn" + index;
      index++;
      finalQuery.setParameter(indexParameter, crn);
    }
    

     pages = finalQuery.findPagingList(PAGINATION_MAX);
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

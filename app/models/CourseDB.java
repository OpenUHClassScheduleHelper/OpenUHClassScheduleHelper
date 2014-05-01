package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.FetchConfig;
import com.avaje.ebean.PagingList;
import com.avaje.ebean.Query;

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
    
    Course course = Course.find().where().eq("crn", newCourse.getCrn()).findUnique();
    
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
   * Gets the List of courses.
   * @return List of courses.
   */
  public static List<Course> getCourses() {
    return Course.find().all();
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
  private static class InstructorComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
      return s1.substring(2, 3).compareTo(s2.substring(2,3));
    }
  } 

  /**
   * A custom comparator to sort course names/title by course number.
   * @author Rob Namahoe
   */
  private static class CourseComparator implements Comparator<String> {
    public int compare(String str1, String str2) {
      String s1 = str1.substring(str1.indexOf(" ") + 1, str1.indexOf(" ") + 4).trim();
      String s2 = str2.substring(str2.indexOf(" ") + 1, str2.indexOf(" ") + 4).trim();
      return s1.compareTo(s2);
    }
  } 
  
  /**
   * Get a list of all departments in the following format, abbreviation: full name.
   * @return A list of departments.
   */
  public static List<String> getDepartmentList() {
    Map<String, String> deptMap = getDeptMap();
    HashSet<String> hs = new HashSet<String>();
    List<String> deptList = new ArrayList<String>();
    List<Course> courses = Course.find().select("department").findList();
    // Add departments to a hashset to remove duplicate values.
    for (Course course : courses) {
      hs.add(course.getDepartment());
    }
    for (String dept : hs) {
      String deptEntry = dept + ": Unknown";
      if (deptMap.containsKey(dept)) {
        deptEntry = deptMap.get(dept);
      }
      deptList.add(deptEntry);
    }
    Collections.sort(deptList);
    return deptList;
  }
  
  /**
   * Get the department entry for the Department select element of the Search Form.
   * @return A map of departments in the format: Abbreviation: FullName.
   */
  private static Map<String, String> getDeptMap() {
    Map<String, String> deptMap = new HashMap<String, String>();
    deptMap.put("ACM", "ACM: Academy for Creative Media");
    deptMap.put("ACC", "ACC: Accounting");
    deptMap.put("AS", "AS: Aerospace Studies");
    deptMap.put("AMST", "AMST: American Studies");
    deptMap.put("ANAT", "ANAT: Anatomy");
    deptMap.put("ANSC", "ANSC: Animal Science");
    deptMap.put("ANTH", "ANTH: Anthropology");
    deptMap.put("ARAB", "ARAB: Arabic");
    deptMap.put("ARCH", "ARCH: Architecture");
    deptMap.put("ART", "ART: Art");
    deptMap.put("ASAN", "ASAN: Asian Studies");
    deptMap.put("ASTR", "ASTR: Astronomy");
    deptMap.put("BIOC", "BIOC: Biochemistry");
    deptMap.put("BE", "BE: Bioengineering");
    deptMap.put("BIOL", "BIOL: Biology");
    deptMap.put("BIOM", "BIOM: Biomedical Science");
    deptMap.put("BOT", "BOT: Botany");
    deptMap.put("BUS", "BUS: Business");
    deptMap.put("BLAW", "BLAW: Business Law");
    deptMap.put("CAM", "CAM: Cambodian");
    deptMap.put("CMB", "CMB: Cell and Molecular Biology");
    deptMap.put("CHAM", "CHAM: Chamorro");
    deptMap.put("CHEM", "CHEM: Chemistry");
    deptMap.put("CHN", "CHN: Chinese Language & Literature");
    deptMap.put("CEE", "CEE: Civil & Environmental Engr");
    deptMap.put("COM", "COM: Communication");
    deptMap.put("CIS", "CIS: Communication & Info Sciences");
    deptMap.put("CSD", "CSD: Communication Sci & Disorders");
    deptMap.put("COMG", "COMG: Communicology");
    deptMap.put("EDCS", "EDCS: Curriculum Studies");
    deptMap.put("DNCE", "DNCE: Dance");
    deptMap.put("DH", "DH: Dental Hygiene");
    deptMap.put("DRB", "DRB: Developmental & Repro Biology");
    deptMap.put("DIS", "DIS: Disability Studies");
    deptMap.put("EALL", "EALL: East Asian Languages & Lit");
    deptMap.put("ECON", "ECON: Economics");
    deptMap.put("EDEA", "EDEA: Educational Administration");
    deptMap.put("EDEF", "EDEF: Educational Foundations");
    deptMap.put("EDEP", "EDEP: Educational Psychology");
    deptMap.put("ETEC", "ETEC: Educational Technology");
    deptMap.put("EE", "EE: Electrical Engineering");
    deptMap.put("ENGR", "ENGR: Engineering, Interdisciplinary");
    deptMap.put("ENG", "ENG: English");
    deptMap.put("ESL", "ESL: English as a Second Language");
    deptMap.put("ELI", "ELI: English Language Institute");
    deptMap.put("ES", "ES: Ethnic Studies");
    deptMap.put("FMCH", "FMCH: Family Medicine & Comm Health");
    deptMap.put("FAMR", "FAMR: Family Resources");
    deptMap.put("FDM", "FDM: Fashion Design Textiles & Mdsg");
    deptMap.put("FIL", "FIL: Filipino");
    deptMap.put("FIN", "FIN: Finance");
    deptMap.put("FSHN", "FSHN: Food Science & Human Nutrition");
    deptMap.put("FR", "FR: French");
    deptMap.put("GEOG", "GEOG: Geography");
    deptMap.put("GG", "GG: Geology & Geophysics");
    deptMap.put("GERI", "GERI: Geriatric Medicine");
    deptMap.put("GER", "GER: German");
    deptMap.put("GHPS", "GHPS: Global Health & Pop Studies");
    deptMap.put("GRK", "GRK: Greek");
    deptMap.put("HAW", "HAW: Hawaiian");
    deptMap.put("HWST", "HWST: Hawaiian Studies");
    deptMap.put("HNDI", "HNDI: Hindi");
    deptMap.put("HIST", "HIST: History");
    deptMap.put("HON", "HON: Honors");
    deptMap.put("HRM", "HRM: Human Resources Mgt");
    deptMap.put("ILO", "ILO: Ilokano");
    deptMap.put("IP", "IP: Indo-Pacific Languages");
    deptMap.put("IND", "IND: Indonesian");
    deptMap.put("ITM", "ITM: Information Technology Mgt");
    deptMap.put("ICS", "ICS: Information& Computer Sciences");
    deptMap.put("ITE", "ITE: Institute for Teacher Educatn");
    deptMap.put("INS", "INS: Insurance");
    deptMap.put("IS", "IS: Interdisciplinary Studies");
    deptMap.put("CUL", "CUL: Internatl Cultural Studies");
    deptMap.put("ITAL", "ITAL: Italian");
    deptMap.put("JPN", "JPN: Japanese Language & Literature");
    deptMap.put("JOUR", "JOUR: Journalism");
    deptMap.put("KRS", "KRS: Kinesiology & Rehab Science");
    deptMap.put("KOR", "KOR: Korean");
    deptMap.put("LLEA", "LLEA: Lang & Lit Europe & Americas");
    deptMap.put("LATN", "LATN: Latin");
    deptMap.put("LAIS", "LAIS: Latin Amer & Iberian Studies");
    deptMap.put("LAW", "LAW: Law");
    deptMap.put("LWEV", "LWEV: Law-Environmental");
    deptMap.put("LWJT", "LWJT: Law-Journals and Teams");
    deptMap.put("LWPA", "LWPA: Law-Pacific and Asian");
    deptMap.put("LIS", "LIS: Library & Information Science");
    deptMap.put("LING", "LING: Linguistics");
    deptMap.put("MGT", "MGT: Management");
    deptMap.put("MAO", "MAO: Maori");
    deptMap.put("MKT", "MKT: Marketing");
    deptMap.put("MATH", "MATH: Mathematics");
    deptMap.put("ME", "ME: Mechanical Engineering");
    deptMap.put("MDED", "MDED: Medical Education");
    deptMap.put("MEDT", "MEDT: Medical Technology");
    deptMap.put("MED", "MED: Medicine");
    deptMap.put("MET", "MET: Meteorology");
    deptMap.put("MICR", "MICR: Microbiology");
    deptMap.put("MSL", "MSL: Military Science & Leadership");
    deptMap.put("MCB", "MCB: Molecular and Cell Biology");
    deptMap.put("MBBE", "MBBE: Molecular Biosci & Bioengr");
    deptMap.put("MUS", "MUS: Music");
    deptMap.put("NHH", "NHH: Native Hawaiian Health");
    deptMap.put("NREM", "NREM: Natural Res & Environmtl Mgt");
    deptMap.put("NURS", "NURS: Nursing");
    deptMap.put("OBGN", "OBGN: Obstetrics & Gynecology");
    deptMap.put("OEST", "OEST: Ocean & Earth Science & Tech");
    deptMap.put("ORE", "ORE: Ocean & Resources Engineering");
    deptMap.put("OCN", "OCN: Oceanography");
    deptMap.put("PACS", "PACS: Pacific Islands Studies");
    deptMap.put("PATH", "PATH: Pathology");
    deptMap.put("PACE", "PACE: Peace and Conflict Education");
    deptMap.put("PED", "PED: Pediatrics");
    deptMap.put("PERS", "PERS: Persian");
    deptMap.put("PHRM", "PHRM: Pharmacology");
    deptMap.put("PHIL", "PHIL: Philosophy");
    deptMap.put("PHYS", "PHYS: Physics");
    deptMap.put("PHYL", "PHYL: Physiology");
    deptMap.put("PEPS", "PEPS: Plant & Environmtl Protect Sci");
    deptMap.put("POLS", "POLS: Political Science");
    deptMap.put("PORT", "PORT: Portuguese");
    deptMap.put("PSTY", "PSTY: Psychiatry");
    deptMap.put("PSY", "PSY: Psychology");
    deptMap.put("PUBA", "PUBA: Public Administration");
    deptMap.put("PH", "PH: Public Health");
    deptMap.put("PPC", "PPC: Public Policy Center");
    deptMap.put("RE", "RE: Real Estate");
    deptMap.put("REL", "REL: Religion");
    deptMap.put("RUS", "RUS: Russian");
    deptMap.put("SAM", "SAM: Samoan");
    deptMap.put("SNSK", "SNSK: Sanskrit");
    deptMap.put("SLS", "SLS: Second Language Studies");
    deptMap.put("SOCS", "SOCS: Social Science");
    deptMap.put("SW", "SW: Social Work");
    deptMap.put("SOC", "SOC: Sociology");
    deptMap.put("SPAN", "SPAN: Spanish");
    deptMap.put("SPED", "SPED: Special Education");
    deptMap.put("SURG", "SURG: Surgery");
    deptMap.put("TAHT", "TAHT: Tahitian");
    deptMap.put("THAI", "THAI: Thai");
    deptMap.put("THEA", "THEA: Theatre");
    deptMap.put("TONG", "TONG: Tongan");
    deptMap.put("TI", "TI: Translation & Interpretation");
    deptMap.put("TIM", "TIM: Travel Industry Management");
    deptMap.put("TRMD", "TRMD: Tropical Med & Medcl Micro");
    deptMap.put("TPSS", "TPSS: Tropical Plant & Soil Sciences");
    deptMap.put("PLAN", "PLAN: Urban & Regional Planning");
    deptMap.put("URDU", "URDU: Urdu");
    deptMap.put("VIET", "VIET: Vietnamese");
    deptMap.put("WS", "WS: Women's Studies");
    deptMap.put("ZOOL", "ZOOL: Zoology");
    deptMap.put("PUBA", "PUBA: Public Administration");
    deptMap.put("PH", "PH: Public Health");
    deptMap.put("PPC", "PPC: Public Policy Center");
    deptMap.put("RE", "RE: Real Estate");
    deptMap.put("REL", "REL: Religion");
    deptMap.put("RUS", "RUS: Russian");
    deptMap.put("SAM", "SAM: Samoan");
    deptMap.put("SNSK", "SNSK: Sanskrit");
    deptMap.put("SLS", "SLS: Second Language Studies");
    deptMap.put("SOCS", "SOCS: Social Science");
    deptMap.put("SW", "SW: Social Work");
    deptMap.put("SOC", "SOC: Sociology");
    deptMap.put("SPAN", "SPAN: Spanish");
    deptMap.put("SPED", "SPED: Special Education");
    return deptMap;
  }

  public static void page(String[] days, String[] genFocus, String department, String courseTitleandName, String instructor, String startTime, String endTime) {
    boolean noQueryCheck = true;
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
    
    
    List<String> crnList = new ArrayList<>();
    if(days != null && days.length > 0 && daycheck != 7) {
      secondQuery = Ebean.createQuery(Course.class);
      noQueryCheck = false;
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
  

  
}

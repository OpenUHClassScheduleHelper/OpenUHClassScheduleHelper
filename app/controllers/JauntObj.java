package controllers;

import java.util.ArrayList;
import java.util.List;
import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

/**
 * A wrapper class for the Jaunt API.
 * 
 * @author Rob Namahoe
 */
public class JauntObj {

  private static ArrayList<JauntCourseItem> courseItems = new ArrayList<JauntCourseItem>();
  private static ArrayList<JauntMeetingItem> meetingItems = new ArrayList<JauntMeetingItem>();
  
  /**
   * Default Constructor Method.
   */
  public JauntObj() {
    // Do nothing.
  }

  /**
   * Scrape the contents of a single page.
   * @param url The url of the page to scrape.
   */
  public void scrapeUrl(String url) {
    String semester = getSemester(url);
    processUrl(url, semester);
  }
  
  /**
   * The the contents of every linked page on the given url.
   * @param url The url of the page containing the links of pages to scrape.
   */
  public void scrapeLinks(String url) {
    String semester = getSemester(url);
    ArrayList<String> links = getLinks(url);
    for (String link : links) {
      processUrl(link, semester);
    }
  }
  
  /**
   * Scrape the contents of a page creating JauntCourseItems and JauntMeetingItems when needed.
   * @param url The url of the page to scrape.
   */
  private void processUrl(String url, String semester) {
    
    int iColumnCount = 0;
    String crn = "";
    
    try {
      
      UserAgent userAgent = new UserAgent();
      userAgent.visit(url);
      List<Element> trs = userAgent.doc.findFirst("<table class=listOfClasses>").getEach("<tr>").toList();
      
      for (int i = 0; i < trs.size(); i++) { // iterate through <tr>s
        Element tr = trs.get(i);
        
        // Only process the row if there are more than 6 columns
        // otherwise it will crash.
        iColumnCount =  tr.getEach("<td|th>").toList().size();
        if (iColumnCount > 6) {
          // Only create a new row item if it is a valid CRN.
          if (isCrn(tr.getElement(1).innerText())) {
            JauntCourseItem item = new JauntCourseItem();
            crn = tr.getElement(1).innerText();
            item.setCrn(crn);                                       // CRN
            item.setFocus(getFocus(tr.getElement(0).innerText()));  // Focus
            item.setCourse(tr.getElement(2).innerText());           // Course
            item.setSection(tr.getElement(3).innerText());          // Section
            item.setTitle(getTitle(tr.getElement(4).innerText()));  // Title
            item.setCredits(tr.getElement(5).innerText());          // Credits            
            item.setInstructor(tr.getElement(6).innerText());       // Instructor
            item.setSemester(semester);                             // Semester
            courseItems.add(item);
          }

          // Create and add JauntMeeting Items to the meeting collection.
          // Columns are not consistent going forward, so get columns starting backwards.
          addMeetingItems(crn, tr.getElement(iColumnCount-4).innerText(),tr.getElement(iColumnCount-3).innerText(),
                              tr.getElement(iColumnCount-2).innerText());
          
        } // End of column check
      } // end of for loop
    }
    catch (JauntException e) {
      System.err.println(e);
    }
  }

  /**
   * Get a list of 
   * @param crn The crn of the current class.
   * @param days The days the class meets.
   * @param times The time of day the class meets.
   * @param room The location of the class.
   * @return A list of JauntMeetingItems.
   */
  private void addMeetingItems(String crn, String days, String times, String room) {
    
    String startTime = "";
    String endTime = "";
    String ampm = "a";
    
    if (times.equalsIgnoreCase("tba")) {
      startTime = "TBA";
      endTime = "TBA";
    }
    else {
      startTime = times.substring(0, 4); 
      endTime = times.substring(5,10);
      if (times.substring(9).equalsIgnoreCase("p")) {
        int startHour = Integer.parseInt(times.substring(0, 2));
        startHour = (startHour == 12) ? 0 : startHour;
        int endHour = Integer.parseInt(times.substring(5, 7));
        for (int i = 1; i < 12; i++) {
          if (i + endHour == startHour + 12) {
            ampm = "p";
          }
        }
      }
      startTime = startTime + ampm;
    }
    
    if (days.equalsIgnoreCase("tba")) {
      JauntMeetingItem meeting = new JauntMeetingItem(crn, "TBA", startTime, endTime, room);
      meetingItems.add(meeting);
    }
    else {
      // loop through days creating a new JauntMeeingObject for each meeting
      for (char day : days.toCharArray()) {
        JauntMeetingItem meeting = new JauntMeetingItem(crn, Character.toString(day), startTime, endTime, room);
        meetingItems.add(meeting);
      }
    }
  }
  
  /**
   * Checks if a string is a 5 digit number. 
   * @param strNum The string to test.
   * @return True if the string is also an integer, false otherwise.
   */
  private static boolean isCrn(String strNum) {
    strNum.trim();
    if (strNum.length() != 5) {
      return false;
    }
    try {
      Integer.parseInt(strNum);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  /**
   * Get the Gen Ed/focus attribute of the course, if available.
   * @param focus The focus.
   * @return The valid focus string or a zero-length string if invalid.
   */
  private static String getFocus(String focus) {
    String ret = focus;
    if (focus.indexOf("nbsp") > 0) {
      ret = "";
    }
    return ret;
  }

  /**
   * Gets the course title without the following string "Restriction: ".
   * @param title The title of the course.
   * @return The title of the string.
   */
  private static String getTitle(String title) {
    String ret = title.trim();
    int startIndex = title.indexOf("Restriction: ");
    if (startIndex > 0) {
      int endIndex = title.length();
      String toBeReplaced = ret.substring(startIndex, endIndex);
      ret = ret.replace(toBeReplaced, "");
    }
    return ret;
  }

  /**
   * Get a list of all the links on the main Class Availability web site.
   * @param mainPage The url to the main Class Availability web site.
   * @return A list of link to the department class avail. web site.
   */
  private ArrayList<String> getLinks(String mainPage) {
    
    ArrayList<String> results = new ArrayList<String>();
    
    // Remove all special characters. Makes the comparison easier.
    String mainUrl = mainPage.replaceAll("\\W", "");
    
    try{
      UserAgent userAgent = new UserAgent();
      userAgent.visit(mainPage);    
      Elements links = userAgent.doc.findEvery("<a>");  // Get all links on the page.
      for(Element link : links) {
        // Ensure that the only pages returned are those that are sub-pages of the
        // main page. This removes links to the UH homepage, for example.
        if (link.getAttx("href").replaceAll("\\W", "").indexOf(mainUrl) > -1) {
          results.add(link.getAttx("href"));
        }
      }                                                   
    }
    catch(ResponseException e){
      System.out.println(e);
    } 
    return results;
  }
  
  /**
   * Get the semester associated with the main page.
   * @param mainPage The url to the main Class Availability web site.
   * @return The semester the courses are being offered.
   */
  public static String getSemester(String mainPage) {
   
    String[] tokens;
    String semester = "";

    try {
      UserAgent userAgent = new UserAgent();  
      userAgent.visit(mainPage);
      Element body = userAgent.doc.findFirst("<TITLE>");
      tokens = body.innerText().split(" ");
      
      for (int i = 0; i < tokens.length; i++) {
        String token = tokens[i];
        if (token.equalsIgnoreCase("fall") || token.equalsIgnoreCase("summer") ||
            token.equalsIgnoreCase("spring") || token.equalsIgnoreCase("winter")) {
          semester = tokens[i] + " " + tokens[i + 1];
        }
      }
    }
    catch(JauntException e){
      System.err.println(e);
    }
    return semester;
  }
  
  /**
   * Get the list of results.
   * @return The list of JauntCourseItems.
   */
  public ArrayList<JauntCourseItem> getCourses() {
    return courseItems;
  }
  
  /**
   * Get the list of course meetings.
   * @return The list of JauntMeetingItems.
   */
  public ArrayList<JauntMeetingItem> getMeetings () {
    return meetingItems;
  }
  
}

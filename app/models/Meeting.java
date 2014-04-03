package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Meeting {

  private String day;
  private String start;
  private String end;
  private String room;

  /**
   * default constructor.
   */
  public Meeting() {
    // default constructor
  }

  /**
   * Constructor for the object to be placed in the meeting list. The list will be used to construct the Course object.
   * 
   * @param day The day of the week
   * @param start The class start time
   * @param end The class end time
   * @param room The location of the class (for that day)
   */
  public Meeting(String day, String start, String end, String room) {
    this.setDay(day);
    this.setStart(start);
    this.setEnd(end);
    this.setRoom(room);
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }
  
  public String getMeetingString() {
     return this.day + " " + this.start + "-" + this.end + " " + this.room;
  }
  
  /**
   * Get the date and time the given class meets in ISO8601 format.
   * @return An long value representing the day and time the class meets in ISO8601 format.
   */
  public String getFullCalendarStartTime() {
    System.out.println(getFullCalendarEntry("start"));
    return getFullCalendarEntry("start");
  }
  
  /**
   * Get the date and time the given class ends in ISO8601 format.
   * @return An long value representing the day and time the class ends in ISO8601 format.
   */
  public String getFullCalendarEndTime() {
    System.out.println(getFullCalendarEntry("end"));
    return getFullCalendarEntry("end");
  }
  
  /**
   * A private method that calculates times formatted as ISO8601 for the beginning or ending time of a course.
   * @param whichEntry "start" if the start time is needed, "end" if the end time is needed.
   * @return The specified time formatted as a Unix timestamp.
   */
  private String getFullCalendarEntry(String whichEntry) {
    
    TimeZone tz = TimeZone.getTimeZone("HST");
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    df.setTimeZone(tz);
    
    Calendar c = Calendar.getInstance();
    
    // Set the date of the calendar object.
    c.setFirstDayOfWeek(Calendar.SUNDAY);
    switch (this.day.toUpperCase()) {
      case "M":   // Monday
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
      break;
      case "T":   // Tuesday
        c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
      break;
      case "W":   // Wednesday
        c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
      break;
      case "R":   // Thursday
        c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
      break;
      case "F":   // Friday
        c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
      break;
      case "S":  // Saturday
        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
      break;
    }

    // Set the time depending on the entry needed - start or end
    String tempTime = (whichEntry.equals("start")) ? this.start : this.end;

    // Parse hour from tempTime and convert to military time.
    int hour = Integer.parseInt(tempTime.substring(0,2));
    hour += (tempTime.indexOf("p") > 0 && hour < 12) ? 12 : 0;

    // Parse minute from tempTime
    int minute = Integer.parseInt(tempTime.substring(2,4));
    
    // Set the time of the calendar object.
    c.set(Calendar.HOUR_OF_DAY, hour);
    c.set(Calendar.MINUTE, minute);
    c.set(Calendar.SECOND, 0);
    
    // Format as ISO8601 for use in the FullCalendar object.
    return df.format(c.getTime());
    
  }
 
}
package models;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;

@Entity
public class Meeting extends Model {

  private static final long serialVersionUID = 1L;
  
  @Id
  private long Id;
  
  private String crn;
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
   * @param crn The crn of the course.
   * @param day The day of the week
   * @param start The class start time
   * @param end The class end time
   * @param room The location of the class (for that day)
   */
  public Meeting(String crn, String day, String start, String end, String room) {
    this.setCrn(crn);
    this.setDay(day);
    this.setStart(start);
    this.setEnd(end);
    this.setRoom(room);
  }

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for courses.
   */
  public static Finder<Long, Meeting> find() {
    return new Finder<Long, Meeting>(Long.class, Meeting.class);
  }
  
  /**
   * @return the id
   */
  public long getId() {
    return Id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    Id = id;
  }

  /**
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * @param crn the crn to set
   */
  public void setCrn(String crn) {
    this.crn = crn;
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
   * Checks if two meetings overlap.
   * @param meeting The other meeting.
   * @return true if the two overlap, false otherwise.
   */
  public boolean isOverlapping(Meeting meeting) {
    Date start = meeting.getFullCalendarStartTimeAsDate();
    Date end = meeting.getFullCalendarEndTimeAsDate();
    return getFullCalendarStartTimeAsDate().before(end) && start.before(getFullCalendarEndTimeAsDate());
}
  
  /**
   * Get the date and time the given class meets - formatted as a Unix timestamp.
   * @return An long value representing the day and time the class meets formatted as a Unix timestamp.
   */
  public long getFullCalendarStartTime() {
    return getFullCalendarEntry("start");
  }
  
  /**
   * Get the date and time the given class ends - formatted as a Unix timestamp.
   * @return An long value representing the day and time the class ends formatted as a Unix timestamp.
   */
  public long getFullCalendarEndTime() {
    return getFullCalendarEntry("end");
  }
  
  /**
   * A private method that retrieves the Unix timestamp for the beginning or ending time of a course.
   * @param whichEntry "start" if the start time is needed, "end" if the end time is needed.
   * @return The specified time formatted as a Unix timestamp.
   */
  private long getFullCalendarEntry(String whichEntry) {
    return calculateFullCalendarTime(whichEntry).getTimeInMillis() / 1000L;
  }
 
  /**
   * Get the date and time the given class meets - formatted as a java Date object.
   * @return The beginning time of the course as a java date object.
   */
  public Date getFullCalendarStartTimeAsDate() {
    return getFullCalendarEntryAsDate("start");
  }
  
  /**
   * Get the date and time the given class ends - formatted as a java Date object.
   * @return The end time of the course as a java date object.
   */
  public Date getFullCalendarEndTimeAsDate() {
    return getFullCalendarEntryAsDate("end");
  }
  
  /**
   * A private method that returns the java date object representing the start or end of a course.
   * @param whichEntry "start" if the start time is needed, "end" if the end time is needed.
   * @return The specified time as a java date object.
   */
  private Date getFullCalendarEntryAsDate(String whichEntry) {
      return calculateFullCalendarTime(whichEntry).getTime();
  }
  
  /**
   * A private method that calculates the Unix timestamp for the beginning or ending time of a course.
   * @param whichEntry "start" if the start time is needed, "end" if the end time is needed.
   * @return The specified time formatted as a Unix timestamp.
   */
  private Calendar calculateFullCalendarTime(String whichEntry) {
    TimeZone tz = TimeZone.getTimeZone("HST");
    Calendar cal = Calendar.getInstance();
    
    // Set the date of the calendar object.
    cal.setFirstDayOfWeek(Calendar.SUNDAY);
    switch (this.day.toUpperCase()) {
      case "M":   // Monday
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        break;
      case "T":   // Tuesday
        cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        break;
      case "W":   // Wednesday
        cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        break;
      case "R":   // Thursday
        cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        break;
      case "F":   // Friday
        cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        break;
      case "S":  // Saturday
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        break;
      case "U":  // Sunday
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        break;
      default:
        break;
    }

    // Account for TBA entries
    if (this.start.equalsIgnoreCase("TBA")) {
      cal.setTimeZone(tz);
      cal.set(Calendar.HOUR_OF_DAY, 0);
      cal.set(Calendar.MINUTE, 0);
      cal.set(Calendar.SECOND, 0);
      return cal;
    }
    
    // Set the time depending on the entry needed - start or end
    String tempTime = (whichEntry.equals("start")) ? this.start : this.end;

    // Parse hour from tempTime and convert to military time.
    int hour = Integer.parseInt(tempTime.substring(0,2));
    hour += (tempTime.indexOf("p") > 0 && hour < 12) ? 12 : 0;

    // Parse minute from tempTime
    int minute = Integer.parseInt(tempTime.substring(2,4));
    
    // Set the time of the calendar object.
    cal.setTimeZone(tz);
    cal.set(Calendar.HOUR_OF_DAY, hour);
    cal.set(Calendar.MINUTE, minute);
    cal.set(Calendar.SECOND, 0);
    
    // Convert to unix timestamp for use in the FullCalendar object.
    // To convert java date to unix timestamp, divide by 1000 since java 
    // uses milliseconds and unix uses seconds.
    return cal;
  }
  
}
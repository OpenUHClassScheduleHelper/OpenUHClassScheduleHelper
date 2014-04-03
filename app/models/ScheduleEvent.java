package models;

/**
 * Represents an event on the FullCalendar component.
 * @author rckndn
 */
public class ScheduleEvent {
  
  private String id;
  private String title;
  private long start;
  private long end;
  private String backgroundColor;
  
  /**
   * The default constructor method.
   * @param id The event id.
   * @param title The event title.
   * @param start The start time of the event.
   * @param end The end time of the event.
   * @param conflictExists true if another events overlaps this event.
   */
  public ScheduleEvent(String id, String title, long start, long end, Boolean conflictExists) {
    this.id = id;
    this.title = title;
    this.start = start;
    this.end = end;
    this.backgroundColor = (conflictExists) ? "#F58E9D" : "#BBFF99";
  }
  
  /**
   * @return the id
   */
  public String getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }
  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }
  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }
  /**
   * @return the start
   */
  public long getStart() {
    return start;
  }
  /**
   * @param start the start to set
   */
  public void setStart(long start) {
    this.start = start;
  }
  /**
   * @return the end
   */
  public long getEnd() {
    return end;
  }
  /**
   * @param end the end to set
   */
  public void setEnd(long end) {
    this.end = end;
  }
  /**
   * @return the backgroundColor
   */
  public String getBackgroundColor() {
    return backgroundColor;
  }
  /**
   * @param backgroundColor the backgroundColor to set
   */
  public void setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
  }
 
}

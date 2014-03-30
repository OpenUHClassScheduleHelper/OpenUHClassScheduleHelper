package models;

import java.util.ArrayList;
import java.util.List;

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

}
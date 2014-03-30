package models;

import java.util.ArrayList;
import java.util.List;
import models.Meeting;

public class Course {

  private String genFocus;
  private String courseNumber;
  private String courseName;
  private String section;
  private String courseTitle;
  private String credits;
  private String instructor;
  private String seats;
  private List<Meeting> meeting;
  private String room;

  /**
   * default constructor.
   */
  public Course() {
    // default constructor
  }

  /**
   * Constructor.
   * 
   * @param genFocus
   * @param courseNumber
   * @param courseName
   * @param section
   * @param courseTitle
   * @param credits
   * @param instructor
   * @param seats
   * @param meeting object (todo)
   * @param room TODO: add new parameters, get/set them
   */
  public Course(String genFocus, String courseNumber, String courseName, String section, String courseTitle,
      String credits, String instructor, String seats, List<Meeting> meeting, String room) {

    this.setGenFocus(genFocus);
    this.setCourseNumber(courseNumber);
    this.setCourseName(courseName);
    this.setSection(section);
    this.setCourseTitle(courseTitle);
    this.setCredits(credits);
    this.setInstructor(instructor);
    this.setSeats(seats);
    this.setRoom(room);
    this.setMeeting(meeting);

  }

  public String getGenFocus() {
    return genFocus;
  }

  public void setGenFocus(String genFocus) {
    this.genFocus = genFocus;
  }

  public String getCredits() {
    return credits;
  }

  public void setCredits(String credits) {
    this.credits = credits;
  }

  public String getSeats() {
    return seats;
  }

  public void setSeats(String seats) {
    this.seats = seats;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public String getInstructor() {
    return instructor;
  }

  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

  public String getCourseTitle() {
    return courseTitle;
  }

  public void setCourseTitle(String courseTitle) {
    this.courseTitle = courseTitle;
  }

  public String getSection() {
    return section;
  }

  public void setSection(String section) {
    this.section = section;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getCourseNumber() {
    return courseNumber;
  }

  public void setCourseNumber(String courseNumber) {
    this.courseNumber = courseNumber;
  }

  public List<Meeting> getMeeting() {
    return meeting;
  }

  public void setMeeting(List<Meeting> meeting) {
    this.meeting = meeting;
  }

}
package models;

public class Course {
  
  private String courseNumber;
  private String courseName;
  private String section;
  private String courseTitle;
  private String instructor;
  private String room;
  private int credits;
  private int seats;
  private String days;
  private String time;
  
  /**
   * default constructor.
   */
  public Course() {
    //default constructor
  }
  
  /**
   * Constructor.
   * @param courseNumber
   * @param courseName
   * @param section
   * @param courseTitle
   * @param instructor
   * @param credits
   * @param seats
   * @param days
   * @param time
   * @param room  (remove room?)
   * TODO: add new parameters, get/set them
   */
  public Course(String courseNumber, String courseName, String section, String courseTitle, String instructor, 
                  String room) {
    
    this.setCourseNumber(courseNumber);
    this.setCourseName(courseName);
    this.setSection(section);
    this.setCourseTitle(courseTitle);
    this.setInstructor(instructor);
    this.setRoom(room);
    
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
  
}
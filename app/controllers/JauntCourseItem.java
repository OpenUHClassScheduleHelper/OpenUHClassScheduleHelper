package controllers;

/**
 * Represents a table row extracted by the Jaunt API.
 * @author Rob Namahoe
 */
public class JauntCourseItem {
    private String focus;
    private String crn;
    private String course;
    private String credits;
    private String section;
    private String title;
    private String instructor;
    private String semester;
    
    /**
     * Default Constructor Method.
     */
    public JauntCourseItem() {
      // Default Constructor Method.
    }
    
    /**
     * @param focus Gen.Ed./Focus attribute. 
     * @param crn the crn of the course.
     * @param course The course number, i.e. 'ICS 311'.
     * @param section The couse section.
     * @param title The course title, i.e. 'Algorithms'.
     * @param instructor The instructor.
     */
    public JauntCourseItem(String focus, String crn, String course, String section, String title, String credits,
                           String instructor, String semester) {
      this.setFocus(focus);
      this.setCrn(crn);
      this.setCourse(course);
      this.setSection(section);
      this.setTitle(title);
      this.setCredits(credits);
      this.setInstructor(instructor);
      this.setSemester(semester);
    }

    /**
     * @return the focus
     */
    public String getFocus() {
      return focus;
    }

    /**
     * @param focus the focus to set
     */
    public void setFocus(String focus) {
      this.focus = focus;
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

    /**
     * @return the course
     */
    public String getCourse() {
      return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
      this.course = course;
    }

    /**
     * @return the section
     */
    public String getSection() {
      return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(String section) {
      this.section = section;
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
     * @return the instructor
     */
    public String getInstructor() {
      return instructor;
    }

    /**
     * @param instructor the instructor to set
     */
    public void setInstructor(String instructor) {
      this.instructor = instructor;
    }
    
    public void printIt() {
      System.out.println(focus + ", " + crn + ", " + course + ", " + section + ", " + title + ", " + instructor);
    }

    /**
     * @return the semester
     */
    public String getSemester() {
      return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
      this.semester = semester;
    }

    /**
     * @return the credits
     */
    public String getCredits() {
      return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(String credits) {
      this.credits = credits;
    }

}

package views.formdata;


/**
 * The backing class for the search widget.
 * @author Evan Komiyama
 *
 */
public class SearchForm {

  /**Department field**/
  public String department = "";
  
  /**Instructor field**/
  public String instructor = "";
  
  /**Course type field**/
  public String course = "";
  
  /**Focus field**/
  public String[] focus = null;
  
  /**Days field**/
  public String[] days = null;
  
  /**StartTime field**/
  public String startTime = "";
  
  /**EndTime field**/
  public String endTime = "";
  
  public SearchForm() {
    //Do nothing
  }
  
  public SearchForm(String department, String instructor, String course, String[] focus, String[] days, String startTime, String endTime) {
    this.department = department;
    this.instructor = instructor;
    this.course = course;
    this.focus = focus;
    this.days = days;
    this.startTime = startTime;
    this.endTime = endTime;
  }
  
}

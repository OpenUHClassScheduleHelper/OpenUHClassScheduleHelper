package views.formdata;
 
/**
 * Class that stores form data for the comment.
 */
public class CommentFormData {

  /** The comment id. */
  public String id;
  /** The comment */
  public String comment = "";
  /**The course crn**/
  public String crn = "";
  /**The User that wrote the comment**/
  public String username = "";

  /**
   * Default constructor.
   */
  public CommentFormData() {
    // Default constructor method.
  }

  /**
   * Constructor method.
   */
  public CommentFormData(String id, String comment, String crn, String username) {
    this.id = id;
    this.comment = comment;
    this.crn = crn;
    this.username = username;
  }
  
}

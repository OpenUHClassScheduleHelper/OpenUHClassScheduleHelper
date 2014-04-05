package views.formdata;
 
/**
 * Class that stores form data for the comment.
 */
public class CommentFormData {

  /** The comment id. */
  public String id;
  /** The comment */
  public String comment = "";

  /**
   * Default constructor.
   */
  public CommentFormData() {
    // Default constructor method.
  }

  /**
   * Constructor method.
   */
  public CommentFormData(String id, String comment) {
    this.id = id;
    this.comment = comment;
  }
  
}

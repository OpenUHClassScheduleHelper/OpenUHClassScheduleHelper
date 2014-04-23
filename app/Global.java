import controllers.WebScraper;
import play.Application;
import play.GlobalSettings;
import models.UserCommentDB;

/**
 * Global settings for the Play application.
 *  
 * @author Rob Namahoe
 */
public class Global extends GlobalSettings {

  /**
   * Overrides the onStart method.
   * 
   * @param app The Play application.
   */
  public void onStart(Application app) {
    
    // Update Database
    //WebScraper ws = new WebScraper();
    //ws.scrapeLinks("https://www.sis.hawaii.edu/uhdad/avail.classes?i=MAN&t=201510");

  }
}

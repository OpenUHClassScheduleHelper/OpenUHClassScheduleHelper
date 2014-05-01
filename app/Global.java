import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import play.Application;
import play.GlobalSettings;
import models.Notifier;

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
    
    // Schedule the notifier
    Timer timer = new Timer();
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTimeZone(TimeZone.getTimeZone("HST"));   
    cal.setTime(date);
    cal.set(Calendar.HOUR_OF_DAY, 17);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    // Schedule to run everyday at 5:00pm
    timer.schedule(
      new Notifier(),
      cal.getTime(),
      1000 * 60 * 60 * 24
    );
        
    // Update Database
    //WebScraper ws = new WebScraper();
    //ws.scrapeLinks("https://www.sis.hawaii.edu/uhdad/avail.classes?i=MAN&t=201510");

  }
}

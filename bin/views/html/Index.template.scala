
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object Index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*2.2*/(page: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*2.16*/("""

"""),_display_(Seq[Any](/*4.2*/Main("Open UH Schedule Helper", false)/*4.40*/ {_display_(Seq[Any](format.raw/*4.42*/("""
  <!-- social glyphicons -->
  <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

   <!-- Welcome Image -->
  <div class="onboarding-picture-block">
    <div class="intro-text">Making Registration a Breeze!</div>
  </div>

  <!-- Convenience Block -->

  <div class="colorblock-white">
    <div class="col-md-12">
      <div class="col-md-6">
        <div class="block-header">Build your schedule</div>
        <div class="block-text">Need a writing intensive class? Or maybe something on Tuesdays and Thursdays? 
         Use our simple but powerful search tool to find exactly what you need. Search by Course title, 
         instructor, focus, day and time and more!
      </div>
      </div>
      <!-- End of col-md-6 (Text Columns) -->
      <div class="col-md-6">
        <img class="block-image" src=""""),_display_(Seq[Any](/*26.40*/routes/*26.46*/.Assets.at("images/search.png"))),format.raw/*26.77*/("""">
      </div>
      <!-- End of col-md-6 (Image Columns) -->
    </div>
    <!-- End of row -->
  </div>
  <!-- End of color block -->

  <!-- Latest News Block -->
  <div class="colorblock-gradient">
    <div class="col-md-6 col-md-push-6">
      <div class="block-header" style="color:white;">Late breaking info</div>
      <div class="block-text" style="color:white;">
        We think the best decision is an informed one. That's why we've made it so teachers and student can 
        leave news that's important to you. Browse the descriptions and sign up for the class that best suits
        you.
      </div>
    </div>
    <!-- End of col-md-6 (Text Columns) -->
    <div class="col-md-6 col-md-pull-6">
      <img class="block-image" src=""""),_display_(Seq[Any](/*46.38*/routes/*46.44*/.Assets.at("images/info.jpg"))),format.raw/*46.73*/("""">
    </div>
    <!-- End of col-md-6 (Image Columns) -->
  </div>
  <!-- End of color block -->


  <!-- Mobile Design Block -->
  <div class="colorblock-white">
    <div class="col-md-6">
      <div class="block-header">Easy to use mobile design</div>
      <div class="block-text">We know you're busy and always on the go. That's why we built this site with a
        mobile first attitude. Access it from your laptop or your smartphone. It's all good!</div>
    </div>
    <!-- End of col-md-6 (Text Columns) -->
    <div class="col-md-6">
      <img class="block-image" src=""""),_display_(Seq[Any](/*62.38*/routes/*62.44*/.Assets.at("images/dynamic.gif"))),format.raw/*62.76*/("""">
    </div>
    <!-- End of col-md-6 (Image Columns) -->
  </div>
  <!-- End of color block -->


  <!-- Map Block -->
  <div class="colorblock-gradient">
    <div class="col-md-6 col-md-push-6">
      <div class="block-header">Map your route between classes</div>
      <div class="block-text">Don't know where your class is? Curious how far it is between classes? Click on the
        Maps link to see a map of your schedule.</div>
    </div>
    <!-- End of col-md-6 (Text Columns) -->
    <div class="col-md-6 col-md-pull-6">
      <img class="block-image" src=""""),_display_(Seq[Any](/*78.38*/routes/*78.44*/.Assets.at("images/myroute.jpg"))),format.raw/*78.76*/("""">
    </div>
    <!-- End of col-md-6 (Image Columns) -->
  </div>
  <!-- End of color block -->


  <!-- Testmony Block -->
  <div class="colorblock-white">
    <div class="col-md-6">
      <div class="block-header">Students love us!</div>
      <div class="block-text">We think we've got something great here but you don't have to take our word for it.
        Here's what some other users have got to say.</div>
    </div>
    <!-- End of col-md-6 (Text Columns) -->
    <div class="col-md-6">
      <img class="block-image" src=""""),_display_(Seq[Any](/*94.38*/routes/*94.44*/.Assets.at("images/testimony.jpg"))),format.raw/*94.78*/("""">
    </div>
    <!-- End of col-md-6 (Image Columns) -->
  </div>
  <!-- End of color block -->

  <div class="social-div">
    <p class="social-p">
      Social: 
      <a class="social-a" href="https://www.facebook.com/"> 
        <i class="fa fa-facebook"></i> Facebook
      </a> 
      <a class="social-a" href="https://twitter.com">
        <i class="fa fa-twitter"></i> Twitter
      </a> 
      <a class="social-a" href="https://github.com/OpenUHClassScheduleHelper/OpenUHClassScheduleHelper">
        <i class="fa fa-github"></i> GitHub
      </a> 
      <a class="social-a" href="">
        <i class="fa fa-envelope-o"></i> Contact 
      </a>
    </p>
  </div>
""")))})))}
    }
    
    def render(page:String): play.api.templates.HtmlFormat.Appendable = apply(page)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (page) => apply(page)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Apr 02 16:27:57 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/Index.scala.html
                    HASH: e11d14eb165fe459ae273a5f375ea7d708092e0a
                    MATRIX: 774->3|882->17|921->22|967->60|1006->62|1927->947|1942->953|1995->984|2803->1756|2818->1762|2869->1791|3503->2389|3518->2395|3572->2427|4193->3012|4208->3018|4262->3050|4849->3601|4864->3607|4920->3641
                    LINES: 26->2|29->2|31->4|31->4|31->4|53->26|53->26|53->26|73->46|73->46|73->46|89->62|89->62|89->62|105->78|105->78|105->78|121->94|121->94|121->94
                    -- GENERATED --
                */
            
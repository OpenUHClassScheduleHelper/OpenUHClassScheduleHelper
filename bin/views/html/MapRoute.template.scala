
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
object MapRoute extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),_display_(Seq[Any](/*3.2*/Main(page, true)/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
  <div class="container">
    <div class="full col-md-12">
      <h2>Campus Map</h2>
      <div id="map">
        <a href="https://raw.githubusercontent.com/OpenUHClassScheduleHelper/uimockup/search-revised-1/uhmap.jpg">
        <img src="https://raw.githubusercontent.com/OpenUHClassScheduleHelper/uimockup/search-revised-1/uhmap.jpg"
         style="max-width:100%;height:auto"></a>
      </div>
    </div>
  </div>
  <!-- End of container -->
""")))})))}
    }
    
    def render(page:String): play.api.templates.HtmlFormat.Appendable = apply(page)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (page) => apply(page)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Apr 13 20:27:53 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/MapRoute.scala.html
                    HASH: 62800d418b5b56cbe6e0b9615df77a43f2f139d6
                    MATRIX: 777->1|885->15|924->20|948->36|987->38
                    LINES: 26->1|29->1|31->3|31->3|31->3
                    -- GENERATED --
                */
            
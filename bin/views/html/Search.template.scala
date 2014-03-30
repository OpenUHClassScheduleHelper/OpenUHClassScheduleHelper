
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
object Search extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,List[Course],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: String, courses:List[Course]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.38*/("""

"""),_display_(Seq[Any](/*3.2*/Main(page)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""
    <div class="full col-sm-6 login-panel" style="margin-top: 0%">
        <h4 class="text-center">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Search results</h3>
                </div>
        </h4>
        <table class="table table-condensed">
          <thead>
            <tr>
              <th>CRN</th>
              <th>Course Name</th>
              <th>Section</th>
              <th>Course Title</th>
              <th>Instructor</th>
              <th>Room</th>
            </tr>
          </thead>
          
          """),_display_(Seq[Any](/*23.12*/for(course <- courses) yield /*23.34*/ {_display_(Seq[Any](format.raw/*23.36*/("""
            <tr>
              <td>"""),_display_(Seq[Any](/*25.20*/course/*25.26*/.getCourseNumber())),format.raw/*25.44*/("""</td>
              <td>"""),_display_(Seq[Any](/*26.20*/course/*26.26*/.getCourseName())),format.raw/*26.42*/("""</td>
              <td>"""),_display_(Seq[Any](/*27.20*/course/*27.26*/.getSection())),format.raw/*27.39*/("""</td>
              <td>"""),_display_(Seq[Any](/*28.20*/course/*28.26*/.getCourseTitle())),format.raw/*28.43*/("""</td>
              <td>"""),_display_(Seq[Any](/*29.20*/course/*29.26*/.getInstructor())),format.raw/*29.42*/("""</td>
              <td>"""),_display_(Seq[Any](/*30.20*/course/*30.26*/.getRoom())),format.raw/*30.36*/("""</td>
            </tr>
          """)))})),format.raw/*32.12*/("""
        </table>
    </div>
""")))})),format.raw/*35.2*/("""
"""))}
    }
    
    def render(page:String,courses:List[Course]): play.api.templates.HtmlFormat.Appendable = apply(page,courses)
    
    def f:((String,List[Course]) => play.api.templates.HtmlFormat.Appendable) = (page,courses) => apply(page,courses)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 09:38:30 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/Search.scala.html
                    HASH: 979e0c944f158e039a341a7b57a5a8bc9d321385
                    MATRIX: 788->1|918->37|957->42|975->52|1014->54|1693->697|1731->719|1771->721|1846->760|1861->766|1901->784|1963->810|1978->816|2016->832|2078->858|2093->864|2128->877|2190->903|2205->909|2244->926|2306->952|2321->958|2359->974|2421->1000|2436->1006|2468->1016|2537->1053|2601->1086
                    LINES: 26->1|29->1|31->3|31->3|31->3|51->23|51->23|51->23|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|60->32|63->35
                    -- GENERATED --
                */
            
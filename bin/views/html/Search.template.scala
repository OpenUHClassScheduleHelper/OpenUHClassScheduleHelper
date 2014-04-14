
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
object Search extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Boolean,List[Course],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: String, isLoggedIn: Boolean, courses:List[Course]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.59*/(""" """),_display_(Seq[Any](/*1.61*/Main(page, isLoggedIn)/*1.83*/ {_display_(Seq[Any](format.raw/*1.85*/("""
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
                <th>GenFocus</th>
                <th>CRN</th>
                <th>Course Name</th>
                <th>Section</th>
                <th>Course Title</th>
                <th>Credits</th>
                <th>Instructor</th>
            </tr>
        </thead>

        """),_display_(Seq[Any](/*22.10*/for(course <- courses) yield /*22.32*/ {_display_(Seq[Any](format.raw/*22.34*/("""
        <tr>
            <td>"""),_display_(Seq[Any](/*24.18*/course/*24.24*/.getGenFocus())),format.raw/*24.38*/("""</td>
            <td>"""),_display_(Seq[Any](/*25.18*/course/*25.24*/.getCourseNumber())),format.raw/*25.42*/("""</td>
            <td>"""),_display_(Seq[Any](/*26.18*/course/*26.24*/.getCourseName())),format.raw/*26.40*/("""</td>
            <td>"""),_display_(Seq[Any](/*27.18*/course/*27.24*/.getSection())),format.raw/*27.37*/("""</td>
            <td>"""),_display_(Seq[Any](/*28.18*/course/*28.24*/.getCourseTitle())),format.raw/*28.41*/("""</td>
            <td>"""),_display_(Seq[Any](/*29.18*/course/*29.24*/.getCredits())),format.raw/*29.37*/("""</td>
            <td>"""),_display_(Seq[Any](/*30.18*/course/*30.24*/.getInstructor())),format.raw/*30.40*/("""</td>
        </tr>
        """)))})),format.raw/*32.10*/("""
    </table>

    <h4 class="text-center">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Meeting example for CRN: 84935</h3>
            </div>
    </h4>

    <table class="table table-condensed">
        <thead>
            <tr>
                <th>Day</th>
                <th>Start</th>
                <th>End</th>
                <th>Room</th>
            </tr>
        </thead>
        """),_display_(Seq[Any](/*51.10*/for(meeting <- CourseDB.getCourse("84935").getMeeting()) yield /*51.66*/ {_display_(Seq[Any](format.raw/*51.68*/("""
        <tr>
            <td>"""),_display_(Seq[Any](/*53.18*/meeting/*53.25*/.getDay())),format.raw/*53.34*/("""</td>
            <td>"""),_display_(Seq[Any](/*54.18*/meeting/*54.25*/.getStart())),format.raw/*54.36*/("""</td>
            <td>"""),_display_(Seq[Any](/*55.18*/meeting/*55.25*/.getEnd())),format.raw/*55.34*/("""</td>
            <td>"""),_display_(Seq[Any](/*56.18*/meeting/*56.25*/.getRoom())),format.raw/*56.35*/("""</td>
        </tr>
        """)))})),format.raw/*58.10*/("""        
    </table>
</div>
""")))})),format.raw/*61.2*/("""
"""))}
    }
    
    def render(page:String,isLoggedIn:Boolean,courses:List[Course]): play.api.templates.HtmlFormat.Appendable = apply(page,isLoggedIn,courses)
    
    def f:((String,Boolean,List[Course]) => play.api.templates.HtmlFormat.Appendable) = (page,isLoggedIn,courses) => apply(page,isLoggedIn,courses)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Apr 13 20:27:53 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/Search.scala.html
                    HASH: aa85aadb602700ed4260318bc5306172c747f166
                    MATRIX: 796->1|947->58|984->60|1014->82|1053->84|1734->729|1772->751|1812->753|1881->786|1896->792|1932->806|1992->830|2007->836|2047->854|2107->878|2122->884|2160->900|2220->924|2235->930|2270->943|2330->967|2345->973|2384->990|2444->1014|2459->1020|2494->1033|2554->1057|2569->1063|2607->1079|2670->1110|3195->1599|3267->1655|3307->1657|3376->1690|3392->1697|3423->1706|3483->1730|3499->1737|3532->1748|3592->1772|3608->1779|3639->1788|3699->1812|3715->1819|3747->1829|3810->1860|3874->1893
                    LINES: 26->1|29->1|29->1|29->1|29->1|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|60->32|79->51|79->51|79->51|81->53|81->53|81->53|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|86->58|89->61
                    -- GENERATED --
                */
            
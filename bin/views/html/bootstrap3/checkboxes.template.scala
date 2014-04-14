
package views.html.bootstrap3

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
object checkboxes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Field,String,Map[String, Boolean],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(field: Field, label: String, checkboxMap: Map[String, Boolean]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.66*/("""

  <div class="checkbox form-group """),_display_(Seq[Any](/*3.36*/if(field.hasErrors)/*3.55*/ {_display_(Seq[Any](format.raw/*3.57*/("""has-error""")))})),format.raw/*3.67*/("""">
    <label class="col-sm-2 control-label" for=""""),_display_(Seq[Any](/*4.49*/field/*4.54*/.id)),format.raw/*4.57*/(""""><b>"""),_display_(Seq[Any](/*4.63*/label)),format.raw/*4.68*/("""</b></label>
    <div class="checkbox" style="margin-top:5px" id=""""),_display_(Seq[Any](/*5.55*/field/*5.60*/.id)),format.raw/*5.63*/("""">
      """),_display_(Seq[Any](/*6.8*/for((checkboxName, isChecked) <- checkboxMap) yield /*6.53*/ {_display_(Seq[Any](format.raw/*6.55*/("""
        <label class="checkbox-inline">
          <input
            type="checkbox"
            name=""""),_display_(Seq[Any](/*10.20*/(field.name + "[]"))),format.raw/*10.39*/(""""
            id=""""),_display_(Seq[Any](/*11.18*/checkboxName)),format.raw/*11.30*/(""""
            value=""""),_display_(Seq[Any](/*12.21*/checkboxName)),format.raw/*12.33*/(""""
            """),_display_(Seq[Any](/*13.14*/if(isChecked)/*13.27*/ {_display_(Seq[Any](format.raw/*13.29*/("""checked""")))})),format.raw/*13.37*/(""">
          """),_display_(Seq[Any](/*14.12*/checkboxName)),format.raw/*14.24*/("""
        </label>
      """)))})),format.raw/*16.8*/("""
      <span class="help-block">"""),_display_(Seq[Any](/*17.33*/{field.error.map { error => error.message }})),format.raw/*17.77*/("""</span>
    </div>
  </div>
"""))}
    }
    
    def render(field:Field,label:String,checkboxMap:Map[String, Boolean]): play.api.templates.HtmlFormat.Appendable = apply(field,label,checkboxMap)
    
    def f:((Field,String,Map[String, Boolean]) => play.api.templates.HtmlFormat.Appendable) = (field,label,checkboxMap) => apply(field,label,checkboxMap)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 18:14:38 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/bootstrap3/checkboxes.scala.html
                    HASH: f53c628b5ea059209dccf2429beaf8a5817d062b
                    MATRIX: 817->1|975->65|1049->104|1076->123|1115->125|1156->135|1243->187|1256->192|1280->195|1321->201|1347->206|1450->274|1463->279|1487->282|1532->293|1592->338|1631->340|1776->449|1817->468|1873->488|1907->500|1966->523|2000->535|2052->551|2074->564|2114->566|2154->574|2204->588|2238->600|2296->627|2366->661|2432->705
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|38->10|38->10|39->11|39->11|40->12|40->12|41->13|41->13|41->13|41->13|42->14|42->14|44->16|45->17|45->17
                    -- GENERATED --
                */
            
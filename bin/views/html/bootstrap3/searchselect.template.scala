
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
object searchselect extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[Field,String,String,Map[String, Boolean],Boolean,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(field: Field, id: String, searchType: String, optionMap: Map[String, Boolean], isMultiple: Boolean, onSelectFunction: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.128*/("""

      <select
        onchange=""""),_display_(Seq[Any](/*4.20*/onSelectFunction)),format.raw/*4.36*/(""""
        class="form-control"
        id=""""),_display_(Seq[Any](/*6.14*/id)),format.raw/*6.16*/(""""
        name=""""),_display_(Seq[Any](/*7.16*/if(isMultiple)/*7.30*/ {_display_(Seq[Any](_display_(Seq[Any](/*7.33*/(field.name + "[]")))))}/*7.54*/else/*7.59*/{_display_(Seq[Any](_display_(Seq[Any](/*7.61*/field/*7.66*/.name))))})),format.raw/*7.72*/(""""
        """),_display_(Seq[Any](/*8.10*/if(isMultiple)/*8.24*/ {_display_(Seq[Any](format.raw/*8.26*/("""multiple="multiple"""")))})),format.raw/*8.46*/(""">
        """),_display_(Seq[Any](/*9.10*/if(!isMultiple)/*9.25*/ {_display_(Seq[Any](format.raw/*9.27*/("""<option class="blank" value="">"""),_display_(Seq[Any](/*9.59*/searchType)),format.raw/*9.69*/("""</option>""")))})),format.raw/*9.79*/("""
        """),_display_(Seq[Any](/*10.10*/for((optionName, isSelected) <- optionMap) yield /*10.52*/ {_display_(Seq[Any](format.raw/*10.54*/("""
          <option id=""""),_display_(Seq[Any](/*11.24*/optionName)),format.raw/*11.34*/("""" value=""""),_display_(Seq[Any](/*11.44*/optionName)),format.raw/*11.54*/("""" """),_display_(Seq[Any](/*11.57*/if(isSelected)/*11.71*/ {_display_(Seq[Any](format.raw/*11.73*/("""selected""")))})),format.raw/*11.82*/(""">"""),_display_(Seq[Any](/*11.84*/optionName)),format.raw/*11.94*/("""</option>
        """)))})),format.raw/*12.10*/("""
      </select>
"""))}
    }
    
    def render(field:Field,id:String,searchType:String,optionMap:Map[String, Boolean],isMultiple:Boolean,onSelectFunction:String): play.api.templates.HtmlFormat.Appendable = apply(field,id,searchType,optionMap,isMultiple,onSelectFunction)
    
    def f:((Field,String,String,Map[String, Boolean],Boolean,String) => play.api.templates.HtmlFormat.Appendable) = (field,id,searchType,optionMap,isMultiple,onSelectFunction) => apply(field,id,searchType,optionMap,isMultiple,onSelectFunction)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 31 14:01:19 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/bootstrap3/searchselect.scala.html
                    HASH: dc6af927f575dfeb80d9af4b4d9e448379236fb1
                    MATRIX: 841->1|1062->127|1135->165|1172->181|1253->227|1276->229|1329->247|1351->261|1399->264|1431->285|1443->290|1490->292|1503->297|1534->303|1581->315|1603->329|1642->331|1693->351|1740->363|1763->378|1802->380|1869->412|1900->422|1941->432|1988->443|2046->485|2086->487|2147->512|2179->522|2225->532|2257->542|2296->545|2319->559|2359->561|2400->570|2438->572|2470->582|2522->602
                    LINES: 26->1|29->1|32->4|32->4|34->6|34->6|35->7|35->7|35->7|35->7|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12
                    -- GENERATED --
                */
            
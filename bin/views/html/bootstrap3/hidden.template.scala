
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
object hidden extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Field,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(field: Field):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""

  <div class="form-group """),_display_(Seq[Any](/*3.27*/if(field.hasErrors)/*3.46*/ {_display_(Seq[Any](format.raw/*3.48*/("""has-error""")))})),format.raw/*3.58*/("""">
    <div class="col-sm-10">
      <input type="hidden" 
             id=""""),_display_(Seq[Any](/*6.19*/field/*6.24*/.id)),format.raw/*6.27*/("""" 
             name=""""),_display_(Seq[Any](/*7.21*/field/*7.26*/.name)),format.raw/*7.31*/("""" 
             value=""""),_display_(Seq[Any](/*8.22*/field/*8.27*/.value)),format.raw/*8.33*/("""" />
    </div>
  </div>
  """))}
    }
    
    def render(field:Field): play.api.templates.HtmlFormat.Appendable = apply(field)
    
    def f:((Field) => play.api.templates.HtmlFormat.Appendable) = (field) => apply(field)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Apr 13 20:27:54 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/bootstrap3/hidden.scala.html
                    HASH: 04178f168fdff0a288492d319eb0d422930fef46
                    MATRIX: 785->1|893->15|958->45|985->64|1024->66|1065->76|1180->156|1193->161|1217->164|1276->188|1289->193|1315->198|1375->223|1388->228|1415->234
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8
                    -- GENERATED --
                */
            
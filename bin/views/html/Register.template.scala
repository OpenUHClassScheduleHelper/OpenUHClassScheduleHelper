
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
object Register extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),_display_(Seq[Any](/*3.2*/Main(page, false)/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""
    <div class="full col-sm-6 login-panel">
        <h4 class="text-center">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Sign Up For Access</h3>
                </div>
                <div class="panel-body">
                    <fieldset>
                        <div class="form-group" >
                            <input name="email" value="" class="form-control" placeholder="E-mail" type="text">
                        </div>
                        <div class="form-group" >
                            <input name="password" value="" class="form-control" placeholder="Password" type="password">
                        </div>
                        <input id="loginsubmit" class="btn btn-lg btn-primary btn-block" type="submit" value="Sign Up">
                    </fieldset>
                </div>
            </div>
        </h4>
    </div>
""")))})),format.raw/*24.2*/("""
"""))}
    }
    
    def render(page:String): play.api.templates.HtmlFormat.Appendable = apply(page)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (page) => apply(page)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 09:38:30 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/Register.scala.html
                    HASH: 869c9ccf81ddc212db8ea6657c84cc253886ea5e
                    MATRIX: 777->1|885->15|924->20|949->37|988->39|1986->1006
                    LINES: 26->1|29->1|31->3|31->3|31->3|52->24
                    -- GENERATED --
                */
            

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
object Login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),_display_(Seq[Any](/*3.2*/Main(page, false)/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""
  
<div id="wrap">
  <div class="col-sm-6 login-panel">
    <h4 class="text-center">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Student log in</h3>
        </div>
        <div class="panel-body">
          <fieldset>
            <div class="form-group">
              <input name="email" value="" class="form-control" placeholder="E-mail" type="text">
            </div>
            <div class="form-group">
              <input name="password" value="" class="form-control" placeholder="Password" type="password">
            </div>
            <a href=""""),_display_(Seq[Any](/*20.23*/routes/*20.29*/.Application.getResults())),format.raw/*20.54*/("""" > <input id="loginsubmit" class="btn btn-lg btn-success btn-block" type="submit"
              value="Login">
            </a>
          </fieldset>
        </div>
      </div>
    </h4>
  </div>

  <!-- /col-9 -->

  <!-- Empty div for spacing -->
  <div class="container">
    <div class="full col-md-12"></div>
  </div>
  
 
  <p style="text-align:center;"><a style="color:blue" href="instructorLogin.html">Instructors Login Here.</a></p>
 </div>
  
  <div id="footer">
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
      <a class="social-a" href="mailto:openUhScheduleHelper at hawaii.edu">
        <i class="fa fa-envelope-o"></i> Contact 
      </a>
    </p>
  </div>
</div>
""")))})),format.raw/*59.2*/("""
"""))}
    }
    
    def render(page:String): play.api.templates.HtmlFormat.Appendable = apply(page)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (page) => apply(page)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 09:38:30 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/Login.scala.html
                    HASH: 29c1d0e06fcbcd54c4e48da68c92091162d0a472
                    MATRIX: 774->1|882->15|921->20|946->37|985->39|1662->680|1677->686|1724->711|2893->1849
                    LINES: 26->1|29->1|31->3|31->3|31->3|48->20|48->20|48->20|87->59
                    -- GENERATED --
                */
            
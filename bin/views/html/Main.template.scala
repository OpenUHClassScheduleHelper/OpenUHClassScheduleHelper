
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
object Main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Boolean,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: String, isLoggedIn: Boolean)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.52*/("""

<!DOCTYPE html>

<html>
<head>
<title>"""),_display_(Seq[Any](/*7.9*/page)),format.raw/*7.13*/("""</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="http:////netdna.bootstrapcdn.com/bootswatch/3.0.0/spacelab/bootstrap.min.css">

<!--  Load site-specific customizations after bootstrap. -->
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*12.46*/routes/*12.52*/.Assets.at("stylesheets/main.css"))),format.raw/*12.86*/("""">
<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*13.51*/routes/*13.57*/.Assets.at("images/favicon.png"))),format.raw/*13.89*/("""">

<!-- Load Google Fonts -->
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Abel|Ubuntu">

<!-- social glyphicons -->
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
          <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
          <script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.2.0/respond.js"></script>
        <![endif]-->
</head>

<body>
  <!-- Responsive navbar -->
  <div class="navbar navbar-inverse" role="navigation">
    <div class="navbar-inner">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <!--  Display three horizontal lines when navbar collapsed. -->
            <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html"></a>
        </div>
        <div class="collapse navbar-collapse">
          """),_display_(Seq[Any](/*41.12*/if(isLoggedIn)/*41.26*/ {_display_(Seq[Any](format.raw/*41.28*/("""
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href=""""),_display_(Seq[Any](/*44.25*/routes/*44.31*/.Application.index())),format.raw/*44.51*/("""" 
                 style="color: """),_display_(Seq[Any](/*45.33*/if(page=="Results")/*45.52*/{_display_(Seq[Any](format.raw/*45.53*/("""black""")))}/*45.59*/else/*45.63*/{_display_(Seq[Any](format.raw/*45.64*/("""white""")))})),format.raw/*45.70*/(""";">Search
              </a>
            </li>
            <li>
              <a href=""""),_display_(Seq[Any](/*49.25*/routes/*49.31*/.Application.index())),format.raw/*49.51*/("""" 
                 style="color: """),_display_(Seq[Any](/*50.33*/if(page=="Campus Map")/*50.55*/{_display_(Seq[Any](format.raw/*50.56*/("""black""")))}/*50.62*/else/*50.66*/{_display_(Seq[Any](format.raw/*50.67*/("""white""")))})),format.raw/*50.73*/(""";">View Map
              </a>
            </li>
            <li>
              <a href=""""),_display_(Seq[Any](/*54.25*/routes/*54.31*/.Application.myAccount())),format.raw/*54.55*/("""" 
                 style="color: """),_display_(Seq[Any](/*55.33*/if(page=="My Account")/*55.55*/{_display_(Seq[Any](format.raw/*55.56*/("""black""")))}/*55.62*/else/*55.66*/{_display_(Seq[Any](format.raw/*55.67*/("""white""")))})),format.raw/*55.73*/(""";">My Account
              </a>
            </li>
            <li>
              <a href=""""),_display_(Seq[Any](/*59.25*/routes/*59.31*/.Application.index())),format.raw/*59.51*/("""" 
                 style="color: white">Sign Out
              </a>
            </li>
          </ul>
          """)))}/*64.13*/else/*64.18*/{_display_(Seq[Any](format.raw/*64.19*/("""
          <ul class="nav navbar-nav navbar-right">
            <li><a href=""""),_display_(Seq[Any](/*66.27*/routes/*66.33*/.Application.login())),format.raw/*66.53*/("""" style="color: white;">Sign In</a></li>
          </ul>
          """)))})),format.raw/*68.12*/("""
        </div>
      </div>
    </div>
  </div>  
  <!-- End Navbar -->
  
  """),_display_(Seq[Any](/*75.4*/content)),format.raw/*75.11*/("""
  
  <!-- Load Bootstrap JavaScript components. HTMLUnit (used in testing) requires JQuery 1.8.3 or below). -->
  <script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</body>
</html>
"""))}
    }
    
    def render(page:String,isLoggedIn:Boolean,content:Html): play.api.templates.HtmlFormat.Appendable = apply(page,isLoggedIn)(content)
    
    def f:((String,Boolean) => (Html) => play.api.templates.HtmlFormat.Appendable) = (page,isLoggedIn) => (content) => apply(page,isLoggedIn)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 09:38:30 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/Main.scala.html
                    HASH: d270e1fc2a0b95c6c81e69f3587ec21bb3b1697a
                    MATRIX: 786->1|930->51|1011->98|1036->102|1372->402|1387->408|1443->442|1533->496|1548->502|1602->534|2887->1783|2910->1797|2950->1799|3082->1895|3097->1901|3139->1921|3211->1957|3239->1976|3278->1977|3303->1983|3316->1987|3355->1988|3393->1994|3521->2086|3536->2092|3578->2112|3650->2148|3681->2170|3720->2171|3745->2177|3758->2181|3797->2182|3835->2188|3965->2282|3980->2288|4026->2312|4098->2348|4129->2370|4168->2371|4193->2377|4206->2381|4245->2382|4283->2388|4415->2484|4430->2490|4472->2510|4610->2630|4623->2635|4662->2636|4778->2716|4793->2722|4835->2742|4937->2812|5058->2898|5087->2905
                    LINES: 26->1|29->1|35->7|35->7|40->12|40->12|40->12|41->13|41->13|41->13|69->41|69->41|69->41|72->44|72->44|72->44|73->45|73->45|73->45|73->45|73->45|73->45|73->45|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|78->50|78->50|82->54|82->54|82->54|83->55|83->55|83->55|83->55|83->55|83->55|83->55|87->59|87->59|87->59|92->64|92->64|92->64|94->66|94->66|94->66|96->68|103->75|103->75
                    -- GENERATED --
                */
            
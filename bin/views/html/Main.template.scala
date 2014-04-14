
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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

<!--  Load site-specific customizations after bootstrap. -->
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*13.46*/routes/*13.52*/.Assets.at("stylesheets/main.css"))),format.raw/*13.86*/("""">
<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*14.51*/routes/*14.57*/.Assets.at("images/favicon.png"))),format.raw/*14.89*/("""">

<!-- Load Google Fonts -->
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Abel|Ubuntu">

<!-- social glyphicons -->
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
          <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
          <script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.2.0/respond.js"></script>
        <![endif]-->
        
<!-- Load Bootstrap JavaScript components. HTMLUnit (used in testing) requires JQuery 1.8.3 or below). -->
<script src=""""),_display_(Seq[Any](/*29.15*/routes/*29.21*/.Assets.at("lib/jquery.min.js"))),format.raw/*29.52*/(""""></script>
<script src=""""),_display_(Seq[Any](/*30.15*/routes/*30.21*/.Assets.at("lib/jquery-ui.custom.min.js"))),format.raw/*30.62*/(""""></script>
  <script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
  <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.min.js"></script>
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
  <script src=""""),_display_(Seq[Any](/*34.17*/controllers/*34.28*/.routes.Application.jsRoutes())),format.raw/*34.58*/("""" type="text/javascript"></script>        
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
          """),_display_(Seq[Any](/*50.12*/if(isLoggedIn)/*50.26*/ {_display_(Seq[Any](format.raw/*50.28*/("""
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href=""""),_display_(Seq[Any](/*53.25*/routes/*53.31*/.Application.getResults())),format.raw/*53.56*/("""" 
                 style="color: """),_display_(Seq[Any](/*54.33*/if(page=="Results")/*54.52*/{_display_(Seq[Any](format.raw/*54.53*/("""black""")))}/*54.59*/else/*54.63*/{_display_(Seq[Any](format.raw/*54.64*/("""white""")))})),format.raw/*54.70*/(""";">Search
              </a>
            </li>
            <li>
              <a href=""""),_display_(Seq[Any](/*58.25*/routes/*58.31*/.Application.map())),format.raw/*58.49*/("""" 
                 style="color: """),_display_(Seq[Any](/*59.33*/if(page=="Campus Map")/*59.55*/{_display_(Seq[Any](format.raw/*59.56*/("""black""")))}/*59.62*/else/*59.66*/{_display_(Seq[Any](format.raw/*59.67*/("""white""")))})),format.raw/*59.73*/(""";">Campus Map
              </a>
            </li>
            <li>
              <a href=""""),_display_(Seq[Any](/*63.25*/routes/*63.31*/.Application.myAccount())),format.raw/*63.55*/("""" 
                 style="color: """),_display_(Seq[Any](/*64.33*/if(page=="My Account")/*64.55*/{_display_(Seq[Any](format.raw/*64.56*/("""black""")))}/*64.62*/else/*64.66*/{_display_(Seq[Any](format.raw/*64.67*/("""white""")))})),format.raw/*64.73*/(""";">My Account
              </a>
            </li>
            <li>
              <a href=""""),_display_(Seq[Any](/*68.25*/routes/*68.31*/.Application.logout())),format.raw/*68.52*/("""" 
                 style="color: white">Sign Out
              </a>
            </li>
          </ul>
          """)))}/*73.13*/else/*73.18*/{_display_(Seq[Any](format.raw/*73.19*/("""
          <ul class="nav navbar-nav navbar-right">
            <li><a href=""""),_display_(Seq[Any](/*75.27*/routes/*75.33*/.Application.login())),format.raw/*75.53*/("""" style="color: white;">Sign In</a></li>
          </ul>
          """)))})),format.raw/*77.12*/("""
        </div>
      </div>
    </div>
  </div>  
  <!-- End Navbar -->
  
  """),_display_(Seq[Any](/*84.4*/content)),format.raw/*84.11*/("""
  
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
                    DATE: Sun Apr 13 20:27:52 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/Main.scala.html
                    HASH: 1f00c73319a774bb48bb5f6d0a4694e5462ab7d4
                    MATRIX: 786->1|930->51|1011->98|1036->102|1469->499|1484->505|1540->539|1630->593|1645->599|1699->631|2463->1359|2478->1365|2531->1396|2594->1423|2609->1429|2672->1470|2978->1740|2998->1751|3050->1781|3783->2478|3806->2492|3846->2494|3978->2590|3993->2596|4040->2621|4112->2657|4140->2676|4179->2677|4204->2683|4217->2687|4256->2688|4294->2694|4422->2786|4437->2792|4477->2810|4549->2846|4580->2868|4619->2869|4644->2875|4657->2879|4696->2880|4734->2886|4866->2982|4881->2988|4927->3012|4999->3048|5030->3070|5069->3071|5094->3077|5107->3081|5146->3082|5184->3088|5316->3184|5331->3190|5374->3211|5512->3331|5525->3336|5564->3337|5680->3417|5695->3423|5737->3443|5839->3513|5960->3599|5989->3606
                    LINES: 26->1|29->1|35->7|35->7|41->13|41->13|41->13|42->14|42->14|42->14|57->29|57->29|57->29|58->30|58->30|58->30|62->34|62->34|62->34|78->50|78->50|78->50|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|82->54|86->58|86->58|86->58|87->59|87->59|87->59|87->59|87->59|87->59|87->59|91->63|91->63|91->63|92->64|92->64|92->64|92->64|92->64|92->64|92->64|96->68|96->68|96->68|101->73|101->73|101->73|103->75|103->75|103->75|105->77|112->84|112->84
                    -- GENERATED --
                */
            
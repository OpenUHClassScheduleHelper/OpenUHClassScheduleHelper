
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
object Account extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[String,UserInfo,List[Course],List[Course],List[UserComment],Form[views.formdata.CommentFormData],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: String, 
  user : UserInfo, 
  schedule: List[Course], 
  watchList: List[Course], 
  comments: List[UserComment],  
  commentForm: Form[views.formdata.CommentFormData]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import bootstrap3._


Seq[Any](format.raw/*6.53*/("""

"""),format.raw/*10.1*/("""
"""),_display_(Seq[Any](/*11.2*/Main(page, true)/*11.18*/ {_display_(Seq[Any](format.raw/*11.20*/("""

<!-- FullCalendar Scripts and Style -->
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*14.31*/routes/*14.37*/.Assets.at("fullcalendar/fullcalendar.css"))),format.raw/*14.80*/("""">
<link rel="stylesheet" media="print" href=""""),_display_(Seq[Any](/*15.45*/routes/*15.51*/.Assets.at("fullcalendar/fullcalendar.print.css"))),format.raw/*15.100*/("""">
<script src=""""),_display_(Seq[Any](/*16.15*/routes/*16.21*/.Assets.at("lib/jquery.min.js"))),format.raw/*16.52*/(""""></script>
<script src=""""),_display_(Seq[Any](/*17.15*/routes/*17.21*/.Assets.at("lib/jquery-ui.custom.min.js"))),format.raw/*17.62*/(""""></script>
<script src=""""),_display_(Seq[Any](/*18.15*/routes/*18.21*/.Assets.at("fullcalendar/fullcalendar.min.js"))),format.raw/*18.67*/(""""></script>

<script>
$(document).ready(function() """),format.raw/*21.30*/("""{"""),format.raw/*21.31*/("""

    $('#calendar').fullCalendar("""),format.raw/*23.33*/("""{"""),format.raw/*23.34*/("""
        editable: true,
        header: false,              // remove header 
        allDaySlot: false,          // remove allday slot from top of calendar 
        slotEventOverlap: true,    // prevent overlapping events 
        minTime: 7,                 // Calendar starts at 7am
        maxTime: 21,                // Calendar ends at 9pm
        defaultView: 'agendaWeek',
        events: [
          """),_display_(Seq[Any](/*32.12*/for((course, courseIndex) <- schedule.zipWithIndex) yield /*32.63*/ {_display_(Seq[Any](format.raw/*32.65*/("""
        	  """),_display_(Seq[Any](/*33.13*/for((meeting, meetingIndex) <- course.getMeeting().zipWithIndex) yield /*33.77*/ {_display_(Seq[Any](format.raw/*33.79*/("""
        		"""),format.raw/*34.11*/("""{"""),format.raw/*34.12*/("""
                  title: '"""),_display_(Seq[Any](/*35.28*/course/*35.34*/.getCourseName())),format.raw/*35.50*/("""',
                  start: '"""),_display_(Seq[Any](/*36.28*/meeting/*36.35*/.getFullCalendarStartTime())),format.raw/*36.62*/("""',
                  end: '"""),_display_(Seq[Any](/*37.26*/meeting/*37.33*/.getFullCalendarEndTime())),format.raw/*37.58*/("""',
                  allDay: false
                """),format.raw/*39.17*/("""}"""),format.raw/*39.18*/("""
                """),_display_(Seq[Any](/*40.18*/if(courseIndex == schedule.length-1 && meetingIndex == course.getMeeting().length-1)/*40.102*/ {}/*40.106*/else/*40.111*/{_display_(Seq[Any](format.raw/*40.112*/(""",""")))})),format.raw/*40.114*/("""
        	  """)))})),format.raw/*41.13*/("""
          """)))})),format.raw/*42.12*/("""       

        ]
    """),format.raw/*45.5*/("""}"""),format.raw/*45.6*/(""");
"""),format.raw/*46.1*/("""}"""),format.raw/*46.2*/(""");
</script>

<script>
var calendar = $('#calendar');
calendar.fullCalendar("""),format.raw/*51.23*/("""{"""),format.raw/*51.24*/("""
    dayClick: function(date, allDay, jsEvent, view) """),format.raw/*52.53*/("""{"""),format.raw/*52.54*/("""
        calendar.fullCalendar('renderEvent', """),format.raw/*53.46*/("""{"""),format.raw/*53.47*/(""" title: 'YOUR TITLE', start: date, allDay: true """),format.raw/*53.95*/("""}"""),format.raw/*53.96*/(""", true );
    """),format.raw/*54.5*/("""}"""),format.raw/*54.6*/("""
"""),format.raw/*55.1*/("""}"""),format.raw/*55.2*/(""");
</script>
<!-- / FullCalendar Scripts and Style -->

<script>
function submitComment(id)
"""),format.raw/*61.1*/("""{"""),format.raw/*61.2*/("""
  document.getElementById('id').value=id;
  document.getElementById('comment').value=$('#text' + id).val();
  document.getElementById('hiddenCommentForm').submit();
"""),format.raw/*65.1*/("""}"""),format.raw/*65.2*/("""
</script>

<h2>Information</h2>
<p class="info">
  <b>Name: </b>"""),_display_(Seq[Any](/*70.17*/user/*70.21*/.getFullName())),format.raw/*70.35*/("""
</p>
<p class="info">
  <b>UH Username: </b>"""),_display_(Seq[Any](/*73.24*/user/*73.28*/.getUserName())),format.raw/*73.42*/("""
</p>

<!-- End Student Information Section -->

<!-- Begin Preferences Section -->
<h2>Notification Preferences</h2>
<form class="form-horizontal" role="form">
  <div class="form-group">
    <label class="col-sm-4 control-label">Receive updates by email:</label>
    <div class="col-sm-5">
      <select class="form-control">
        <option>Sign me up!</option>
        <option>Maybe next time.</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-4 control-label">Enter your phone number to receive updates by text:</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" placeholder="Telephone Number">
    </div>
  </div>
</form>
<!-- End Preferences Section -->

<!-- Hidden form to edit comment -->
"""),_display_(Seq[Any](/*100.2*/form(routes.Application.editComment(), 'id -> "hiddenCommentForm")/*100.68*/ {_display_(Seq[Any](format.raw/*100.70*/("""
  """),_display_(Seq[Any](/*101.4*/hidden(commentForm("id")))),format.raw/*101.29*/("""
  """),_display_(Seq[Any](/*102.4*/hidden(commentForm("comment")))),format.raw/*102.34*/("""
""")))})),format.raw/*103.2*/("""
  
<br>
<ul class="nav nav-tabs" data-tabs="tabs" style="margin-left: 10px; margin-right: 10px; margin-top: 10px;">
  <li class="active"><a data-toggle="tab" href="#Schedule">Schedule</a></li>
  <li><a data-toggle="tab" href="#WatchList">Watch List</a></li>
  <li><a data-toggle="tab" href="#Comments">Comments</a></li>
  <li><a data-toggle="tab" href="#ScheduleHistory">Schedule History</a></li>
</ul>

<div class="tab-content" style="margin-left: 10px; margin-right: 10px;">
  <div class="tab-pane active" id="Schedule">

    <h1>Current Schedule</h1>
    <div id='calendar'></div>

  </div>
  <div class="tab-pane" id="WatchList">
    <h1>Watch List</h1>
    <h3>Sprint 2014</h3>
    """),_display_(Seq[Any](/*123.6*/for(course <- watchList) yield /*123.30*/ {_display_(Seq[Any](format.raw/*123.32*/("""
    <div class="visible-sm visible-xs">
      <a class="btn course-dropdown-button" id="myclassbutton1"> """),_display_(Seq[Any](/*125.67*/course/*125.73*/.getCourseName())),format.raw/*125.89*/(""" """),_display_(Seq[Any](/*125.91*/course/*125.97*/.getCourseTitle())),format.raw/*125.114*/(""" </a>
      <div class="mobileresults" id="myclassinfo1">
        <p>
          <b>CRN: </b><br>"""),_display_(Seq[Any](/*128.28*/course/*128.34*/.getCourseNumber())),format.raw/*128.52*/("""
        </p>
        <hr></hr>
        <p>
          <b>Gen Ed./Focus: </b>"""),_display_(Seq[Any](/*132.34*/course/*132.40*/.getGenFocus())),format.raw/*132.54*/("""<br>
        </p>
        <hr></hr>
        <p>
          <b>Instructor: </b><br>"""),_display_(Seq[Any](/*136.35*/course/*136.41*/.getInstructor())),format.raw/*136.57*/("""
        </p>
        <hr></hr>
        """),_display_(Seq[Any](/*139.10*/for(meeting <- course.getMeeting()) yield /*139.45*/ {_display_(Seq[Any](format.raw/*139.47*/("""
        <p>
          <b>Location: </b><br>POST 127<br>POST 319
        </p>
        <hr></hr>
        <p>
          <b>Time: </b><br>M 0530-0800p<br> W 0530-0645p
        </p>
        <hr></hr>
        """)))})),format.raw/*148.10*/("""
        <p>
          <a type="button" class="btn btn-danger btn-xs glyphicon glyphicon-remove">
            Remove
          </a>
        </p>
      </div>
    </div>
    """)))})),format.raw/*156.6*/("""

    <table class="my-courses-table table-striped hidden-sm hidden-xs">
      <tr>
        <th>CRN</th>
        <th>Course</th>
        <th>Title</th>
        <th>Department</th>
        <th>Seats Avail</th>
        <th>Instructor</th>
        <th>Location</th>
        <th>Time</th>
        <th></th>
      </tr>
      """),_display_(Seq[Any](/*170.8*/for(course <- watchList) yield /*170.32*/ {_display_(Seq[Any](format.raw/*170.34*/("""
      <tr>
        <td>"""),_display_(Seq[Any](/*172.14*/course/*172.20*/.getCourseNumber())),format.raw/*172.38*/("""</td>
        <td>"""),_display_(Seq[Any](/*173.14*/course/*173.20*/.getCourseName())),format.raw/*173.36*/("""</td>
        <td>"""),_display_(Seq[Any](/*174.14*/course/*174.20*/.getCourseTitle())),format.raw/*174.37*/("""</td>
        <td>ICS</td>
        <td>0</td>
        <td>"""),_display_(Seq[Any](/*177.14*/course/*177.20*/.getInstructor())),format.raw/*177.36*/("""</td>
        <td>POST 127, POST 319</td>
        <td>M 0530-0800p, W 0530-0645p</td>
        <td>
          <div>
            <a class="btn btn-danger btn-sm" data-toggle="modal" href="#Course"""),_display_(Seq[Any](/*182.80*/course/*182.86*/.getCrn())),format.raw/*182.95*/(""""><div class="glyphicon glyphicon-remove"></div>Remove</a>
          </div>
        </td>
      </tr>
      """)))})),format.raw/*186.8*/("""
    </table>
  </div>

  <div class="tab-pane" id="Comments">
    <h1>Comments</h1>

    <table class="my-courses-table table-striped">
      <tr>
        <th>Date</th>
        <th>Course</th>
        <th>Comment</th>
        <th></th>
        <th></th>
        <th></th>
      </tr>
      """),_display_(Seq[Any](/*202.8*/for(comment <- comments) yield /*202.32*/ {_display_(Seq[Any](format.raw/*202.34*/("""
      <tr>
        <td>"""),_display_(Seq[Any](/*204.14*/comment/*204.21*/.getPostDate())),format.raw/*204.35*/("""</td>
        <td>"""),_display_(Seq[Any](/*205.14*/comment/*205.21*/.getCourseNumber())),format.raw/*205.39*/("""</td>
        <td>"""),_display_(Seq[Any](/*206.14*/comment/*206.21*/.getComment())),format.raw/*206.34*/("""</td>
        <td></td>
        <td>
          <td><a type="button" class="btn btn-primary btn-xs" data-toggle="modal" href="#editComment"""),_display_(Seq[Any](/*209.102*/comment/*209.109*/.getId())),format.raw/*209.117*/("""">Edit</a></td>
        </td>
        <td><a type="button" class="btn btn-danger btn-xs" data-toggle="modal" href="#deleteComment"""),_display_(Seq[Any](/*211.101*/comment/*211.108*/.getId())),format.raw/*211.116*/("""">Delete</a></td>
      </tr>
      """)))})),format.raw/*213.8*/("""
    </table>
  </div>
  
  <div class="tab-pane" id="ScheduleHistory">
    <h1>Schedule History</h1>
    <h3>Spring 2014</h3>
    <div class="visible-sm visible-xs">
      <a class="btn course-dropdown-button" id="myclassbutton4"> ICS 111 Intro to Computer Science I </a>
      <div class="mobileresults" id="myclassinfo4">
        <p>
          <b>CRN: </b><br>84935
        </p>
        <hr></hr>
        <p>
          <b>Gen Ed./Focus: </b><br>
        </p>
        <hr></hr>
        <p>
          <b>Instructor: </b><br>Ravi Narayan
        </p>
        <hr></hr>
        <p>
          <b>Location: </b><br>POST 127<br>POST 319
        </p>
        <hr></hr>
        <p>
          <b>Time: </b><br>M 0530-0800p<br> W 0530-0645p
        </p>
        <hr></hr>
      </div>
    </div>
    <table class="my-courses-table table-striped hidden-sm hidden-xs">
      <tr>
        <th>CRN</th>
        <th>Course</th>
        <th>Title</th>
        <th>Department</th>
        <th>Gen Ed./Focus</th>
        <th>Instructor</th>
        <th>Location</th>
        <th>Time</th>
      </tr>

      <tr>
        <td>84935</td>
        <td>ICS 111</td>
        <td>Intro to Computer Science I</td>
        <td>ICS</td>
        <td></td>
        <td>Ravi Narayan</td>
        <td>POST 127, POST 319</td>
        <td>M 0530-0800p, W 0530-0645p</td>
      </tr>
    </table>

    <h3>Fall 2013</h3>
    <div class="visible-sm visible-xs">
      <a class="btn course-dropdown-button" id="myclassbutton5"> ICS 111 Intro to Computer Science I </a>
      <div class="mobileresults" id="myclassinfo5">
        <p>
          <b>CRN: </b><br>84935
        </p>
        <hr></hr>
        <p>
          <b>Gen Ed./Focus: </b><br>
        </p>
        <hr></hr>
        <p>
          <b>Instructor: </b><br>Ravi Narayan
        </p>
        <hr></hr>
        <p>
          <b>Location: </b><br>POST 127<br>POST 319
        </p>
        <hr></hr>
        <p>
          <b>Time: </b><br>M 0530-0800p<br> W 0530-0645p
        </p>
        <hr></hr>
      </div>
    </div>

    <table class="my-courses-table table-striped hidden-sm hidden-xs">
      <tr>
        <th>CRN</th>
        <th>Course</th>
        <th>Title</th>
        <th>Department</th>
        <th>Gen Ed./Focus</th>
        <th>Instructor</th>
        <th>Location</th>
        <th>Time</th>
      </tr>

      <tr>
        <td>84935</td>
        <td>ICS 111</td>
        <td>Intro to Computer Science I</td>
        <td>ICS</td>
        <td></td>
        <td>Ravi Narayan</td>
        <td>POST 127, POST 319</td>
        <td>M 0530-0800p, W 0530-0645p</td>
      </tr>
    </table>

    <h3>Spring 2013</h3>
    <div class="visible-sm visible-xs">
      <a class="btn course-dropdown-button" id="myclassbutton6"> ICS 111 Intro to Computer Science I </a>
      <div class="mobileresults" id="myclassinfo6">
        <p>
          <b>CRN: </b><br>84935
        </p>
        <hr></hr>
        <p>
          <b>Gen Ed./Focus: </b><br>
        </p>
        <hr></hr>
        <p>
          <b>Instructor: </b><br>Ravi Narayan
        </p>
        <hr></hr>
        <p>
          <b>Location: </b><br>POST 127<br>POST 319
        </p>
        <hr></hr>
        <p>
          <b>Time: </b><br>M 0530-0800p<br> W 0530-0645p
        </p>
        <hr></hr>
      </div>
    </div>

    <table class="my-courses-table table-striped hidden-sm hidden-xs">
      <tr>
        <th>CRN</th>
        <th>Course</th>
        <th>Title</th>
        <th>Department</th>
        <th>Gen Ed./Focus</th>
        <th>Instructor</th>
        <th>Location</th>
        <th>Time</th>
      </tr>

      <tr>
        <td>84935</td>
        <td>ICS 111</td>
        <td>Intro to Computer Science I</td>
        <td>ICS</td>
        <td></td>
        <td>Ravi Narayan</td>
        <td>POST 127, POST 319</td>
        <td>M 0530-0800p, W 0530-0645p</td>
      </tr>
    </table>
  </div>

</div>

</div>

<div class="bottom-spacing"></div>
<!-- /main -->

<!-- Watchlist Modals -->

"""),_display_(Seq[Any](/*381.2*/for(course <- watchList) yield /*381.26*/ {_display_(Seq[Any](format.raw/*381.28*/("""
<div class="modal fade" id="Course"""),_display_(Seq[Any](/*382.36*/course/*382.42*/.getCrn())),format.raw/*382.51*/("""" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
      </div>
      <div class="modal-body">Are you sure you want to delete this course from your watchlist? This action cannot be undone.</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          <a id="modalconfirm"
             type="button" 
             class="btn btn-primary"
             href=""""),_display_(Seq[Any](/*395.21*/routes/*395.27*/.Application.deleteCourseFromWatchlist(course.getCrn()))),format.raw/*395.82*/("""">
             Delete
         </a>
      </div>
    </div>
  </div>
</div>
""")))})),format.raw/*402.2*/("""

<!-- Comment Modals -->
"""),_display_(Seq[Any](/*405.2*/for(comment <- comments) yield /*405.26*/ {_display_(Seq[Any](format.raw/*405.28*/("""

<!-- Edit Modal -->
<div class="modal fade" id="editComment"""),_display_(Seq[Any](/*408.41*/comment/*408.48*/.getId())),format.raw/*408.56*/("""" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Edit Your Comment</h4>
      </div>
      <div class="modal-body">
        <table>
          <tbody>
            <tr>
              <td><textarea id="text"""),_display_(Seq[Any](/*419.38*/comment/*419.45*/.getId())),format.raw/*419.53*/("""" style="width:500px;height:150px">"""),_display_(Seq[Any](/*419.89*/comment/*419.96*/.getComment())),format.raw/*419.109*/("""</textarea></td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
        <button id="submit" onclick="submitComment("""),_display_(Seq[Any](/*426.53*/comment/*426.60*/.getId())),format.raw/*426.68*/(""")" class="btn btn-primary" data-dismiss="modal">Save changes</button>
      </div>
      </form>
    </div>
  </div>
</div>

<!-- Delete Modal -->
<div class="modal fade" id="deleteComment"""),_display_(Seq[Any](/*434.43*/comment/*434.50*/.getId())),format.raw/*434.58*/("""" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
      </div>
      <div class="modal-body">Are you sure you want to delete this comment? This action cannot be undone.</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          <a id="modalconfirm"
             type="button" 
             class="btn btn-primary"
             href=""""),_display_(Seq[Any](/*447.21*/routes/*447.27*/.Application.deleteComment(comment.getId()))),format.raw/*447.70*/("""">
             Delete
         </a>
      </div>
    </div>
  </div>
</div>


""")))})),format.raw/*456.2*/("""

""")))})),format.raw/*458.2*/("""
"""))}
    }
    
    def render(page:String,user:UserInfo,schedule:List[Course],watchList:List[Course],comments:List[UserComment],commentForm:Form[views.formdata.CommentFormData]): play.api.templates.HtmlFormat.Appendable = apply(page,user,schedule,watchList,comments,commentForm)
    
    def f:((String,UserInfo,List[Course],List[Course],List[UserComment],Form[views.formdata.CommentFormData]) => play.api.templates.HtmlFormat.Appendable) = (page,user,schedule,watchList,comments,commentForm) => apply(page,user,schedule,watchList,comments,commentForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Apr 13 20:27:52 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/Account.scala.html
                    HASH: e73578b1102e4ff11ef1829098df6b9c32c3d4b2
                    MATRIX: 866->1|1180->182|1211->226|1249->229|1274->245|1314->247|1425->322|1440->328|1505->371|1589->419|1604->425|1676->474|1730->492|1745->498|1798->529|1861->556|1876->562|1939->603|2002->630|2017->636|2085->682|2167->736|2196->737|2260->773|2289->774|2745->1194|2812->1245|2852->1247|2902->1261|2982->1325|3022->1327|3062->1339|3091->1340|3156->1369|3171->1375|3209->1391|3276->1422|3292->1429|3341->1456|3406->1485|3422->1492|3469->1517|3550->1570|3579->1571|3634->1590|3728->1674|3741->1678|3755->1683|3795->1684|3830->1686|3876->1700|3921->1713|3974->1739|4002->1740|4033->1744|4061->1745|4170->1826|4199->1827|4281->1881|4310->1882|4385->1929|4414->1930|4490->1978|4519->1979|4561->1994|4589->1995|4618->1997|4646->1998|4771->2096|4799->2097|4996->2267|5024->2268|5131->2339|5144->2343|5180->2357|5265->2406|5278->2410|5314->2424|6153->3227|6229->3293|6270->3295|6311->3300|6359->3325|6400->3330|6453->3360|6488->3363|7233->4072|7274->4096|7315->4098|7461->4207|7477->4213|7516->4229|7555->4231|7571->4237|7612->4254|7749->4354|7765->4360|7806->4378|7924->4459|7940->4465|7977->4479|8100->4565|8116->4571|8155->4587|8236->4631|8288->4666|8329->4668|8576->4882|8790->5064|9162->5400|9203->5424|9244->5426|9308->5453|9324->5459|9365->5477|9422->5497|9438->5503|9477->5519|9534->5539|9550->5545|9590->5562|9689->5624|9705->5630|9744->5646|9980->5845|9996->5851|10028->5860|10173->5973|10517->6281|10558->6305|10599->6307|10663->6334|10680->6341|10717->6355|10774->6375|10791->6382|10832->6400|10889->6420|10906->6427|10942->6440|11121->6581|11139->6588|11171->6596|11341->6728|11359->6735|11391->6743|11462->6782|15661->10945|15702->10969|15743->10971|15817->11008|15833->11014|15865->11023|16645->11766|16661->11772|16739->11827|16856->11912|16922->11942|16963->11966|17004->11968|17106->12033|17123->12040|17154->12048|17683->12540|17700->12547|17731->12555|17804->12591|17821->12598|17858->12611|18154->12870|18171->12877|18202->12885|18436->13082|18453->13089|18484->13097|19245->13821|19261->13827|19327->13870|19448->13959|19485->13964
                    LINES: 26->1|37->6|39->10|40->11|40->11|40->11|43->14|43->14|43->14|44->15|44->15|44->15|45->16|45->16|45->16|46->17|46->17|46->17|47->18|47->18|47->18|50->21|50->21|52->23|52->23|61->32|61->32|61->32|62->33|62->33|62->33|63->34|63->34|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|68->39|68->39|69->40|69->40|69->40|69->40|69->40|69->40|70->41|71->42|74->45|74->45|75->46|75->46|80->51|80->51|81->52|81->52|82->53|82->53|82->53|82->53|83->54|83->54|84->55|84->55|90->61|90->61|94->65|94->65|99->70|99->70|99->70|102->73|102->73|102->73|129->100|129->100|129->100|130->101|130->101|131->102|131->102|132->103|152->123|152->123|152->123|154->125|154->125|154->125|154->125|154->125|154->125|157->128|157->128|157->128|161->132|161->132|161->132|165->136|165->136|165->136|168->139|168->139|168->139|177->148|185->156|199->170|199->170|199->170|201->172|201->172|201->172|202->173|202->173|202->173|203->174|203->174|203->174|206->177|206->177|206->177|211->182|211->182|211->182|215->186|231->202|231->202|231->202|233->204|233->204|233->204|234->205|234->205|234->205|235->206|235->206|235->206|238->209|238->209|238->209|240->211|240->211|240->211|242->213|410->381|410->381|410->381|411->382|411->382|411->382|424->395|424->395|424->395|431->402|434->405|434->405|434->405|437->408|437->408|437->408|448->419|448->419|448->419|448->419|448->419|448->419|455->426|455->426|455->426|463->434|463->434|463->434|476->447|476->447|476->447|485->456|487->458
                    -- GENERATED --
                */
            
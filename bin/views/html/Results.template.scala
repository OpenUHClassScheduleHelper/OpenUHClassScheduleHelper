
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
object Results extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template8[String,Map[String, Boolean],Map[String, Boolean],Map[String, Boolean],List[Course],Form[views.formdata.SearchForm],List[Course],List[ScheduleEvent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: String, focusList: Map[String, Boolean], dayList: Map[String, Boolean], departmentList: Map[String, Boolean], 
  resultsList: List[Course], searchForm : Form[views.formdata.SearchForm], schedule: List[Course], events: List[ScheduleEvent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper.form 

import bootstrap3._


Seq[Any](format.raw/*2.128*/("""
"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/Main(page, true)/*6.18*/ {_display_(Seq[Any](format.raw/*6.20*/("""

 <script type='text/javascript'>
            $(document).ready(function() """),format.raw/*9.42*/("""{"""),format.raw/*9.43*/(""" 

                $("#infoicon1").bind('fade-cycle', function() """),format.raw/*11.63*/("""{"""),format.raw/*11.64*/("""
                    $("#infoicon1").fadeIn('slow', function() """),format.raw/*12.63*/("""{"""),format.raw/*12.64*/("""
                        $("#infoicon1").fadeOut('slow', function() """),format.raw/*13.68*/("""{"""),format.raw/*13.69*/("""
                            $("#infoicon1").trigger('fade-cycle');
                        """),format.raw/*15.25*/("""}"""),format.raw/*15.26*/(""");
                    """),format.raw/*16.21*/("""}"""),format.raw/*16.22*/(""");
                """),format.raw/*17.17*/("""}"""),format.raw/*17.18*/(""");

                /*$("#infoicon1").bind('fade-cycle', function() """),format.raw/*19.65*/("""{"""),format.raw/*19.66*/("""
                 $("#infoicon1").fadeTo('slow',0.5, function() """),format.raw/*20.64*/("""{"""),format.raw/*20.65*/("""
                 $("#infoicon1").fadeTo('slow',1.0, function() """),format.raw/*21.64*/("""{"""),format.raw/*21.65*/("""
                 $("#infoicon1").trigger('fade-cycle');
                 """),format.raw/*23.18*/("""}"""),format.raw/*23.19*/(""");
                 """),format.raw/*24.18*/("""}"""),format.raw/*24.19*/(""");
                 """),format.raw/*25.18*/("""}"""),format.raw/*25.19*/(""");*/

                $('.infoicon').trigger('fade-cycle');
            """),format.raw/*28.13*/("""}"""),format.raw/*28.14*/(""");
        </script>


 <script type="text/javascript">
            $(document)
                    .ready(
                            function() """),format.raw/*35.40*/("""{"""),format.raw/*35.41*/("""
                                $("#slider-range").slider("""),format.raw/*36.59*/("""{"""),format.raw/*36.60*/("""
                                    range : true,
                                    min : 0,
                                    max : 1439,
                                    values : [ 420, 1200 ],
                                    slide : slideTime
                                """),format.raw/*42.33*/("""}"""),format.raw/*42.34*/(""");

                                function slideTime(event, ui) """),format.raw/*44.63*/("""{"""),format.raw/*44.64*/("""
                                    var val0 = $("#slider-range").slider(
                                            "values", 0), val1 = $(
                                            "#slider-range")
                                            .slider("values", 1), minutes0 = parseInt(
                                            val0 % 60, 10), hours0 = parseInt(
                                            val0 / 60 % 24, 10), minutes1 = parseInt(
                                            val1 % 60, 10), hours1 = parseInt(
                                            val1 / 60 % 24, 10);
                                    startTime = getTime(hours0, minutes0);
                                    endTime = getTime(hours1, minutes1);
                                    $("#time")
                                            .text(startTime + ' - ' + endTime);
                                    document.getElementById('startTime').value = startTime;
                                    document.getElementById('endTime').value = endTime;
                                """),format.raw/*59.33*/("""}"""),format.raw/*59.34*/("""

                                function getTime(hours, minutes) """),format.raw/*61.66*/("""{"""),format.raw/*61.67*/("""
                                    var time = null;
                                    minutes = minutes + "";
                                    if (hours < 12) """),format.raw/*64.53*/("""{"""),format.raw/*64.54*/("""
                                        time = "AM";
                                    """),format.raw/*66.37*/("""}"""),format.raw/*66.38*/(""" else """),format.raw/*66.44*/("""{"""),format.raw/*66.45*/("""
                                        time = "PM";
                                    """),format.raw/*68.37*/("""}"""),format.raw/*68.38*/("""
                                    if (hours == 0) """),format.raw/*69.53*/("""{"""),format.raw/*69.54*/("""
                                        hours = 12;
                                    """),format.raw/*71.37*/("""}"""),format.raw/*71.38*/("""
                                    if (hours > 12) """),format.raw/*72.53*/("""{"""),format.raw/*72.54*/("""
                                        hours = hours - 12;
                                    """),format.raw/*74.37*/("""}"""),format.raw/*74.38*/("""
                                    if (minutes.length == 1) """),format.raw/*75.62*/("""{"""),format.raw/*75.63*/("""
                                        minutes = "0" + minutes;
                                    """),format.raw/*77.37*/("""}"""),format.raw/*77.38*/("""
                                    return hours + ":" + minutes + " " + time;
                                """),format.raw/*79.33*/("""}"""),format.raw/*79.34*/("""

                                slideTime();
                            """),format.raw/*82.29*/("""}"""),format.raw/*82.30*/(""");
        </script>
        
<script type="text/javascript">
function getInstructorList() """),format.raw/*86.30*/("""{"""),format.raw/*86.31*/("""
	var deptIndex = document.getElementById("selDept").selectedIndex;
	var departmentList = document.getElementById("selDept").options;
	//alert(departmentList[deptIndex].text);
	appRoutes.controllers.Application.populateInstructorList(departmentList[deptIndex].text).ajax("""),format.raw/*90.96*/("""{"""),format.raw/*90.97*/("""
	  success: function(data) """),format.raw/*91.28*/("""{"""),format.raw/*91.29*/("""
	    //alert(data);
	    document.getElementById("selInstructor").innerHTML="<option>Any Instructor</option>" + data;
	  """),format.raw/*94.4*/("""}"""),format.raw/*94.5*/("""
	"""),format.raw/*95.2*/("""}"""),format.raw/*95.3*/(""")
"""),format.raw/*96.1*/("""}"""),format.raw/*96.2*/("""

function getCourseList() """),format.raw/*98.26*/("""{"""),format.raw/*98.27*/("""
    var courseIndex = document.getElementById("selDept").selectedIndex;
    var courseList = document.getElementById("selDept").options;
    //alert(departmentList[deptIndex].text);
    appRoutes.controllers.Application.populateCourseList(courseList[courseIndex].text).ajax("""),format.raw/*102.93*/("""{"""),format.raw/*102.94*/("""
      success: function(data) """),format.raw/*103.31*/("""{"""),format.raw/*103.32*/("""
        //alert(data);
        document.getElementById("selCourse").innerHTML="<option>Any Course</option>" + data;
      """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/("""
    """),format.raw/*107.5*/("""}"""),format.raw/*107.6*/(""")
"""),format.raw/*108.1*/("""}"""),format.raw/*108.2*/("""


</script>

<!-- FullCalendar Scripts and Style -->
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*114.31*/routes/*114.37*/.Assets.at("fullcalendar/fullcalendar.css"))),format.raw/*114.80*/("""">
<link rel="stylesheet" media="print" href=""""),_display_(Seq[Any](/*115.45*/routes/*115.51*/.Assets.at("fullcalendar/fullcalendar.print.css"))),format.raw/*115.100*/("""">
<script src=""""),_display_(Seq[Any](/*116.15*/routes/*116.21*/.Assets.at("fullcalendar/fullcalendar.min.js"))),format.raw/*116.67*/(""""></script>

<script>
$(document).ready(function() """),format.raw/*119.30*/("""{"""),format.raw/*119.31*/("""
    $('#calendar').fullCalendar("""),format.raw/*120.33*/("""{"""),format.raw/*120.34*/("""
        editable: false,            // prevent the user from editing events 
        header: false,              // remove header 
        allDaySlot: false,          // remove allday slot from top of calendar 
        slotEventOverlap: false,    // prevent overlapping events 
        minTime: 7,                 // Calendar starts at 7am 
        maxTime: 21,                // Calendar ends at 9pm 
        defaultView: 'agendaWeek',
        events: [
          """),_display_(Seq[Any](/*129.12*/for((course, courseIndex) <- schedule.zipWithIndex) yield /*129.63*/ {_display_(Seq[Any](format.raw/*129.65*/("""
              """),_display_(Seq[Any](/*130.16*/for((meeting, meetingIndex) <- course.getMeeting().zipWithIndex) yield /*130.80*/ {_display_(Seq[Any](format.raw/*130.82*/("""
                """),format.raw/*131.17*/("""{"""),format.raw/*131.18*/("""
                  title: '"""),_display_(Seq[Any](/*132.28*/course/*132.34*/.getCourseName())),format.raw/*132.50*/("""',
                  start: """),_display_(Seq[Any](/*133.27*/meeting/*133.34*/.getFullCalendarStartTime())),format.raw/*133.61*/(""",
                  end: """),_display_(Seq[Any](/*134.25*/meeting/*134.32*/.getFullCalendarEndTime())),format.raw/*134.57*/(""",
                  allDay: false
                """),format.raw/*136.17*/("""}"""),format.raw/*136.18*/("""
                """),_display_(Seq[Any](/*137.18*/if(courseIndex == schedule.length-1 && meetingIndex == course.getMeeting().length-1)/*137.102*/ {}/*137.106*/else/*137.111*/{_display_(Seq[Any](format.raw/*137.112*/(""",""")))})),format.raw/*137.114*/("""
              """)))})),format.raw/*138.16*/("""
          """)))})),format.raw/*139.12*/("""       
        ]
    """),format.raw/*141.5*/("""}"""),format.raw/*141.6*/(""");
"""),format.raw/*142.1*/("""}"""),format.raw/*142.2*/(""");
</script>

<script>
function AddEvent(crn) """),format.raw/*146.24*/("""{"""),format.raw/*146.25*/("""
  """),_display_(Seq[Any](/*147.4*/for(event<- events) yield /*147.23*/ {_display_(Seq[Any](format.raw/*147.25*/("""
    if (crn=='"""),_display_(Seq[Any](/*148.16*/event/*148.21*/.getId())),format.raw/*148.29*/("""') """),format.raw/*148.32*/("""{"""),format.raw/*148.33*/("""
        $('#calendar').fullCalendar('renderEvent', """),format.raw/*149.52*/("""{"""),format.raw/*149.53*/("""
            id: '"""),_display_(Seq[Any](/*150.19*/event/*150.24*/.getId())),format.raw/*150.32*/("""',
            title: '"""),_display_(Seq[Any](/*151.22*/event/*151.27*/.getTitle)),format.raw/*151.36*/("""',
            start: """),_display_(Seq[Any](/*152.21*/event/*152.26*/.getStart())),format.raw/*152.37*/(""",
            end: """),_display_(Seq[Any](/*153.19*/event/*153.24*/.getEnd())),format.raw/*153.33*/(""",
            allDay: false,
            textColor: 'black',
            borderColor: 'black',
            backgroundColor: '"""),_display_(Seq[Any](/*157.32*/event/*157.37*/.getBackgroundColor())),format.raw/*157.58*/("""'
        """),format.raw/*158.9*/("""}"""),format.raw/*158.10*/(""", true);
    """),format.raw/*159.5*/("""}"""),format.raw/*159.6*/("""
  """)))})),format.raw/*160.4*/("""
"""),format.raw/*161.1*/("""}"""),format.raw/*161.2*/("""
</script>


<script>
function RemoveEvent(id) """),format.raw/*166.26*/("""{"""),format.raw/*166.27*/("""
	if (id !== undefined)  """),format.raw/*167.25*/("""{"""),format.raw/*167.26*/("""
      $('#calendar').fullCalendar('removeEvents', id);
	"""),format.raw/*169.2*/("""}"""),format.raw/*169.3*/("""
"""),format.raw/*170.1*/("""}"""),format.raw/*170.2*/("""
</script>

<script>
$(document).ready(function()"""),format.raw/*174.29*/("""{"""),format.raw/*174.30*/("""
  $("tr").hover(function()"""),format.raw/*175.27*/("""{"""),format.raw/*175.28*/("""
      AddEvent( $(this).attr('id') );
    """),format.raw/*177.5*/("""}"""),format.raw/*177.6*/(""",function()"""),format.raw/*177.17*/("""{"""),format.raw/*177.18*/("""
      RemoveEvent($(this).attr('id'));
  """),format.raw/*179.3*/("""}"""),format.raw/*179.4*/(""");
"""),format.raw/*180.1*/("""}"""),format.raw/*180.2*/(""");
</script>

<!-- / FullCalendar Scripts and Style -->

 <!-- search form -->
  <div id="searchFormWrapper">
    <form class="form-inline" role="form">
      """),_display_(Seq[Any](/*188.8*/form(routes.Application.getResults(), 'class -> "form-group")/*188.69*/ {_display_(Seq[Any](format.raw/*188.71*/("""
      <div id="searchForm" class="form-group">
          """),_display_(Seq[Any](/*190.12*/searchselect(searchForm("department"), id = "selDept", searchType = "Any Department", optionMap = departmentList, isMultiple = false, "getInstructorList(); getCourseList();"))),format.raw/*190.186*/("""
          <select name="instructor" id="selInstructor" class="form-control" placeholder="Instructor" onchange="instructorsToCourses()">
            <option>Any Instructor</option>
          </select>
          <select name="course" id="selCourse" class="form-control" placeholder="Course Title" onchange="coursesToInstructors()">
            <option>Any Course</option>
          </select>               
      </div>
      """),_display_(Seq[Any](/*198.8*/checkboxes(searchForm("focus"), label = "Focus:", checkboxMap = focusList))),format.raw/*198.82*/("""
      <br>
      """),_display_(Seq[Any](/*200.8*/checkboxes(searchForm("days"), label = "Days:", checkboxMap = dayList))),format.raw/*200.78*/("""
      <div class="checkbox" style="margin-left:10px;padding-top:10px">
        <div id="slider-range"></div>
        <b>Time Range:<span id="time"></span></b>       
      </div>
      <input type='hidden' id= 'startTime' name='startTime' value='' />
      <input type='hidden' id= 'endTime' name='endTime' value='' />

      <button type="submit" class="btn btn-primary" style="margin-left:15px" onClick="submitForm()">Search</button>
    </form>
    """)))})),format.raw/*210.6*/("""
  </div>

  <!-- results -->
  <div>
    <h2 id="resultsHeader"><b>Results</b></h2>

    <div class="visible-sm visible-xs">
      <a class="btn course-dropdown-button" id="resultbutton1" onMouseOut="div.show('84935')"
        onMouseOver="div.hide('84935')"> ICS 111 Intro to Computer Science I </a>
      <div class="mobileresults" id="resultinfo1">
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
          <b>Time: </b><br>M 0530-0800p<br>W 0530-0645p
        </p>
        <hr></hr>
        <p></p>
      </div>

      <a class="btn course-dropdown-button" id="resultbutton2" onMouseOut="div.show('84095')"
        onMouseOver="div.hide('84095')"> ICS 142 Discrete Math for CS I </a>
      <div class="mobileresults" id="resultinfo2">
        <p>
          <b>CRN: </b><br>84095
        </p>
        <hr></hr>
        <p>
          <b>Gen Ed./Focus: </b><br>
        </p>
        <hr></hr>
        <p>
          <b>Instructor: </b><br>Kazuo Sugihara
        </p>
        <hr></hr>
        <p>
          <b>Location: </b><br>BIL 150<br>MSB 114
        </p>
        <hr></hr>
        <p>
          <b>Time: </b><br>TR 0130-0245p<br>F 1200-0115p
        </p>
        <hr></hr>
        <p>
          <a href="addclassresults.html"><button class="btn btn-success btn-sm">
              <div class="glyphicon glyphicon-plus"></div>
              Add To Schedule
            </button></a>
        </p>
      </div>

      <a class="btn course-dropdown-button" id="resultbutton3" onMouseOut="conflict.hide('84494')"
        onMouseOver="conflict.show('84494')"> ICS 212 Program Structure </a>
      <div class="mobileresults" id="resultinfo3">
        <p>
          <b>CRN: </b><br>84494
        </p>
        <hr></hr>
        <p>
          <b>Gen Ed./Focus: </b><br>
        </p>
        <hr></hr>
        <p>
          <b>Instructor: </b><br>Julia Patriarche
        </p>
        <hr></hr>
        <p>
          <b>Location: </b><br>TBA
        </p>
        <hr></hr>
        <p>
          <b>Time: </b><br>TBA
        </p>
        <hr></hr>
        <p>
          <button class="btn btn-success btn-sm">
            <div class="glyphicon glyphicon-plus"></div>
            Add To Schedule
          </button>
        </p>
      </div>
    </div>

"""),_display_(Seq[Any](/*307.2*/if(resultsList.size() == 0)/*307.29*/ {_display_(Seq[Any](format.raw/*307.31*/("""
<h3 id="resultsHeader">No Results</h3>
""")))}/*309.2*/else/*309.7*/{_display_(Seq[Any](format.raw/*309.8*/("""
    <table class="result-table hidden-sm hidden-xs">
      <tr class="tableheader">
        <th>CRN</th>
        <th>Course</th>
        <th>Title</th>
        <th>Department</th>
        <th>Gen Ed./Focus</th>
        <th>Instructor</th>
        <th>Location</th>
        <th>Time</th>
        <th></th>
      </tr>
      """),_display_(Seq[Any](/*322.8*/for(course <- resultsList) yield /*322.34*/ {_display_(Seq[Any](format.raw/*322.36*/("""
        <tr id=""""),_display_(Seq[Any](/*323.18*/course/*323.24*/.getCourseNumber())),format.raw/*323.42*/("""">
          <td>"""),_display_(Seq[Any](/*324.16*/course/*324.22*/.getCourseNumber())),format.raw/*324.40*/("""</td>
          <td>"""),_display_(Seq[Any](/*325.16*/course/*325.22*/.getCourseName())),format.raw/*325.38*/("""</td>
          <td>"""),_display_(Seq[Any](/*326.16*/course/*326.22*/.getCourseTitle)),format.raw/*326.37*/("""</td>
          <td>"""),_display_(Seq[Any](/*327.16*/course/*327.22*/.getDepartment())),format.raw/*327.38*/("""</td>
          <td>"""),_display_(Seq[Any](/*328.16*/course/*328.22*/.printGenFocusList())),format.raw/*328.42*/("""</td>
          <td>"""),_display_(Seq[Any](/*329.16*/course/*329.22*/.getInstructor())),format.raw/*329.38*/("""</td>
          <td>"""),_display_(Seq[Any](/*330.16*/for(meeting <- course.getMeeting()) yield /*330.51*/ {_display_(Seq[Any](format.raw/*330.53*/("""
              """),_display_(Seq[Any](/*331.16*/meeting/*331.23*/.getRoom())),format.raw/*331.33*/("""<br>
              """)))})),format.raw/*332.16*/("""</td>
          <td>"""),_display_(Seq[Any](/*333.16*/for(meeting <- course.getMeeting()) yield /*333.51*/ {_display_(Seq[Any](format.raw/*333.53*/("""
               """),_display_(Seq[Any](/*334.17*/meeting/*334.24*/.getDay())),format.raw/*334.33*/(""" """),_display_(Seq[Any](/*334.35*/meeting/*334.42*/.getStart())),format.raw/*334.53*/("""-"""),_display_(Seq[Any](/*334.55*/meeting/*334.62*/.getEnd())),format.raw/*334.71*/("""<br>
               """)))})),format.raw/*335.17*/("""</td>
          <td class="buttoncolumn">
          
          """),_display_(Seq[Any](/*338.12*/if(schedule.contains(course))/*338.41*/ {_display_(Seq[Any](format.raw/*338.43*/("""
          <button class="btn btn-success btn-sm added" title="Already Added">
            <div class="glyphicon glyphicon-plus" title="Already Added"></div>
          """)))}/*341.13*/else/*341.18*/{_display_(Seq[Any](format.raw/*341.19*/("""
            <a href=""""),_display_(Seq[Any](/*342.23*/routes/*342.29*/.Application.addCourseToSchedule(course.getCourseNumber()))),format.raw/*342.87*/("""">
            <button class="btn btn-success btn-sm" title="Add to Schedule">
            <div class="glyphicon glyphicon-plus" title="Add to Schedule"></div></button></a>
          """)))})),format.raw/*345.12*/("""
          </button> <img class="infoicon" id="infoicon"""),_display_(Seq[Any](/*346.56*/course/*346.62*/.getCourseNumber())),format.raw/*346.80*/("""" src=""""),_display_(Seq[Any](/*346.88*/routes/*346.94*/.Assets.at("images/more_information_icon.jpg"))),format.raw/*346.140*/("""" data-toggle="modal"
          data-target="#infomodal"""),_display_(Seq[Any](/*347.35*/course/*347.41*/.getCourseNumber())),format.raw/*347.59*/("""" title="Late Breaking News"></img>
          <img class="watchicon" src=""""),_display_(Seq[Any](/*348.40*/routes/*348.46*/.Assets.at("images/eye.svg"))),format.raw/*348.74*/("""" data-toggle="modal" data-target="#watchmodal"""),_display_(Seq[Any](/*348.121*/course/*348.127*/.getCourseNumber())),format.raw/*348.145*/(""""></img>
        </td>
        </tr>
      """)))})),format.raw/*351.8*/("""
      </table>
""")))})),format.raw/*353.2*/("""

  </div>
  <h2 id="schedule-header"><b>My Schedule</b></h2>
  <div id='calendar'></div>

  <!-- /main -->
  <div class="bottom-spacing"></div>
  
  """),_display_(Seq[Any](/*362.4*/for(course <- resultsList) yield /*362.30*/ {_display_(Seq[Any](format.raw/*362.32*/("""
  <div class="modal fade" id="infomodal"""),_display_(Seq[Any](/*363.41*/course/*363.47*/.getCourseNumber())),format.raw/*363.65*/("""">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
          <h4 class="modal-title"></h4>
        </div>
        <div class="modal-body">
          <h4>
            <b>Course Summary</b>
          </h4>
          <p>Overview of computer science, writing programs. Pre: Recommended: computer experience.</p>
          <br>
          <h4>
            <b>Late Breaking Information</b>
          </h4>
          """),_display_(Seq[Any](/*379.12*/for(comment <- UserCommentDB.getCommentsByCrn(course.getCourseNumber())) yield /*379.84*/ {_display_(Seq[Any](format.raw/*379.86*/("""
              <p>"""),_display_(Seq[Any](/*380.19*/comment/*380.26*/.getPostDate())),format.raw/*380.40*/(""" """),_display_(Seq[Any](/*380.42*/comment/*380.49*/.getFullName)),format.raw/*380.61*/(""": """),_display_(Seq[Any](/*380.64*/comment/*380.71*/.getComment())),format.raw/*380.84*/("""</p>
          """)))})),format.raw/*381.12*/("""
          <div id="messagebox" class="add-comment-area">
            <p>
              <b>New Message:</b>
            </p>
            <textarea rows="4" cols="50"></textarea>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" id="addmessage" class="btn btn-primary">Add Message</button>
        </div>
      </div>
      <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->
  """)))})),format.raw/*399.4*/("""
  
  
  """),_display_(Seq[Any](/*402.4*/for(course <- resultsList) yield /*402.30*/ {_display_(Seq[Any](format.raw/*402.32*/("""
  <div class="modal fade" id="watchmodal"""),_display_(Seq[Any](/*403.42*/course/*403.48*/.getCourseNumber())),format.raw/*403.66*/("""">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
          <h4 class="modal-title"></h4>
        </div>
        <div class="modal-body">
          <h4><b>Add this class to your watch list?</b></h4>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <a href=""""),_display_(Seq[Any](/*416.21*/routes/*416.27*/.Application.addCourseToWatchlist(course.getCourseNumber()))),format.raw/*416.86*/(""""><button type="button" class="btn btn-primary">Add</button></a>
        </div>
      </div>
      <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
  </div>
  <!-- /.modal --> 
  
  """)))})),format.raw/*425.4*/("""
  

  <div class="modal fade" id="infomodal2">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
          <h4 class="modal-title"></h4>
        </div>
        <div class="modal-body">
          <h4>
            <b>Course Summary</b>
          </h4>
          <p>Logic, sets, functions, matrices, algorithmic concepts, mathematical reasoning, recursion, counting
            techniques, probability theory.</p>
          <br>
          <h4>
            <b>Late Breaking Information</b>
          </h4>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Add Message</button>
        </div>
      </div>
      <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->

  <div class="modal fade" id="infomodal3">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
          <h4 class="modal-title"></h4>
        </div>
        <div class="modal-body">
          <h4>
            <b>Course Summary</b>
          </h4>
          <p>Program organization paradigms, programming environments, implementation of a module from
            specifications, the C and C++ programming languages. Pre: 211 or consent.</p>
          <br>
          <h4>
            <b>Late Breaking Information</b>
          </h4>
          <p class="professor-new-info">12/10/14 Julia Patriarche: This class will be conducted as an online course.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Add Message</button>
        </div>
      </div>
      <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->

  <div class="modal fade" id="watchmodal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
          <h4 class="modal-title"></h4>
        </div>
        <div class="modal-body">
          <h4><b>Add this class to your watch list?</b></h4>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Add</button>
        </div>
      </div>
      <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
  </div>
  <!-- /.modal --> 
  
  <div class="modal fade" id="advModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
        </div>
        <div class="modal-body">
          <h4 class="modal-title" id="myModalLabel">
            <b>Advanced Search</b>
          </h4>
          <br> <select class="form-control" placeholder="Department">
            <option>Select your Department</option>
            <option>Academy for Creative Media (ACM)</option>
            <option>Accounting (ACC)</option>
            <option>Aerospace Studies (AS)</option>
            <option>...</option>
            <option>Information & Computer Science (ICS)</option>
          </select> <br> <select class="form-control" placeholder="Course Title">
            <option>Course Title</option>
            <option>Intro to CS I (ICS 111)</option>
            <option>Discrete Math for CS I (ICS 141)</option>
            <option>Intro to CS II (ICS 211)</option>
            <option>...</option>
            <option>Topcs in Software (ICS 691)</option>
          </select> <br> <label><b>Days:</b></label> <br> <label class="checkbox-inline"> <input
            type="checkbox" id="inlineCheckbox1" value="option1" style=""> Sunday
          </label> <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox1" value="option1" style="">
            Monday
          </label> <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox1" value="option1" style="">
            Tuesday
          </label> <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox1" value="option1" style="">
            Wednesday
          </label> <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox1" value="option1" style="">
            Thursday
          </label> <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox1" value="option1" style="">
            Friday
          </label> <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox1" value="option1" style="">
            Saturday
          </label> <br> <br> <label><b>Time Range:</b></label> <br> <b><span id="time"></span></b>
          <div id="slider-range"></div>
          <br> <label style="margin-right: 2px;"><b>Focus</b>: </label> <label class="checkbox-inline"> <input
            type="checkbox" id="inlineCheckbox1" value="option1" style=""> ETH
          </label> <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox1" value="option1" style="">
            HAP
          </label> <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox1" value="option1" style="">
            OC
          </label> <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox1" value="option1" style="">
            WI
          </label> <br>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <!-- both buttons close modal for now -->
          <button type="button" class="btn btn-success" data-dismiss="modal">Search</button>
        </div>
      </div>
    </div>
  </div>


""")))})))}
    }
    
    def render(page:String,focusList:Map[String, Boolean],dayList:Map[String, Boolean],departmentList:Map[String, Boolean],resultsList:List[Course],searchForm:Form[views.formdata.SearchForm],schedule:List[Course],events:List[ScheduleEvent]): play.api.templates.HtmlFormat.Appendable = apply(page,focusList,dayList,departmentList,resultsList,searchForm,schedule,events)
    
    def f:((String,Map[String, Boolean],Map[String, Boolean],Map[String, Boolean],List[Course],Form[views.formdata.SearchForm],List[Course],List[ScheduleEvent]) => play.api.templates.HtmlFormat.Appendable) = (page,focusList,dayList,departmentList,resultsList,searchForm,schedule,events) => apply(page,focusList,dayList,departmentList,resultsList,searchForm,schedule,events)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Apr 13 20:27:53 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/Results.scala.html
                    HASH: a5e81376d04c95acaa0dfab84f9de6b8f62effc5
                    MATRIX: 917->1|1301->247|1329->293|1366->296|1390->312|1429->314|1535->393|1563->394|1658->461|1687->462|1779->526|1808->527|1905->596|1934->597|2056->691|2085->692|2137->716|2166->717|2214->737|2243->738|2341->808|2370->809|2463->874|2492->875|2585->940|2614->941|2718->1017|2747->1018|2796->1039|2825->1040|2874->1061|2903->1062|3006->1137|3035->1138|3217->1292|3246->1293|3334->1353|3363->1354|3687->1650|3716->1651|3812->1719|3841->1720|4971->2822|5000->2823|5097->2892|5126->2893|5323->3062|5352->3063|5472->3155|5501->3156|5535->3162|5564->3163|5684->3255|5713->3256|5795->3310|5824->3311|5943->3402|5972->3403|6054->3457|6083->3458|6210->3557|6239->3558|6330->3621|6359->3622|6491->3726|6520->3727|6662->3841|6691->3842|6797->3920|6826->3921|6949->4016|6978->4017|7281->4292|7310->4293|7367->4322|7396->4323|7548->4448|7576->4449|7606->4452|7634->4453|7664->4456|7692->4457|7749->4486|7778->4487|8086->4766|8116->4767|8177->4799|8207->4800|8361->4926|8390->4927|8424->4933|8453->4934|8484->4937|8513->4938|8640->5028|8656->5034|8722->5077|8807->5125|8823->5131|8896->5180|8951->5198|8967->5204|9036->5250|9119->5304|9149->5305|9212->5339|9242->5340|9755->5816|9823->5867|9864->5869|9918->5886|9999->5950|10040->5952|10087->5970|10117->5971|10183->6000|10199->6006|10238->6022|10305->6052|10322->6059|10372->6086|10436->6113|10453->6120|10501->6145|10582->6197|10612->6198|10668->6217|10763->6301|10777->6305|10792->6310|10833->6311|10869->6313|10919->6330|10965->6343|11017->6367|11046->6368|11078->6372|11107->6373|11186->6423|11216->6424|11257->6429|11293->6448|11334->6450|11388->6467|11403->6472|11434->6480|11466->6483|11496->6484|11578->6537|11608->6538|11665->6558|11680->6563|11711->6571|11773->6596|11788->6601|11820->6610|11881->6634|11896->6639|11930->6650|11988->6671|12003->6676|12035->6685|12202->6815|12217->6820|12261->6841|12300->6852|12330->6853|12372->6867|12401->6868|12438->6873|12468->6875|12497->6876|12578->6928|12608->6929|12663->6955|12693->6956|12780->7015|12809->7016|12839->7018|12868->7019|12950->7072|12980->7073|13037->7101|13067->7102|13140->7147|13169->7148|13209->7159|13239->7160|13311->7204|13340->7205|13372->7209|13401->7210|13605->7378|13676->7439|13717->7441|13815->7502|14013->7676|14483->8110|14580->8184|14637->8205|14730->8275|15226->8739|17909->11386|17946->11413|17987->11415|18049->11458|18062->11463|18101->11464|18475->11802|18518->11828|18559->11830|18615->11849|18631->11855|18672->11873|18728->11892|18744->11898|18785->11916|18844->11938|18860->11944|18899->11960|18958->11982|18974->11988|19012->12003|19071->12025|19087->12031|19126->12047|19185->12069|19201->12075|19244->12095|19303->12117|19319->12123|19358->12139|19417->12161|19469->12196|19510->12198|19564->12215|19581->12222|19614->12232|19668->12253|19727->12275|19779->12310|19820->12312|19875->12330|19892->12337|19924->12346|19963->12348|19980->12355|20014->12366|20053->12368|20070->12375|20102->12384|20157->12406|20261->12473|20300->12502|20341->12504|20533->12677|20547->12682|20587->12683|20648->12707|20664->12713|20745->12771|20965->12958|21059->13015|21075->13021|21116->13039|21161->13047|21177->13053|21247->13099|21341->13156|21357->13162|21398->13180|21511->13256|21527->13262|21578->13290|21663->13337|21680->13343|21722->13361|21801->13408|21852->13427|22048->13587|22091->13613|22132->13615|22211->13657|22227->13663|22268->13681|22880->14256|22969->14328|23010->14330|23067->14350|23084->14357|23121->14371|23160->14373|23177->14380|23212->14392|23252->14395|23269->14402|23305->14415|23355->14432|23964->15009|24013->15022|24056->15048|24097->15050|24177->15093|24193->15099|24234->15117|24796->15642|24812->15648|24894->15707|25133->15914
                    LINES: 26->1|33->2|34->5|35->6|35->6|35->6|38->9|38->9|40->11|40->11|41->12|41->12|42->13|42->13|44->15|44->15|45->16|45->16|46->17|46->17|48->19|48->19|49->20|49->20|50->21|50->21|52->23|52->23|53->24|53->24|54->25|54->25|57->28|57->28|64->35|64->35|65->36|65->36|71->42|71->42|73->44|73->44|88->59|88->59|90->61|90->61|93->64|93->64|95->66|95->66|95->66|95->66|97->68|97->68|98->69|98->69|100->71|100->71|101->72|101->72|103->74|103->74|104->75|104->75|106->77|106->77|108->79|108->79|111->82|111->82|115->86|115->86|119->90|119->90|120->91|120->91|123->94|123->94|124->95|124->95|125->96|125->96|127->98|127->98|131->102|131->102|132->103|132->103|135->106|135->106|136->107|136->107|137->108|137->108|143->114|143->114|143->114|144->115|144->115|144->115|145->116|145->116|145->116|148->119|148->119|149->120|149->120|158->129|158->129|158->129|159->130|159->130|159->130|160->131|160->131|161->132|161->132|161->132|162->133|162->133|162->133|163->134|163->134|163->134|165->136|165->136|166->137|166->137|166->137|166->137|166->137|166->137|167->138|168->139|170->141|170->141|171->142|171->142|175->146|175->146|176->147|176->147|176->147|177->148|177->148|177->148|177->148|177->148|178->149|178->149|179->150|179->150|179->150|180->151|180->151|180->151|181->152|181->152|181->152|182->153|182->153|182->153|186->157|186->157|186->157|187->158|187->158|188->159|188->159|189->160|190->161|190->161|195->166|195->166|196->167|196->167|198->169|198->169|199->170|199->170|203->174|203->174|204->175|204->175|206->177|206->177|206->177|206->177|208->179|208->179|209->180|209->180|217->188|217->188|217->188|219->190|219->190|227->198|227->198|229->200|229->200|239->210|336->307|336->307|336->307|338->309|338->309|338->309|351->322|351->322|351->322|352->323|352->323|352->323|353->324|353->324|353->324|354->325|354->325|354->325|355->326|355->326|355->326|356->327|356->327|356->327|357->328|357->328|357->328|358->329|358->329|358->329|359->330|359->330|359->330|360->331|360->331|360->331|361->332|362->333|362->333|362->333|363->334|363->334|363->334|363->334|363->334|363->334|363->334|363->334|363->334|364->335|367->338|367->338|367->338|370->341|370->341|370->341|371->342|371->342|371->342|374->345|375->346|375->346|375->346|375->346|375->346|375->346|376->347|376->347|376->347|377->348|377->348|377->348|377->348|377->348|377->348|380->351|382->353|391->362|391->362|391->362|392->363|392->363|392->363|408->379|408->379|408->379|409->380|409->380|409->380|409->380|409->380|409->380|409->380|409->380|409->380|410->381|428->399|431->402|431->402|431->402|432->403|432->403|432->403|445->416|445->416|445->416|454->425
                    -- GENERATED --
                */
            
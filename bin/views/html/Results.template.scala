
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
object Results extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""


"""),_display_(Seq[Any](/*4.2*/Main(page, true)/*4.18*/ {_display_(Seq[Any](format.raw/*4.20*/("""

 <!-- search form -->
  <div id="searchFormWrapper">
    <form class="form-inline" role="form">
      <div id="searchForm" class="form-group">
          <select id="selDept" class="form-control" placeholder="Department">
            <option>Department</option>
            <option>Academy for Creative Media (ACM)</option>
            <option>Accounting (ACC)</option>
            <option>Aerospace Studies (AS)</option>
            <option>...</option>
            <option>Information & Computer Science (ICS)</option>
          </select>
          <select id="selInstructor" class="form-control" placeholder="Instructor">
            <option>Instructor</option>
            <option>Baek, Kyungim</option>
            <option>Binsted, Kimberly</option>
            <option>Endicott, Barbara</option>
            <option>Johnson, Philip</option>
            <option>...</option>
            <option>Sugihara, Kazuo</option>
          </select>
          <select id="selCourse" class="form-control" placeholder="Course Title">
            <option>Course Title</option>
            <option>Intro to CS I (ICS 111)</option>
            <option>Discrete Math for CS I (ICS 141)</option>
            <option>Intro to CS II (ICS 211)</option>
            <option>...</option>
            <option>Topics in Software (ICS 691)</option>
          </select>               
      </div>
      <div class="checkbox" style="margin-left:5px">
          <label><b>Focus</b>: </label>
          <label><input type="checkbox"> ETH </label>
          <label><input type="checkbox"> HAP </label>
          <label><input type="checkbox"> OC </label>
          <label><input type="checkbox"> WI </label>
      </div>
      <br>
      <div class="checkbox" style="margin-top:5px">
          <label><b>Days</b>: </label>
          <label><input type="checkbox"> M </label>
          <label><input type="checkbox"> Tu </label>
          <label><input type="checkbox"> W </label>
          <label><input type="checkbox"> Th </label>
          <label><input type="checkbox"> F </label>
          <label><input type="checkbox"> Sa </label>
          <label><input type="checkbox"> Su </label>          
      </div>
      <div class="checkbox" style="margin-left:10px;padding-top:10px">
        <div id="slider-range"></div>
        <b>Time Range:<span id="time"></span></b>       
      </div>
      <button type="submit" class="btn btn-primary" style="margin-left:15px">Search</button>
    </form>
  </div>

  <!-- results -->
  <div>
    <h2 id="resultsHeader">Results</h2>

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

      <tr id="84935" onMouseOut="div.hide('84935')" onMouseOver="div.show('84935')">
        <td><a id="classinfobutton1">84935</a></td>
        <td>ICS 111</td>
        <td>Intro to Computer Science I</td>
        <td>ICS</td>
        <td></td>
        <td>Ravi Narayan</td>
        <td>POST 127, POST 319</td>
        <td>MW 0730-0820a</td>
        <td class="buttoncolumn">
          <button class="btn btn-success btn-sm added" title="Already Added">
            <div class="glyphicon glyphicon-plus" title="Already Added"></div>
          </button> <img class="infoicon" id="infoicon1" src="more_information_icon.jpg" data-toggle="modal"
          data-target="#infomodal1" title="Late Breaking News"></img>
          <img class="watchicon" src="eye.svg" data-toggle="modal" data-target="#watchmodal"></img>
        </td>
      </tr>


      <tr id="84095" onMouseOut="div.hide('84095')" onMouseOver="div.show('84095')">
        <td><a id="classinfobutton2">84095</a></td>
        <td>ICS 141</td>
        <td>Discrete Math for CS I</td>
        <td>ICS</td>
        <td></td>
        <td>Kazuo Sugihara</td>
        <td>BIL 150, MSB 114</td>
        <td>TR 0130-0220p</td>
        <td class="buttoncolumn"><a href="addclassresults.html"><button class="btn btn-success btn-sm"
              title="Add to Schedule">
              <div class="glyphicon glyphicon-plus" title="Add to Schedule"></div>
            </button></a> <img class="infoicon" src="more_information_icon.jpg" data-toggle="modal" data-target="#infomodal2"
          title="Late Breaking News"></img>
          <img class="watchicon" src="eye.svg" data-toggle="modal" data-target="#watchmodal"></img>
          </td>
      </tr>


      <tr id="84494" onMouseOut="conflict.hide('84494')" onMouseOver="conflict.show('84494')">
        <td><a id="classinfobutton3">84494</a></td>
        <td>ICS 212</td>
        <td>Program Structure</td>
        <td>ICS</td>
        <td></td>
        <td>Julia Patriarche</td>
        <td>TBA</td>
        <td>MW 1130-1220p</td>
        <td class="buttoncolumn"><a href="addclassresults.html"><button class="btn btn-success btn-sm"
              title="Add to Schedule">
              <div class="glyphicon glyphicon-plus" title="Add to Schedule"></div>
            </button></a> <img class="infoicon" src="more_information_icon.jpg" data-toggle="modal" data-target="#infomodal3"
          title="Late Breaking News"></img>
          <img class="watchicon" src="eye.svg" data-toggle="modal" data-target="#watchmodal"></img>
          </td>
      </tr>


    </table>

  </div>
  <h2>My Schedule</h2>

  <div class="table-responsive" style="margin-left: 10px; margin-right: 10px;">
    <table class="table table-bordered table-striped">
      <thead>
        <tr id="conflict-alert" style="display: none; background-color: #F58E9D;">
          <td colspan="6">Conflict Exists</td>
        </tr>
        <tr>
          <th>Time</th>
          <th>Monday</th>
          <th>Tuesday</th>
          <th>Wednesday</th>
          <th>Thursday</th>
          <th>Friday</th>
        </tr>
      </thead>

      <tbody>
        <tr>
          <td>7:30-8:20</td>
          <td id="tempCell" name="84935">ICS111</td>
          <!-- Monday -->
          <td></td>
          <!-- Tuesday -->
          <td id="tempCell" name="84935">ICS111</td>
          <!-- Wednesday -->
          <td></td>
          <!-- Thursday -->
          <td></td>
          <!-- Friday -->
        </tr>
        <tr>
          <td>8:30-9:20</td>
          <td></td>
          <!-- Monday -->
          <td></td>
          <!-- Tuesday -->
          <td></td>
          <!-- Wednesday -->
          <td></td>
          <!-- Thursday -->
          <td></td>
          <!-- Friday -->
        </tr>
        <tr>
          <td>9:30-10:20</td>
          <td>ICS211</td>
          <!-- Monday -->
          <td></td>
          <!-- Tuesday -->
          <td>ICS211</td>
          <!-- Wednesday -->
          <td></td>
          <!-- Thursday -->
          <td></td>
          <!-- Friday -->
        </tr>
        <tr>
          <td>10:30-11:20</td>
          <td></td>
          <!-- Monday -->
          <td>ENG111</td>
          <!-- Tuesday -->
          <td></td>
          <!-- Wednesday -->
          <td>ENG111</td>
          <!-- Thursday -->
          <td></td>
          <!-- Friday -->
        </tr>
        <tr>
          <td>11:30-12:20</td>
          <td name="84494">MATH242</td>
          <!-- Monday -->
          <td></td>
          <!-- Tuesday -->
          <td name="84494">MATH242</td>
          <!-- Wednesday -->
          <td></td>
          <!-- Thursday -->
          <td></td>
          <!-- Friday -->
        </tr>
        <tr>
          <td>12:30-1:20</td>
          <td></td>
          <!-- Monday -->
          <td></td>
          <!-- Tuesday -->
          <td></td>
          <!-- Wednesday -->
          <td></td>
          <!-- Thursday -->
          <td></td>
          <!-- Friday -->
        </tr>
        <tr>
          <td>1:30-2:20</td>
          <td></td>
          <!-- Monday -->
          <td id="tempCell" name="84095">ICS141</td>
          <!-- Tuesday -->
          <td></td>
          <!-- Wednesday -->
          <td id="tempCell" name="84095">ICS141</td>
          <!-- Thursday -->
          <td></td>
          <!-- Friday -->
        </tr>
        <tr>
          <td>2:30-3:20</td>
          <td></td>
          <!-- Monday -->
          <td></td>
          <!-- Tuesday -->
          <td></td>
          <!-- Wednesday -->
          <td></td>
          <!-- Thursday -->
          <td></td>
          <!-- Friday -->
        </tr>
        <tr>
          <td>3:30-4:20</td>
          <td></td>
          <!-- Monday -->
          <td></td>
          <!-- Tuesday -->
          <td></td>
          <!-- Wednesday -->
          <td></td>
          <!-- Thursday -->
          <td></td>
          <!-- Friday -->
        </tr>
        <tr>
          <td>4:30-5:20</td>
          <td></td>
          <!-- Monday -->
          <td></td>
          <!-- Tuesday -->
          <td></td>
          <!-- Wednesday -->
          <td></td>
          <!-- Thursday -->
          <td></td>
          <!-- Friday -->
        </tr>
      </tbody>
    </table>

  </div>
  <!-- /main -->
  <div class="bottom-spacing"></div>
  </div>
  </div>

  </div>

  <div class="modal fade" id="infomodal1">
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
          <p class="professor-new-info">2/28/14 Ravi Narayan: This class will now be available with a WI credit.</p>
          <div id="messagebox" class="add-comment-area">
            <p>
              <b>New Message:</b>
            </p>
            <textarea rows="4" cols="50"></textarea>
          </div>
          <p>12/15/13 Jonathan Ortal: Professor Narayan is in the process of trying to make ICS 111 a WI credit.</p>
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
    
    def render(page:String): play.api.templates.HtmlFormat.Appendable = apply(page)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (page) => apply(page)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 09:38:30 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/Results.scala.html
                    HASH: 9eb2a991da3050d7cd6f3d685ec01e803723277d
                    MATRIX: 776->1|884->15|925->22|949->38|988->40
                    LINES: 26->1|29->1|32->4|32->4|32->4
                    -- GENERATED --
                */
            
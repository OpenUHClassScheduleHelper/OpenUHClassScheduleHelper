
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
object Account extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),_display_(Seq[Any](/*3.2*/Main(page, true)/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
  <h2>Information</h2>
  <p class="info">
    <b>Name: </b>John Doe
  </p>
  <p class="info">
    <b>Standing: </b>Sophomore
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
        <input type="text" class="form-control"  placeholder="Telephone Number">
      </div>
    </div>
  </form>
  <!-- End Preferences Section -->

  <br>
  <ul class="nav nav-tabs" data-tabs="tabs" style="margin-left: 10px; margin-right: 10px; margin-top: 10px;">
    <li class="active"><a data-toggle="tab" href="#Schedule">Schedule</a></li>
    <li><a data-toggle="tab" href="#WatchList">Watch List</a></li>
    <li><a data-toggle="tab" href="#Comments">Comments</a></li>
    <li><a data-toggle="tab" href="#ScheduleHistory">Schedule History</a></li>
  </ul>

  <div class="tab-content" style="margin-left: 10px; margin-right: 10px;">
    <div class="tab-pane active" id="Schedule">
     
      <h1>Current Schedule
        <button type="button" 
                class="btn btn-primary btn-sm pull-right print-schedule-button">
                <span class="glyphicon glyphicon-print"></span> Print
        </button>
      </h1>
      
      <div class="table-responsive" style="margin-left: 10px; margin-right: 10px;">
        <table class="table table-bordered table-striped">
          <thead>
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
              <td>ICS111</td>
              <!-- Monday -->
              <td></td>
              <!-- Tuesday -->
              <td>ICS111</td>
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
              <td>MATH242</td>
              <!-- Monday -->
              <td></td>
              <!-- Tuesday -->
              <td>MATH242</td>
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
              <td>ICS141</td>
              <!-- Tuesday -->
              <td></td>
              <!-- Wednesday -->
              <td>ICS141</td>
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



    </div>

    <div class="tab-pane" id="WatchList">
      <h1>Watch List</h1>
      <h3>Fall 2013</h3>
      <div class="visible-sm visible-xs">
        <a class="btn course-dropdown-button" id="myclassbutton1"> ICS 111 Intro to Computer Science I </a>
        <div class="mobileresults" id="myclassinfo1">
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
          <p>
            <button class="btn btn-danger btn-xs">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button>
          </p>
        </div>
      </div>

      <div class="visible-sm visible-xs">
        <a class="btn course-dropdown-button" id="myclassbutton2"> Machine-Lvl & Systems Programming </a>
        <div class="mobileresults" id="myclassinfo2">
          <p>
            <b>CRN: </b><br>88611
          </p>
          <hr></hr>
          <p>
            <b>Gen Ed./Focus: </b><br>
          </p>
          <hr></hr>
          <p>
            <b>Instructor: </b><br>Henri Casanova
          </p>
          <hr></hr>
          <p>
            <b>Location: </b><br>HOLM 247
          </p>
          <hr></hr>
          <p>
            <b>Time: </b><br>TR 900-1015
          </p>
          <hr></hr>
          <p>
            <button class="btn btn-danger btn-xs">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button>
          </p>
        </div>
      </div>
      <div class="visible-sm visible-xs">
        <a class="btn course-dropdown-button" id="myclassbutton3"> Operating Systems </a>
        <div class="mobileresults" id="myclassinfo3">
          <p>
            <b>CRN: </b><br>88612
          </p>
          <hr></hr>
          <p>
            <b>Gen Ed./Focus: </b><br>
          </p>
          <hr></hr>
          <p>
            <b>Instructor: </b><br>Henri Casanova
          </p>
          <hr></hr>
          <p>
            <b>Location: </b><br>HOLM 247
          </p>
          <hr></hr>
          <p>
            <b>Time: </b><br>TR 1030-1145
          </p>
          <hr></hr>
          <p>
            <button class="btn btn-danger btn-xs">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button>
          </p>
        </div>
      </div>

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

        <tr>
          <td>84935</td>
          <td>ICS 111</td>
          <td>Intro to Computer Science I</td>
          <td>ICS</td>
          <td>0</td>
          <td>Ravi Narayan</td>
          <td>POST 127, POST 319</td>
          <td>M 0530-0800p, W 0530-0645p</td>
          <td><button class="btn btn-danger btn-sm">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button></td>
        </tr>
        <tr>
          <td>88611</td>
          <td>ICS 312</td>
          <td>Machine-Lvl & Systems Programming</td>
          <td>ICS</td>
          <td>0</td>
          <td>Henri Casanova</td>
          <td>HOLM 247</td>
          <td>TR 900-1015</td>
          <td><button class="btn btn-danger btn-sm">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button></td>
        </tr>
        <tr>
          <td>88612</td>
          <td>ICS 332</td>
          <td>Operating Systems</td>
          <td>ICS</td>
          <td>0</td>
          <td>Henri Casanova</td>
          <td>HOLM 247</td>
          <td>TR 1030-1145p</td>
          <td><button class="btn btn-danger btn-sm">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button></td>
        </tr>
      </table>

    </div>
    <div class="tab-pane" id="Comments">
      <h1>Comments</h1>

      <table class="my-courses-table table-striped hidden-sm hidden-xs">
        <tr>
          <th>Date</th>
          <th>Course</th>
          <th>Comment</th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
        <tr>
          <td>1/17/12</td>
          <td>ICS111</td>
          <td>Tough class but you sure do learn a lot!</td>
          <td></td>
          <td>
            <button id="edit1" type="button" class="btn btn-primary btn-xs" onclick="cmt.show1()">Edit</button>
            <button id="save1" type="button" style="display: none;" class="btn btn-success btn-xs" onclick="cmt.hide1()">Save</button>
          </td>
          <td><button type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#myModal">Delete</button></td>
        </tr>
        <tr id="cmt1" style="display: none;">
          <td colspan="6"><textarea class="form-control" rows="3">Tough class but you sure do learn a lot!
                      </textarea></td>
        </tr>
        <tr>
          <td>9/12/13</td>
          <td>ICS311</td>
          <td>I thought ICS111 was hard...this class is impossible!</td>
          <td></td>
          <td>
            <button id="edit2" type="button" class="btn btn-primary btn-xs" onclick="cmt.show2()">Edit</button>
            <button id="save2" type="button" style="display: none;" class="btn btn-success btn-xs" onclick="cmt.hide2()">Save</button>
          </td>
          <td><button type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#myModal">Delete</button></td>
        </tr>
        <tr id="cmt2" style="display: none;">
          <td colspan="6"><textarea class="form-control" rows="3">I thought ICS111 was hard...this class is impossible!
                      </textarea></td>
        </tr>
      </table>

      <div class="visible-sm visible-xs">
        <a class="btn course-dropdown-button" id="myclassbutton7"> ICS111: Tough class but you sure do learn a lot!
        </a>
        <div class="mobileresults" id="myclassinfo7">
          <p>
            <button class="btn btn-primary btn-sm">
              <div class="glyphicon glyphicon-pencil"></div>
              Edit
            </button>
            <button class="btn btn-danger btn-sm">
              <div class="glyphicon glyphicon-remove"></div>
              Delete
            </button>
          </p>
        </div>
      </div>
      <div class="visible-sm visible-xs">
        <a class="btn course-dropdown-button" id="myclassbutton8"> ICS311: I thought ICS111 was hard...this class is
          impossible! </a>
        <div class="mobileresults" id="myclassinfo8">
          <p>
            <button class="btn btn-primary btn-sm">
              <div class="glyphicon glyphicon-pencil"></div>
              Edit
            </button>
            <button class="btn btn-danger btn-sm">
              <div class="glyphicon glyphicon-remove"></div>
              Delete
            </button>
          </p>
        </div>
      </div>
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
          <p>
            <button class="btn btn-danger btn-sm">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button>
          </p>
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
          <th></th>
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
          <td><button class="btn btn-danger btn-sm">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button></td>
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
          <p>
            <button class="btn btn-danger btn-sm">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button>
          </p>
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
          <th></th>
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
          <td><button class="btn btn-danger btn-sm">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button></td>
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
          <p>
            <button class="btn btn-danger btn-sm">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button>
          </p>
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
          <th></th>
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
          <td><button class="btn btn-danger btn-sm">
              <div class="glyphicon glyphicon-remove"></div>
              Remove
            </button></td>
        </tr>
      </table>
    </div>

  </div>

  </div>

  <div class="bottom-spacing"></div>
  <!-- /main -->

  <!-- Modal -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
        </div>
        <div class="modal-body">Are you sure? This action cannot be undone.</div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Delete</button>
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
                    DATE: Sun Mar 30 09:38:29 HST 2014
                    SOURCE: C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/app/views/Account.scala.html
                    HASH: b648a9dce6fedf35a6048743ed0a599e9257f4b5
                    MATRIX: 776->1|884->15|923->20|947->36|986->38
                    LINES: 26->1|29->1|31->3|31->3|31->3
                    -- GENERATED --
                */
            
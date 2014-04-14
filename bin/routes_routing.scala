// @SOURCE:C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/conf/routes
// @HASH:1f1d88422c652e40446bb4cd36f6e7901252bc65
// @DATE:Sun Apr 13 20:27:49 HST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Application_searchResults1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("searchresults"))))
        

// @LINE:10
private[this] lazy val controllers_Application_login2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:11
private[this] lazy val controllers_Application_logout3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:13
private[this] lazy val controllers_Application_map4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("map"))))
        

// @LINE:15
private[this] lazy val controllers_Application_getResults5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("results"))))
        

// @LINE:16
private[this] lazy val controllers_Application_classSearch6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("results"))))
        

// @LINE:18
private[this] lazy val controllers_Application_populateInstructorList7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("populateInstructors"))))
        

// @LINE:19
private[this] lazy val controllers_Application_populateCourseList8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("populateCourses"))))
        

// @LINE:21
private[this] lazy val controllers_Application_myAccount9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("myaccount"))))
        

// @LINE:22
private[this] lazy val controllers_Application_deleteComment10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteComment"))))
        

// @LINE:23
private[this] lazy val controllers_Application_deleteCourseFromWatchlist11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteCourse"))))
        

// @LINE:24
private[this] lazy val controllers_Application_addCourseToWatchlist12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addCourseToWatchlist"))))
        

// @LINE:25
private[this] lazy val controllers_Application_addCourseToSchedule13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addCourseToSchedule"))))
        

// @LINE:27
private[this] lazy val controllers_Application_editComment14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("editComment"))))
        

// @LINE:31
private[this] lazy val controllers_Application_jsRoutes15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/js/routes"))))
        

// @LINE:32
private[this] lazy val controllers_Assets_at16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """searchresults""","""controllers.Application.searchResults()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """map""","""controllers.Application.map()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """results""","""controllers.Application.getResults()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """results""","""controllers.Application.classSearch()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """populateInstructors""","""controllers.Application.populateInstructorList(dept:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """populateCourses""","""controllers.Application.populateCourseList(dept:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """myaccount""","""controllers.Application.myAccount()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteComment""","""controllers.Application.deleteComment(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteCourse""","""controllers.Application.deleteCourseFromWatchlist(crn:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addCourseToWatchlist""","""controllers.Application.addCourseToWatchlist(crn:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addCourseToSchedule""","""controllers.Application.addCourseToSchedule(crn:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """editComment""","""controllers.Application.editComment()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/js/routes""","""controllers.Application.jsRoutes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Application_searchResults1(params) => {
   call { 
        invokeHandler(controllers.Application.searchResults(), HandlerDef(this, "controllers.Application", "searchResults", Nil,"GET", """""", Routes.prefix + """searchresults"""))
   }
}
        

// @LINE:10
case controllers_Application_login2(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:11
case controllers_Application_logout3(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:13
case controllers_Application_map4(params) => {
   call { 
        invokeHandler(controllers.Application.map(), HandlerDef(this, "controllers.Application", "map", Nil,"GET", """""", Routes.prefix + """map"""))
   }
}
        

// @LINE:15
case controllers_Application_getResults5(params) => {
   call { 
        invokeHandler(controllers.Application.getResults(), HandlerDef(this, "controllers.Application", "getResults", Nil,"GET", """""", Routes.prefix + """results"""))
   }
}
        

// @LINE:16
case controllers_Application_classSearch6(params) => {
   call { 
        invokeHandler(controllers.Application.classSearch(), HandlerDef(this, "controllers.Application", "classSearch", Nil,"GET", """""", Routes.prefix + """results"""))
   }
}
        

// @LINE:18
case controllers_Application_populateInstructorList7(params) => {
   call(params.fromQuery[String]("dept", None)) { (dept) =>
        invokeHandler(controllers.Application.populateInstructorList(dept), HandlerDef(this, "controllers.Application", "populateInstructorList", Seq(classOf[String]),"GET", """""", Routes.prefix + """populateInstructors"""))
   }
}
        

// @LINE:19
case controllers_Application_populateCourseList8(params) => {
   call(params.fromQuery[String]("dept", None)) { (dept) =>
        invokeHandler(controllers.Application.populateCourseList(dept), HandlerDef(this, "controllers.Application", "populateCourseList", Seq(classOf[String]),"GET", """""", Routes.prefix + """populateCourses"""))
   }
}
        

// @LINE:21
case controllers_Application_myAccount9(params) => {
   call { 
        invokeHandler(controllers.Application.myAccount(), HandlerDef(this, "controllers.Application", "myAccount", Nil,"GET", """""", Routes.prefix + """myaccount"""))
   }
}
        

// @LINE:22
case controllers_Application_deleteComment10(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Application.deleteComment(id), HandlerDef(this, "controllers.Application", "deleteComment", Seq(classOf[Long]),"GET", """""", Routes.prefix + """deleteComment"""))
   }
}
        

// @LINE:23
case controllers_Application_deleteCourseFromWatchlist11(params) => {
   call(params.fromQuery[String]("crn", None)) { (crn) =>
        invokeHandler(controllers.Application.deleteCourseFromWatchlist(crn), HandlerDef(this, "controllers.Application", "deleteCourseFromWatchlist", Seq(classOf[String]),"GET", """""", Routes.prefix + """deleteCourse"""))
   }
}
        

// @LINE:24
case controllers_Application_addCourseToWatchlist12(params) => {
   call(params.fromQuery[String]("crn", None)) { (crn) =>
        invokeHandler(controllers.Application.addCourseToWatchlist(crn), HandlerDef(this, "controllers.Application", "addCourseToWatchlist", Seq(classOf[String]),"GET", """""", Routes.prefix + """addCourseToWatchlist"""))
   }
}
        

// @LINE:25
case controllers_Application_addCourseToSchedule13(params) => {
   call(params.fromQuery[String]("crn", None)) { (crn) =>
        invokeHandler(controllers.Application.addCourseToSchedule(crn), HandlerDef(this, "controllers.Application", "addCourseToSchedule", Seq(classOf[String]),"GET", """""", Routes.prefix + """addCourseToSchedule"""))
   }
}
        

// @LINE:27
case controllers_Application_editComment14(params) => {
   call { 
        invokeHandler(controllers.Application.editComment(), HandlerDef(this, "controllers.Application", "editComment", Nil,"GET", """""", Routes.prefix + """editComment"""))
   }
}
        

// @LINE:31
case controllers_Application_jsRoutes15(params) => {
   call { 
        invokeHandler(controllers.Application.jsRoutes(), HandlerDef(this, "controllers.Application", "jsRoutes", Nil,"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/js/routes"""))
   }
}
        

// @LINE:32
case controllers_Assets_at16(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     
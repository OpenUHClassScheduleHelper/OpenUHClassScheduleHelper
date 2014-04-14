// @SOURCE:C:/Users/orts/Documents/GitHub/OpenUHClassScheduleHelper/conf/routes
// @HASH:1f1d88422c652e40446bb4cd36f6e7901252bc65
// @DATE:Sun Apr 13 20:27:49 HST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:32
// @LINE:31
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:6
package controllers {

// @LINE:32
class ReverseAssets {
    

// @LINE:32
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:31
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def searchResults(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "searchresults")
}
                                                

// @LINE:23
def deleteCourseFromWatchlist(crn:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deleteCourse" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("crn", crn)))))
}
                                                

// @LINE:21
def myAccount(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "myaccount")
}
                                                

// @LINE:24
def addCourseToWatchlist(crn:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "addCourseToWatchlist" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("crn", crn)))))
}
                                                

// @LINE:19
def populateCourseList(dept:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "populateCourses" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("dept", dept)))))
}
                                                

// @LINE:16
def classSearch(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "results")
}
                                                

// @LINE:31
def jsRoutes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/js/routes")
}
                                                

// @LINE:18
def populateInstructorList(dept:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "populateInstructors" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("dept", dept)))))
}
                                                

// @LINE:25
def addCourseToSchedule(crn:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "addCourseToSchedule" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("crn", crn)))))
}
                                                

// @LINE:11
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:22
def deleteComment(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deleteComment" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:27
def editComment(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "editComment")
}
                                                

// @LINE:15
def getResults(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "results")
}
                                                

// @LINE:13
def map(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "map")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:10
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:32
// @LINE:31
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:32
class ReverseAssets {
    

// @LINE:32
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:31
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def searchResults : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.searchResults",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchresults"})
      }
   """
)
                        

// @LINE:23
def deleteCourseFromWatchlist : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteCourseFromWatchlist",
   """
      function(crn) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteCourse" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("crn", crn)])})
      }
   """
)
                        

// @LINE:21
def myAccount : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.myAccount",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "myaccount"})
      }
   """
)
                        

// @LINE:24
def addCourseToWatchlist : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addCourseToWatchlist",
   """
      function(crn) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addCourseToWatchlist" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("crn", crn)])})
      }
   """
)
                        

// @LINE:19
def populateCourseList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.populateCourseList",
   """
      function(dept) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "populateCourses" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("dept", dept)])})
      }
   """
)
                        

// @LINE:16
def classSearch : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.classSearch",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "results"})
      }
   """
)
                        

// @LINE:31
def jsRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.jsRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/js/routes"})
      }
   """
)
                        

// @LINE:18
def populateInstructorList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.populateInstructorList",
   """
      function(dept) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "populateInstructors" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("dept", dept)])})
      }
   """
)
                        

// @LINE:25
def addCourseToSchedule : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addCourseToSchedule",
   """
      function(crn) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addCourseToSchedule" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("crn", crn)])})
      }
   """
)
                        

// @LINE:11
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:22
def deleteComment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteComment",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteComment" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:27
def editComment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.editComment",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "editComment"})
      }
   """
)
                        

// @LINE:15
def getResults : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getResults",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "results"})
      }
   """
)
                        

// @LINE:13
def map : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.map",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "map"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:10
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:32
// @LINE:31
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:32
class ReverseAssets {
    

// @LINE:32
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:31
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def searchResults(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.searchResults(), HandlerDef(this, "controllers.Application", "searchResults", Seq(), "GET", """""", _prefix + """searchresults""")
)
                      

// @LINE:23
def deleteCourseFromWatchlist(crn:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteCourseFromWatchlist(crn), HandlerDef(this, "controllers.Application", "deleteCourseFromWatchlist", Seq(classOf[String]), "GET", """""", _prefix + """deleteCourse""")
)
                      

// @LINE:21
def myAccount(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.myAccount(), HandlerDef(this, "controllers.Application", "myAccount", Seq(), "GET", """""", _prefix + """myaccount""")
)
                      

// @LINE:24
def addCourseToWatchlist(crn:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addCourseToWatchlist(crn), HandlerDef(this, "controllers.Application", "addCourseToWatchlist", Seq(classOf[String]), "GET", """""", _prefix + """addCourseToWatchlist""")
)
                      

// @LINE:19
def populateCourseList(dept:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.populateCourseList(dept), HandlerDef(this, "controllers.Application", "populateCourseList", Seq(classOf[String]), "GET", """""", _prefix + """populateCourses""")
)
                      

// @LINE:16
def classSearch(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.classSearch(), HandlerDef(this, "controllers.Application", "classSearch", Seq(), "GET", """""", _prefix + """results""")
)
                      

// @LINE:31
def jsRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.jsRoutes(), HandlerDef(this, "controllers.Application", "jsRoutes", Seq(), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/js/routes""")
)
                      

// @LINE:18
def populateInstructorList(dept:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.populateInstructorList(dept), HandlerDef(this, "controllers.Application", "populateInstructorList", Seq(classOf[String]), "GET", """""", _prefix + """populateInstructors""")
)
                      

// @LINE:25
def addCourseToSchedule(crn:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addCourseToSchedule(crn), HandlerDef(this, "controllers.Application", "addCourseToSchedule", Seq(classOf[String]), "GET", """""", _prefix + """addCourseToSchedule""")
)
                      

// @LINE:11
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:22
def deleteComment(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteComment(id), HandlerDef(this, "controllers.Application", "deleteComment", Seq(classOf[Long]), "GET", """""", _prefix + """deleteComment""")
)
                      

// @LINE:27
def editComment(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.editComment(), HandlerDef(this, "controllers.Application", "editComment", Seq(), "GET", """""", _prefix + """editComment""")
)
                      

// @LINE:15
def getResults(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getResults(), HandlerDef(this, "controllers.Application", "getResults", Seq(), "GET", """""", _prefix + """results""")
)
                      

// @LINE:13
def map(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.map(), HandlerDef(this, "controllers.Application", "map", Seq(), "GET", """""", _prefix + """map""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:10
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          
}
        
    
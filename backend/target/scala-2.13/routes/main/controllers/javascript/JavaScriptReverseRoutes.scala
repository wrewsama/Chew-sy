// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseRestaurantController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def getAllRestaurants: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RestaurantController.getAllRestaurants",
      """
        function(sessionId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "restaurants/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("sessionId", sessionId0))})
        }
      """
    )
  
    // @LINE:9
    def getRandomRestaurant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RestaurantController.getRandomRestaurant",
      """
        function(sessionId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "restaurants/random/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("sessionId", sessionId0))})
        }
      """
    )
  
    // @LINE:16
    def addRestaurant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RestaurantController.addRestaurant",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "restaurants"})
        }
      """
    )
  
    // @LINE:24
    def deleteRestaurant: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RestaurantController.deleteRestaurant",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "restaurants/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseSessionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def getSession: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SessionController.getSession",
      """
        function(sessionId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sessions/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("sessionId", sessionId0))})
        }
      """
    )
  
    // @LINE:20
    def addSession: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SessionController.addSession",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sessions"})
        }
      """
    )
  
  }

  // @LINE:28
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}

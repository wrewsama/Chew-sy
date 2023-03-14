// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseRestaurantController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def getAllRestaurants(sessionId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "restaurants/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("sessionId", sessionId)))
    }
  
    // @LINE:9
    def getRandomRestaurant(sessionId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "restaurants/random/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("sessionId", sessionId)))
    }
  
    // @LINE:16
    def addRestaurant(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "restaurants")
    }
  
    // @LINE:24
    def deleteRestaurant(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "restaurants/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:12
  class ReverseSessionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def getSession(sessionId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "sessions/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("sessionId", sessionId)))
    }
  
    // @LINE:20
    def addSession(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sessions")
    }
  
  }

  // @LINE:28
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}

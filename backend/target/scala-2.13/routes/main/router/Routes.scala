// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  RestaurantController_0: controllers.RestaurantController,
  // @LINE:12
  SessionController_1: controllers.SessionController,
  // @LINE:28
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    RestaurantController_0: controllers.RestaurantController,
    // @LINE:12
    SessionController_1: controllers.SessionController,
    // @LINE:28
    Assets_2: controllers.Assets
  ) = this(errorHandler, RestaurantController_0, SessionController_1, Assets_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, RestaurantController_0, SessionController_1, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """restaurants/""" + "$" + """sessionId<[^/]+>""", """controllers.RestaurantController.getAllRestaurants(sessionId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """restaurants/random/""" + "$" + """sessionId<[^/]+>""", """controllers.RestaurantController.getRandomRestaurant(sessionId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sessions/""" + "$" + """sessionId<[^/]+>""", """controllers.SessionController.getSession(sessionId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """restaurants""", """controllers.RestaurantController.addRestaurant(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sessions""", """controllers.SessionController.addSession(request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """restaurants/""" + "$" + """id<[^/]+>""", """controllers.RestaurantController.deleteRestaurant(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_RestaurantController_getAllRestaurants0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("restaurants/"), DynamicPart("sessionId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RestaurantController_getAllRestaurants0_invoker = createInvoker(
    RestaurantController_0.getAllRestaurants(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RestaurantController",
      "getAllRestaurants",
      Seq(classOf[String]),
      "GET",
      this.prefix + """restaurants/""" + "$" + """sessionId<[^/]+>""",
      """ Get all restaurants""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_RestaurantController_getRandomRestaurant1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("restaurants/random/"), DynamicPart("sessionId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RestaurantController_getRandomRestaurant1_invoker = createInvoker(
    RestaurantController_0.getRandomRestaurant(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RestaurantController",
      "getRandomRestaurant",
      Seq(classOf[String]),
      "GET",
      this.prefix + """restaurants/random/""" + "$" + """sessionId<[^/]+>""",
      """ Get a random restaurant""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_SessionController_getSession2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sessions/"), DynamicPart("sessionId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SessionController_getSession2_invoker = createInvoker(
    SessionController_1.getSession(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SessionController",
      "getSession",
      Seq(classOf[String]),
      "GET",
      this.prefix + """sessions/""" + "$" + """sessionId<[^/]+>""",
      """ Get session by id""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_RestaurantController_addRestaurant3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("restaurants")))
  )
  private[this] lazy val controllers_RestaurantController_addRestaurant3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RestaurantController_0.addRestaurant(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RestaurantController",
      "addRestaurant",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """restaurants""",
      """ Add new restaurant""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:20
  private[this] lazy val controllers_SessionController_addSession4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sessions")))
  )
  private[this] lazy val controllers_SessionController_addSession4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      SessionController_1.addSession(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SessionController",
      "addSession",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """sessions""",
      """ Add new session""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:24
  private[this] lazy val controllers_RestaurantController_deleteRestaurant5_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("restaurants/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RestaurantController_deleteRestaurant5_invoker = createInvoker(
    RestaurantController_0.deleteRestaurant(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RestaurantController",
      "deleteRestaurant",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """restaurants/""" + "$" + """id<[^/]+>""",
      """ Delete a restaurant""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:28
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_RestaurantController_getAllRestaurants0_route(params@_) =>
      call(params.fromPath[String]("sessionId", None)) { (sessionId) =>
        controllers_RestaurantController_getAllRestaurants0_invoker.call(RestaurantController_0.getAllRestaurants(sessionId))
      }
  
    // @LINE:9
    case controllers_RestaurantController_getRandomRestaurant1_route(params@_) =>
      call(params.fromPath[String]("sessionId", None)) { (sessionId) =>
        controllers_RestaurantController_getRandomRestaurant1_invoker.call(RestaurantController_0.getRandomRestaurant(sessionId))
      }
  
    // @LINE:12
    case controllers_SessionController_getSession2_route(params@_) =>
      call(params.fromPath[String]("sessionId", None)) { (sessionId) =>
        controllers_SessionController_getSession2_invoker.call(SessionController_1.getSession(sessionId))
      }
  
    // @LINE:16
    case controllers_RestaurantController_addRestaurant3_route(params@_) =>
      call { 
        controllers_RestaurantController_addRestaurant3_invoker.call(
          req => RestaurantController_0.addRestaurant(req))
      }
  
    // @LINE:20
    case controllers_SessionController_addSession4_route(params@_) =>
      call { 
        controllers_SessionController_addSession4_invoker.call(
          req => SessionController_1.addSession(req))
      }
  
    // @LINE:24
    case controllers_RestaurantController_deleteRestaurant5_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_RestaurantController_deleteRestaurant5_invoker.call(RestaurantController_0.deleteRestaurant(id))
      }
  
    // @LINE:28
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_2.versioned(path, file))
      }
  }
}

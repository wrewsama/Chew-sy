// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseRestaurantController RestaurantController = new controllers.ReverseRestaurantController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseSessionController SessionController = new controllers.ReverseSessionController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseRestaurantController RestaurantController = new controllers.javascript.ReverseRestaurantController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseSessionController SessionController = new controllers.javascript.ReverseSessionController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}

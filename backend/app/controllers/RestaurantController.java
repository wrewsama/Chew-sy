package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.mvc.*;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import java.util.concurrent.CompletionStage;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;

import models.Restaurant;
import utils.Util;

public class RestaurantController extends Controller {
    private HttpExecutionContext ec;

    @Inject
    public RestaurantController(HttpExecutionContext ec) {
        this.ec = ec;
    }

    public CompletionStage<Result> getAllRestaurants(String sessionId) {
        return CompletableFuture.supplyAsync(() -> {
            List<Restaurant> restaurants = Restaurant.find
                                                     .query()
                                                     .where()
                                                     .eq("sessionId", sessionId)
                                                     .findList();
            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonData = mapper.convertValue(restaurants, JsonNode.class);
            return ok(Util.createResponse(jsonData, true));
        }, this.ec.current());
    }

    public CompletionStage<Result> addRestaurant(Http.Request request) {
        JsonNode json = request.body().asJson();
        return CompletableFuture.supplyAsync(() -> {
            if (json == null) {
                return badRequest(Util.createResponse("Expecting Json data", false));
            }

            try {
                Restaurant restaurant = Json.fromJson(json, Restaurant.class);
                restaurant.save();
            } catch (Exception e) {
                return internalServerError(Util.createResponse("Internal Server Error", false));
            }
            return ok(Util.createResponse("Restaurant Added", true));
        }, this.ec.current());
    }

    public CompletionStage<Result> deleteRestaurant(String id) {
        return CompletableFuture.supplyAsync(() -> {
            Restaurant restaurant = Restaurant.find.byId(id);
            if (restaurant == null) {
                return notFound(Util.createResponse("not found", false));
            }

            try {
                restaurant.delete();
            } catch (Exception e) {
                return internalServerError(Util.createResponse("Internal Server Error", false));
            }

            return ok(Util.createResponse("Restaurant Deleted", true));
        }, this.ec.current());
    }
    
    public CompletionStage<Result> getRandomRestaurant(String sessionId) {
        return CompletableFuture.supplyAsync(() -> {
            List<Restaurant> restaurants = Restaurant.find
                                                     .query()
                                                     .where()
                                                     .eq("sessionId", sessionId)
                                                     .findList();

            // Handle the edge case where there are no restaurants added to the session.
            if (restaurants.size() == 0) {
                return badRequest(Util.createResponse("Please add some restaurants!", false));
            }
            
            int randomIndex = (int) (Math.random() * restaurants.size());
            Restaurant restaurant = restaurants.get(randomIndex);
            
            JsonNode jsonData = Json.toJson(restaurant);
            return ok(Util.createResponse(jsonData, true));
        }, this.ec.current());
    }
}

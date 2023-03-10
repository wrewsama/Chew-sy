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
                return internalServerError(Util.createResponse("Bad request", false));
            }
            return ok(Util.createResponse("Restaurant Added", true));
        }, this.ec.current());
    }
    
}

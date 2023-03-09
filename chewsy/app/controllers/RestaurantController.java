package controllers;

import play.mvc.*;
import play.libs.concurrent.HttpExecutionContext;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;
import utils.Util;

public class RestaurantController extends Controller {
    private HttpExecutionContext ec;
    // put db here

    @Inject
    public RestaurantController(HttpExecutionContext ec) {
        this.ec = ec;
        // init db here
    }

    public CompletionStage<Result> getAllRestaurants(String sessionId) {
        return CompletableFuture.supplyAsync(() -> {
            return ok(Util.createResponse("Hello World", true));
        });
    }
    
}

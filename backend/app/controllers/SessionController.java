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

import models.Session;
import utils.Util;

public class SessionController extends Controller {
    private HttpExecutionContext ec;

    @Inject
    public SessionController(HttpExecutionContext ec) {
        this.ec = ec;
    }

    public CompletionStage<Result> addSession(Http.Request request) {
        JsonNode json = request.body().asJson();
        return CompletableFuture.supplyAsync(() -> {
            if (json == null) {
                return badRequest(Util.createResponse("Expecting Json data", false));
            }

            try {
                Session session = Json.fromJson(json, Session.class);
                session.save();
            } catch (Exception e) {
                return internalServerError(Util.createResponse(e.toString(), false));
            }
            return ok(Util.createResponse("Session Added", true));
        }, this.ec.current());
    }
}

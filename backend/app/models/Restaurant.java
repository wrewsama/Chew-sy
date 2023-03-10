package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Model;
import io.ebean.Finder;

@Entity
public class Restaurant extends Model {
    @Id
    private String id;
    private String sessionId;
    private String name;

    public Restaurant(String id, String sessionId, String name) {
        this.id = id;
        this.sessionId = sessionId;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public void setSessionId(String newSessionId) {
        this.sessionId = newSessionId;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public static final Finder<String, Restaurant> find = new Finder<>(Restaurant.class);
}
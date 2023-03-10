package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Model;
import io.ebean.Finder;

@Entity
public class Session {
    @Id
    private String id;

    public Session(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public static final Finder<String, Session> find = new Finder<>(Session.class);
}

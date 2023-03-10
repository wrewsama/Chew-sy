package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Model;
import io.ebean.Finder;

@Entity
public class Session extends Model {
    @Id
    private String id;
    private String name;

    public Session(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public static final Finder<String, Session> find = new Finder<>(Session.class);
}

package models;

public class Restaurant {
    private String sessionId;
    private String name;

    public Restaurant(String sessionId, String name) {
        this.sessionId = sessionId;
        this.name = name;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getName() {
        return this.name;
    }

    public void setSessionId(String newSessionId) {
        this.sessionId = newSessionId;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}
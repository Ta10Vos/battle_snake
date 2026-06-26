package nl.hu.bep.battlesnake.model;

public class Game {
    private String id;
    private Ruleset ruleset;
    private String map;
    private int timeout;
    private String source;

    public Game() {}

    public Game(String id, Ruleset ruleset, String map, int timeout, String source) {
        this.id = id;
        this.ruleset = ruleset;
        this.map = map;
        this.timeout = timeout;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    /**
     * Set the id for the current game. Can only be set once.
     */
    public void setId(String id) {
        if (!this.id.isBlank()) return;
        this.id = id;
    }

    public Ruleset getRuleset() {
        return ruleset;
    }

    public void setRuleset(Ruleset ruleset) {
        this.ruleset = ruleset;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

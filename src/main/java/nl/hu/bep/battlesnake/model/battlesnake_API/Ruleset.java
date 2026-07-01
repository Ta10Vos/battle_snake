package nl.hu.bep.battlesnake.model.battlesnake_API;

public class Ruleset {
    private String name;
    private String version;
    private Object settings;

    public Ruleset() {}

    public Ruleset(String name, String version, Object settings) {
        this.name = name;
        this.version = version;
        this.settings = settings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Object getSettings() {
        return settings;
    }

    public void setSettings(Object settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "Ruleset{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", settings=" + settings +
                '}';
    }
}

package nl.hu.bep.battlesnake.model.battlesnake_API;

public class RulesetSettingsSquad {
    protected boolean allowBodyCollisions;
    protected boolean sharedElimination;
    protected boolean sharedHealth;
    protected boolean sharedLength;

    public RulesetSettingsSquad() {}

    public RulesetSettingsSquad(boolean allowBodyCollisions, boolean sharedElimination, boolean sharedHealth, boolean sharedLength) {
        this.allowBodyCollisions = allowBodyCollisions;
        this.sharedElimination = sharedElimination;
        this.sharedHealth = sharedHealth;
        this.sharedLength = sharedLength;
    }

    public boolean isAllowBodyCollisions() {
        return allowBodyCollisions;
    }

    public void setAllowBodyCollisions(boolean allowBodyCollisions) {
        this.allowBodyCollisions = allowBodyCollisions;
    }

    public boolean isSharedElimination() {
        return sharedElimination;
    }

    public void setSharedElimination(boolean sharedElimination) {
        this.sharedElimination = sharedElimination;
    }

    public boolean isSharedHealth() {
        return sharedHealth;
    }

    public void setSharedHealth(boolean sharedHealth) {
        this.sharedHealth = sharedHealth;
    }

    public boolean isSharedLength() {
        return sharedLength;
    }

    public void setSharedLength(boolean sharedLength) {
        this.sharedLength = sharedLength;
    }
}

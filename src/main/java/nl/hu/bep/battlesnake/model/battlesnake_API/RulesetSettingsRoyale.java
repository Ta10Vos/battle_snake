package nl.hu.bep.battlesnake.model.battlesnake_API;

public class RulesetSettingsRoyale {
    protected int shrinkEveryNTurns;

    public RulesetSettingsRoyale() {}

    public RulesetSettingsRoyale(int shrinkEveryNTurns) {
        this.shrinkEveryNTurns = shrinkEveryNTurns;
    }

    public int getShrinkEveryNTurns() {
        return shrinkEveryNTurns;
    }

    public void setShrinkEveryNTurns(int shrinkEveryNTurns) {
        this.shrinkEveryNTurns = shrinkEveryNTurns;
    }
}

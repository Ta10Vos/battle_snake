package nl.hu.bep.model;

public class RulesetSettings {
    protected int foodSpawnChance;
    protected int minimumFood;
    protected int hazardDamagePerTurn;

    public int getFoodSpawnChance() {
        return foodSpawnChance;
    }

    public void setFoodSpawnChance(int foodSpawnChance) {
        this.foodSpawnChance = foodSpawnChance;
    }

    public int getMinimumFood() {
        return minimumFood;
    }

    public void setMinimumFood(int minimumFood) {
        this.minimumFood = minimumFood;
    }

    public int getHazardDamagePerTurn() {
        return hazardDamagePerTurn;
    }

    public void setHazardDamagePerTurn(int hazardDamagePerTurn) {
        this.hazardDamagePerTurn = hazardDamagePerTurn;
    }
}

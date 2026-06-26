package nl.hu.bep.battlesnake.model.responses;

import nl.hu.bep.battlesnake.model.Customization;

public class CustomizationResponse {
    public String color = "#00ffff";
    public String head = "default";
    public String tail = "default";

    public CustomizationResponse() {

    }

    public CustomizationResponse(Customization customization) {
        color = customization.getColor();
        head = customization.getHead();
        tail = customization.getTail();
    }
}

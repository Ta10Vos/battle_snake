package nl.hu.bep.battlesnake.model.responses;

public class MoveResponse {
    public String move;// "up" || "down" || "left" || "right"
    public String shout;// Optional: Message of 256 char, or less

    public MoveResponse(String move, String shout) {
        this.move = move;
        this.shout = shout;
    }
}

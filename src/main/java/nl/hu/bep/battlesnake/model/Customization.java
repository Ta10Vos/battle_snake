package nl.hu.bep.battlesnake.model;

public class Customization {
    private String color;
    private String head;
    private String tail;

    public Customization() {
        color = "#00ffff";
        head = "default";
        tail = "default";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}

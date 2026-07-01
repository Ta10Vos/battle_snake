package nl.hu.bep.battlesnake.model.battlesnake_API;

import nl.hu.bep.battlesnake.model.Coordinate;
import nl.hu.bep.battlesnake.model.Customization;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Battlesnake {
    private String id;
    private String name;
    private int health;
    private List<Coordinate> body;
    private String latency;
    private Coordinate head;
    private int length;
    private String shout;// Previous turn shout
    private String squad;
    private Customization customizations;

    public Battlesnake() {}

    public Battlesnake(ArrayList<Coordinate> body, String id, String name, int health, String latency, Coordinate head, int length, String shout, String squad, Customization customizations) {
        this.body = unmodifiableList(body);
        this.id = id;
        this.name = name;
        this.health = health;
        this.latency = latency;
        this.head = head;
        this.length = length;
        this.shout = shout;
        this.squad = squad;
        this.customizations = customizations;
    }

    public String getSquad() {
        return squad;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public ArrayList<Coordinate> getBody() {
        return (ArrayList<Coordinate>) body;
    }

    public String getLatency() {
        return latency;
    }

    public Coordinate getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public String getShout() {
        return shout;
    }

    public void setShout(String shout) {
        this.shout = shout;
    }

    public Customization getCustomizations() {
        return customizations;
    }

    @Override
    public String toString() {
        return "Battlesnake{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", body=" + body +
                ", latency='" + latency + '\'' +
                ", head=" + head +
                ", length=" + length +
                ", shout='" + shout + '\'' +
                ", squad='" + squad + '\'' +
                ", customizations=" + customizations +
                '}';
    }
}

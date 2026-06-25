package nl.hu.bep.battlesnake.model;

import java.util.ArrayList;

public class Battlesnake {
    private String id;
    private String name;
    private int health;
    private ArrayList<Coordinate> body;
    private String latency;
    private Coordinate head;
    private int length;
    private String shout;// Previous turn shout
    private String squad;
    private Customization customizations;

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<Coordinate> getBody() {
        return body;
    }

    public void setBody(ArrayList<Coordinate> body) {
        this.body = body;
    }

    public String getLatency() {
        return latency;
    }

    public void setLatency(String latency) {
        this.latency = latency;
    }

    public Coordinate getHead() {
        return head;
    }

    public void setHead(Coordinate head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public void setCustomizations(Customization customizations) {
        this.customizations = customizations;
    }
}

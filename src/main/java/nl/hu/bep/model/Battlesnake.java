package nl.hu.bep.model;

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
}

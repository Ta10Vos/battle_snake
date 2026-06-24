package nl.hu.bep.model;

import java.util.ArrayList;

public class Battlesnake {
    String id;
    String name;
    int health;
    ArrayList<Coordinate> body;
    String latency;
    Coordinate head;
    int length;
    String shout;// Previous turn shout
    String squad;
    Customization customizations;
}

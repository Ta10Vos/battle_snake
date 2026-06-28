package nl.hu.bep.battlesnake.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Board {
    private int height;
    private int width;
    private List<Coordinate> food;
    private List<Coordinate> hazards;
    private List<Battlesnake> snakes;

    public Board() {}

    public Board(ArrayList<Coordinate> food, int height, int width, ArrayList<Coordinate> hazards, ArrayList<Battlesnake> snakes) {
        this.food = unmodifiableList(food);
        this.height = height;
        this.width = width;
        this.hazards = unmodifiableList(hazards);
        this.snakes = unmodifiableList(snakes);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Coordinate> getFood() {
        return food;
    }

    public List<Coordinate> getHazards() {
        return hazards;
    }

    public List<Battlesnake> getSnakes() {
        return snakes;
    }
}

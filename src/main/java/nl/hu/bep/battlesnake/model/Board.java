package nl.hu.bep.battlesnake.model;

import java.util.ArrayList;

public class Board {
    private int height;
    private int width;
    private ArrayList<Coordinate> food;
    private ArrayList<Coordinate> hazards;
    private ArrayList<Battlesnake> snakes;

    public Board() {}

    public Board(ArrayList<Coordinate> food, int height, int width, ArrayList<Coordinate> hazards, ArrayList<Battlesnake> snakes) {
        this.food = food;
        this.height = height;
        this.width = width;
        this.hazards = hazards;
        this.snakes = snakes;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ArrayList<Coordinate> getFood() {
        return food;
    }

    public void setFood(ArrayList<Coordinate> food) {
        this.food = food;
    }

    public ArrayList<Coordinate> getHazards() {
        return hazards;
    }

    public void setHazards(ArrayList<Coordinate> hazards) {
        this.hazards = hazards;
    }

    public ArrayList<Battlesnake> getSnakes() {
        return snakes;
    }

    public void setSnakes(ArrayList<Battlesnake> snakes) {
        this.snakes = snakes;
    }
}

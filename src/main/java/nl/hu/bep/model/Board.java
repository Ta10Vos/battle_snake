package nl.hu.bep.model;

import java.util.ArrayList;

public class Board {
    int height;
    int width;
    ArrayList<Coordinate> food;
    ArrayList<Coordinate> hazards;
    ArrayList<Battlesnake> snakes;
}

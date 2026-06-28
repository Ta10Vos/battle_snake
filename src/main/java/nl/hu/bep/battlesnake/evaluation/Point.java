package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.model.Coordinate;

public class Point {
    public Coordinate coordinate;
    public Point previous;

    public Point(Coordinate coordinate) {
        this.coordinate = coordinate;
    }


}

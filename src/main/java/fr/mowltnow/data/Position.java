package fr.mowltnow.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static fr.mowltnow.utils.GlobalConstants.SEPARATOR;

@Getter
@AllArgsConstructor
public class Position {
    private Coordinates coordinates;
    private Orientation orientation;

    public Position(int x, int y, Orientation orientation) {
        coordinates = new Coordinates(x, y);
        this.orientation = orientation;
    }

    public Position goStraight() {
        coordinates = orientation.getFunction().apply(coordinates);
        return this;
    }

    public Position turnRight() {
        orientation = orientation.turnRight();
        return this;
    }

    public Position turnLeft() {
        orientation = orientation.turnLeft();
        return this;
    }

    @Override
    public String toString() {
        return coordinates + SEPARATOR + orientation;
    }
}

package fr.mowltnow.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {
    private Coordinates coordinates;
    private Orientation orientation;

    public Position(int x, int y, Orientation orientation) {
        coordinates = new Coordinates(x, y);
        this.orientation = orientation;
    }

}

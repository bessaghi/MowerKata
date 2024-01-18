package fr.mowltnow.data;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import static fr.mowltnow.utils.GlobalConstants.SEPARATOR;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Coordinates {
    private int x;
    private int y;

    public boolean overlaps(Coordinates coordinates) {
        return x > coordinates.getX() || y > coordinates.getY();
    }

    @Override
    public String toString() {
        return x + SEPARATOR + y;
    }
}

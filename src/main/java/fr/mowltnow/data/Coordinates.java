package fr.mowltnow.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static fr.mowltnow.utils.GlobalConstants.SEPARATOR;

@Getter
@AllArgsConstructor
public class Coordinates {
    private int x;
    private int y;

    public Coordinates goLeft() {
        x--;
        return this;
    }

    public Coordinates goRight() {
        x++;
        return this;
    }

    public Coordinates moveDown() {
        y--;
        return this;
    }

    public Coordinates moveUp() {
        y++;
        return this;
    }

    @Override
    public String toString() {
        return x + SEPARATOR + y;
    }
}

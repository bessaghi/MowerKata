package fr.mowltnow.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum Orientation {
    N(Coordinates::moveUp),
    S(Coordinates::moveDown),
    E(Coordinates::goRight),
    W(Coordinates::goLeft);

    private final Function<Coordinates, Coordinates> function;

    public Orientation turnRight() {
        return switch (this) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        };
    }

    public Orientation turnLeft() {
        return switch (this) {
            case N -> W;
            case W -> S;
            case S -> E;
            case E -> N;
        };
    }
}

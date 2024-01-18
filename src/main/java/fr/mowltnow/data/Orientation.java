package fr.mowltnow.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.BiFunction;

@Getter
@AllArgsConstructor
public enum Orientation {
    N((x, y) -> new Coordinates(x, y + 1)),
    S((x, y) -> new Coordinates(x, y - 1)),
    E((x, y) -> new Coordinates(x + 1, y)),
    W((x, y) -> new Coordinates(x - 1, y));

    private final BiFunction<Integer, Integer, Coordinates> function;

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

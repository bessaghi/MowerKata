package fr.mowltnow.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum Direction {
    A(Position::goStraight),
    G(Position::turnLeft),
    D(Position::turnRight);

    private final Function<Position, Position> move;
}

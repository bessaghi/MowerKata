package fr.mowltnow.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum Direction {
    A(Mower::goStraight),
    G(Mower::turnLeft),
    D(Mower::turnRight);

    private final Function<Mower, Position> executeInstruction;
}

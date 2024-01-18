package fr.mowltnow.services;

import fr.mowltnow.data.Direction;
import fr.mowltnow.data.Mower;

public class MowerMover {

    public void execute(String movements, Mower mower) {
        movements.chars().mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(Direction::valueOf)
                .forEach(mower::move);
    }
}

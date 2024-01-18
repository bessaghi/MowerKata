package fr.mowltnow.services;

import fr.mowltnow.data.Direction;
import fr.mowltnow.data.Orientation;
import fr.mowltnow.data.Position;
import fr.mowltnow.exceptions.IncorrectSizeException;

import static fr.mowltnow.services.CoordinatesReader.toCoordinates;
import static fr.mowltnow.utils.GlobalConstants.SEPARATOR;
import static java.util.Optional.ofNullable;

public class PositionReader {

    public static Position readPosition(String position) {
        return ofNullable(position)
                .map(it -> it.split(SEPARATOR))
                .filter(it -> it.length == 3)
                .map(PositionReader::toPosition)
                .orElseThrow(() -> new IncorrectSizeException("The size of the lawn doesn't have the correct format (X X)"));
    }

    private static Position toPosition(String[] position) {
        return new Position(toCoordinates(position), Orientation.valueOf(position[2]));
    }

    public static Position move(Position position, Direction direction) {
        return direction.getMove().apply(position);
    }
}

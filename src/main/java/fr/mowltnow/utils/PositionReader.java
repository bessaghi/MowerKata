package fr.mowltnow.utils;

import fr.mowltnow.data.Orientation;
import fr.mowltnow.data.Position;
import fr.mowltnow.exceptions.IncorrectSizeException;

import static fr.mowltnow.utils.CoordinatesReader.toCoordinates;
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

}

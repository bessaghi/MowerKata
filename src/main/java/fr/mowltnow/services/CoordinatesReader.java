package fr.mowltnow.services;

import fr.mowltnow.data.Coordinates;
import fr.mowltnow.data.Orientation;
import fr.mowltnow.data.Position;
import fr.mowltnow.exceptions.IncorrectSizeException;

import static java.lang.Integer.parseInt;
import static java.util.Optional.ofNullable;

public class CoordinatesReader {

    private static final String SEPARATOR = " ";

    public static Coordinates read(String coordinates) {
        return ofNullable(coordinates)
                .map(it -> it.split(SEPARATOR))
                .filter(it -> it.length == 2)
                .map(CoordinatesReader::toCoordinates)
                .orElseThrow(() -> new IncorrectSizeException("The size of the lawn doesn't have the correct format (X X)"));
    }

    public static Position readPosition(String position) {
        return ofNullable(position)
                .map(it -> it.split(SEPARATOR))
                .filter(it -> it.length == 3)
                .map(CoordinatesReader::toPosition)
                .orElseThrow(() -> new IncorrectSizeException("The size of the lawn doesn't have the correct format (X X)"));
    }

    private static Position toPosition(String[] position) {
        return new Position(toCoordinates(position), Orientation.valueOf(position[2]));
    }

    private static Coordinates toCoordinates(String[] coords) {
        try {
            return new Coordinates(parseInt(coords[0]), parseInt(coords[1]));
        } catch (NumberFormatException e) {
            throw new IncorrectSizeException("Lawn size must only be numbers", e);
        }
    }
}

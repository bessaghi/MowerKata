package fr.mowltnow.services;

import fr.mowltnow.data.Coordinates;
import fr.mowltnow.exceptions.IncorrectSizeException;

import static fr.mowltnow.utils.GlobalConstants.SEPARATOR;
import static java.lang.Integer.parseInt;
import static java.util.Optional.ofNullable;

public class CoordinatesReader {

    public static Coordinates read(String coordinates) {
        return ofNullable(coordinates)
                .map(it -> it.split(SEPARATOR))
                .filter(it -> it.length == 2)
                .map(CoordinatesReader::toCoordinates)
                .orElseThrow(() -> new IncorrectSizeException("The size of the lawn doesn't have the correct format (X X)"));
    }

    public static Coordinates toCoordinates(String[] coords) {
        try {
            return new Coordinates(parseInt(coords[0]), parseInt(coords[1]));
        } catch (NumberFormatException e) {
            throw new IncorrectSizeException("Lawn size must only be numbers", e);
        }
    }
}

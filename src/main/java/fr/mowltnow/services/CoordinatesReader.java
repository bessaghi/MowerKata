package fr.mowltnow.services;

import fr.mowltnow.data.Coordinates;
import fr.mowltnow.exceptions.IncorrectSizeException;
import lombok.extern.slf4j.Slf4j;

import static java.lang.Integer.parseInt;

@Slf4j
public class CoordinatesReader {

    private static final String SEPARATOR = " ";

    public static Coordinates read(String coordinates) {
        String[] coord = coordinates.split(SEPARATOR);
        if (coord.length < 2) {
            log.error("The size of the lawn doesn't have the correct format {}", coordinates);
            throw new IncorrectSizeException();
        }
        try {
            return new Coordinates(
                    parseInt(coord[0]),
                    parseInt(coord[1])
            );
        } catch (NumberFormatException e) {
            log.error("Could not read size from coordinates {}", coordinates, e);
            throw new IncorrectSizeException();
        }
    }
}

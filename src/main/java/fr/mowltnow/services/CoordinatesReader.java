package fr.mowltnow.services;

import fr.mowltnow.data.Coordinates;

import static java.lang.Integer.parseInt;

public class CoordinatesReader {

    private static final String SEPARATOR = " ";

    public static Coordinates read(String coordinates) {
        String[] coord = coordinates.split(SEPARATOR);
        return new Coordinates(
                parseInt(coord[0]),
                parseInt(coord[1])
        );
    }
}

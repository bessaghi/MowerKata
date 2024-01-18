package fr.mowltnow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinates {
    private int x;
    private int y;

    public static Coordinates read(String coordinates) {
        String[] coord = coordinates.split(" ");
        return new Coordinates(
                Integer.parseInt(coord[0]),
                Integer.parseInt(coord[1])
                );
    }
}

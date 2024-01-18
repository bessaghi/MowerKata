package fr.mowltnow.data;

import fr.mowltnow.data.Coordinates;
import fr.mowltnow.services.CoordinatesReader;
import lombok.Data;

@Data
public class Lawn {

    private Coordinates size;

    public void setSize(String size) {
        this.size = CoordinatesReader.read(size);
    }
}

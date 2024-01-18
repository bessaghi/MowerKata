package fr.mowltnow.data;

import fr.mowltnow.services.CoordinatesReader;
import lombok.Data;


@Data
public class Mower {

    private Position position;

    public void setInitialPosition(String position) {
        this.position = CoordinatesReader.readPosition(position);
    }
}

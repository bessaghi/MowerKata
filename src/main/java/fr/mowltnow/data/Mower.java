package fr.mowltnow.data;

import fr.mowltnow.services.PositionReader;
import lombok.Data;


@Data
public class Mower {

    private Position position;

    public void setInitialPosition(String position) {
        this.position = PositionReader.readPosition(position);
    }
}

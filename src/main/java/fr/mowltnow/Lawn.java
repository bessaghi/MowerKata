package fr.mowltnow;

import lombok.Data;

@Data
public class Lawn {

    private Coordinates size;

    public void setSize(String size) {
        this.size = Coordinates.read(size);
    }
}

package fr.mowltnow.data;

import fr.mowltnow.services.CoordinatesReader;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Lawn {

    private Coordinates maxSize;
    private List<Mower> mowers = new ArrayList<>();

    public Lawn(String maxSize) {
        this.maxSize = CoordinatesReader.read(maxSize);
    }

    public void addMower(Mower mower) {
        mower.setMaxSize(maxSize);
        mowers.add(mower);
    }
}

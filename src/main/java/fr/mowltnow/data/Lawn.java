package fr.mowltnow.data;

import fr.mowltnow.services.CoordinatesReader;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Lawn {

    private Coordinates size;
    private List<Mower> mowers = new ArrayList<>();

    public void setSize(String size) {
        this.size = CoordinatesReader.read(size);
    }

    public void addMower(Mower mower) {
        mower.setMaxSize(size);
        mowers.add(mower);
    }
}

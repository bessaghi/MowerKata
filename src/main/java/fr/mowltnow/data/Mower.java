package fr.mowltnow.data;

import fr.mowltnow.services.PositionReader;
import lombok.Data;


@Data
public class Mower {

    private Position position;

    public void setInitialPosition(String position) {
        this.position = PositionReader.readPosition(position);
    }

    public void move(Direction direction) {
        position = PositionReader.move(position, direction);
    }

    public void execute(String movements) {
        movements.chars().mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(Direction::valueOf)
                .forEach(this::move);
    }
}

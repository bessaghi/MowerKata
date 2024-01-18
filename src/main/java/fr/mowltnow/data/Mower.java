package fr.mowltnow.data;

import fr.mowltnow.services.PositionReader;
import lombok.Data;


@Data
public class Mower {

    private Position position;
    private Coordinates maxSize;

    public void setInitialPosition(String position) {
        this.position = PositionReader.readPosition(position);
    }

    public void move(Direction direction) {
        position = PositionReader.move(this, direction);
    }

    public void execute(String movements) {
        movements.chars().mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(Direction::valueOf)
                .forEach(this::move);
    }


    public Position goStraight() {
        return position.goStraight(maxSize);
    }

    public Position turnLeft() {
        return position.turnLeft();
    }

    public Position turnRight() {
        return position.turnRight();
    }
}

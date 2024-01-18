package fr.mowltnow.data;

import lombok.Data;

import static fr.mowltnow.utils.PositionReader.readPosition;


@Data
public class Mower {

    private Position position;
    private Coordinates maxSize;

    public Mower(String position) {
        setPosition(position);
    }

    public void setPosition(String position) {
        this.position = readPosition(position);
    }

    public void move(Direction direction) {
        position = direction.getExecuteInstruction().apply(this);
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

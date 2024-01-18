package fr.mowltnow.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MowerTest {

    private Mower mower;

    @BeforeEach
    void setUp() {
        Lawn lawn = new Lawn("5 5");
        mower = new Mower("1 2 N");
        lawn.addMower(mower);
    }

    @Test
    void should_read_initial_position_of_the_mower() {
        assertThat(mower.getPosition()).isEqualTo(new Position(1, 2, Orientation.N));
    }

    @ParameterizedTest
    @CsvSource({
            "A, 1, 3, N",
            "G, 1, 2, W",
            "D, 1, 2, E",
    })
    void should_move_a_mower(Direction direction, int x, int y, Orientation orientation) {
        mower.move(direction);

        assertThat(mower.getPosition()).isEqualTo(new Position(x, y, orientation));
    }

}
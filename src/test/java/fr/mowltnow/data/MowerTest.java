package fr.mowltnow.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MowerTest {

    @Test
    void should_read_initial_position_of_the_mower() {
        Mower mower = new Mower();

        mower.setInitialPosition("1 2 N");

        assertThat(mower.getPosition()).isEqualTo(new Position(1, 2, Orientation.N));
    }

    @ParameterizedTest
    @CsvSource({
            "A, 1, 3, N",
            "G, 1, 2, W",
            "D, 1, 2, E",
    })
    void should_move_a_mower(Direction direction, int x, int y, Orientation orientation) {
        Mower mower = new Mower();
        mower.setInitialPosition("1 2 N");

        mower.move(direction);

        assertThat(mower.getPosition()).isEqualTo(new Position(x, y, orientation));
    }

}
package fr.mowltnow.data;

import fr.mowltnow.exceptions.IncorrectSizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LawnTest {

    private Lawn lawn;

    @BeforeEach
    void setUp() {
        lawn = new Lawn();
    }

    @Test
    void should_set_size_of_the_lawn() {
        lawn.setSize("5 5");

        assertThat(lawn.getSize()).isEqualTo(new Coordinates(5, 5));
    }

    @ParameterizedTest
    @CsvSource({
            "5 X, Lawn size must only be numbers",
            "5-2, The size of the lawn doesn't have the correct format (X X)",
            "2, The size of the lawn doesn't have the correct format (X X)"
    })
    void should_throw_exception_if_size_is_not_correct(String size, String message) {
        assertThatThrownBy(() -> lawn.setSize(size))
                .isInstanceOf(IncorrectSizeException.class)
                .hasMessage(message);
    }

    @Test
    void when_mower_overlaps_lawn_it_should_not_move() {
        lawn.setSize("2 2");
        Mower mower = new Mower();
        mower.setInitialPosition("2 2 N");
        lawn.addMower(mower);

        mower.move(Direction.A);

        assertThat(mower.getPosition()).isEqualTo(new Position(2, 2, Orientation.N));
    }

}
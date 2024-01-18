package fr.mowltnow;

import fr.mowltnow.data.Coordinates;
import fr.mowltnow.exceptions.IncorrectSizeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LawnTest {

    @Test
    void should_set_size_of_the_lawn() {
        Lawn lawn = new Lawn();

        lawn.setSize("5 5");

        assertThat(lawn.getSize()).isEqualTo(new Coordinates(5, 5));
    }

    @ParameterizedTest
    @CsvSource({
            "5 X",
            "5-2",
            "2"
    })
    void should_throw_exception_if_size_is_not_correct(String size) {
        Lawn lawn = new Lawn();

        assertThatThrownBy(() -> lawn.setSize(size))
                .isInstanceOf(IncorrectSizeException.class)
                .hasMessage("Incorrect size of the lawn");
    }
}
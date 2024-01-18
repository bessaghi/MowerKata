package fr.mowltnow.data;

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
            "5 X, Lawn size must only be numbers",
            "5-2, The size of the lawn doesn't have the correct format (X X)",
            "2, The size of the lawn doesn't have the correct format (X X)"
    })
    void should_throw_exception_if_size_is_not_correct(String size, String message) {
        Lawn lawn = new Lawn();

        assertThatThrownBy(() -> lawn.setSize(size))
                .isInstanceOf(IncorrectSizeException.class)
                .hasMessage(message);
    }

}
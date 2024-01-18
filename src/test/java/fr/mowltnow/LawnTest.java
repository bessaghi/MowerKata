package fr.mowltnow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LawnTest {

    @Test
    void should_set_size_of_the_lawn() {
        Lawn lawn = new Lawn();

        lawn.setSize("5 5");

        assertThat(lawn.getSize()).isEqualTo(new Coordinates(5, 5));
    }
}
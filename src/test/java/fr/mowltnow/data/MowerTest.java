package fr.mowltnow.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MowerTest {


    @Test
    void should_read_initial_position_of_the_mower() {
        Mower mower = new Mower();

        mower.setInitialPosition("1 2 N");

        assertThat(mower.getPosition()).isEqualTo(new Position(1, 2, Orientation.N));
    }

}
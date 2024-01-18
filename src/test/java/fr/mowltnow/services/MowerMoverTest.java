package fr.mowltnow.services;

import fr.mowltnow.data.Lawn;
import fr.mowltnow.data.Mower;
import fr.mowltnow.data.Orientation;
import fr.mowltnow.data.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MowerMoverTest {


    private final MowerMover mowerMover = new MowerMover();

    @ParameterizedTest
    @CsvSource({
            "1 2 N, GAGAGAGAA, 1, 3, N",
            "3 3 E, AADAADADDA, 5, 1, E"
    })
    void should_perform_a_list_of_movements(String position, String movements, int x, int y, Orientation orientation) {
        Lawn lawn = new Lawn("5 5");
        Mower mower = new Mower(position);
        lawn.addMower(mower);

        mowerMover.execute(movements, mower);

        assertThat(mower.getPosition()).isEqualTo(new Position(x, y, orientation));
    }

}
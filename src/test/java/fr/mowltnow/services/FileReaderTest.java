package fr.mowltnow.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FileReaderTest {

    private FileReader fileReader;

    @BeforeEach
    void setUp() {
        fileReader = new FileReader();
    }

    @Test
    void should_perform_movements_on_mower_from_file() {
        String actual = fileReader.execute("/example-movements.txt");

        assertThat(actual).isEqualTo("1 3 N 5 1 E");
    }

}
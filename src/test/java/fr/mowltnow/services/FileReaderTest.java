package fr.mowltnow.services;

import fr.mowltnow.exceptions.IncorrectSizeException;
import fr.mowltnow.exceptions.UnreadableFileException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void should_throw_exception_when_file_is_empty() {
        assertThatThrownBy(() -> fileReader.execute("/empty-file.txt"))
                .isInstanceOf(IncorrectSizeException.class)
                .hasMessage("You must introduce the size of the lawn");
    }

    @Test
    void should_throw_exception_when_file_doesnt_exist() {
        assertThatThrownBy(() -> fileReader.execute("/doesnt-exist.txt"))
                .isInstanceOf(UnreadableFileException.class)
                .hasMessage("Could not read file");
    }

}
package fr.mowltnow.services;

import fr.mowltnow.data.Lawn;
import fr.mowltnow.data.Mower;
import fr.mowltnow.data.Position;
import fr.mowltnow.exceptions.IncorrectSizeException;
import fr.mowltnow.exceptions.UnreadableFileException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static fr.mowltnow.utils.GlobalConstants.SEPARATOR;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;

public class FileReader {

    private final MowerMover mowerMover;

    public FileReader() {
        this.mowerMover = new MowerMover();
    }

    public String execute(String filePath) {

        List<String> instructions = readFile(filePath);

        Lawn lawn = instructions.stream().findFirst()
                .map(Lawn::new)
                .orElseThrow(() -> new IncorrectSizeException("You must introduce the size of the lawn"));

        for (int i = 1; i < instructions.size() - 1; i = i + 2) {
            Mower mower = new Mower(instructions.get(i));
            mowerMover.execute(instructions.get(i + 1), mower);
            lawn.addMower(mower);
        }

        return lawn.getMowers()
                .stream()
                .map(Mower::getPosition)
                .map(Position::toString)
                .collect(joining(SEPARATOR));
    }

    private static List<String> readFile(String filePath) {
        return ofNullable(FileReader.class.getResourceAsStream(filePath))
                .map(inputStream -> new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .map(BufferedReader::new)
                .map(BufferedReader::lines)
                .map(Stream::toList)
                .orElseThrow(UnreadableFileException::new);
    }
}

package com.tma.solutions.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility class for inputting.
 *
 * @author vnminh
 */
public final class InputUtils {

    /**
     * Cannot instantiate.
     */
    private InputUtils() {
    }

    /**
     * Collects input data from file path.
     *
     * @param filePath must be valid string.
     * @return List<String> commands.
     * @throws IOException if any error occurs.
     */
    public static List<String> collectInputFromFile(String filePath) throws IOException {

        List<String> inputs;

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            inputs = stream
                    .map(String::trim)
                    .filter(StringUtils::isNotNullAndNotEmpty)
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
        }

        return inputs;
    }
}

package ru.youarewrong.task6;

import org.junit.jupiter.api.Assertions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


class FileIterableTest {
    String[] getFileLines(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            Assertions.fail("Вызвано неожиданное исключение: " + e.getMessage());
        }
        String[] linesArray = new String[lines.size()];
        lines.toArray(linesArray);
        return linesArray;
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        String filePath = "test.txt";
        String[] correctLines = getFileLines(filePath);
        int i = 0;
        try (FileIterable fileIterable = new FileIterable(filePath)) {
            for (String line : fileIterable) {
                if (i >= correctLines.length) {
                    Assertions.fail("Разное количество элементов");
                }
                Assertions.assertEquals(correctLines[i], line);
                i++;
            }
            if (i != correctLines.length) {
                Assertions.fail("Разное количество элементов");
            }
        } catch (Exception e) {
            Assertions.fail("Вызвано неожиданное исключение: " + e.getMessage());
        }
    }
}
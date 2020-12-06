package ru.youarewrong.task6;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FileIterable implements Iterable<String>, AutoCloseable {

    private final FileIterator fileIterator;

    public FileIterable(String filePath) {
        fileIterator = new FileIterator(filePath);
    }

    /**
     * Возвращает итератор для прохода по файлу
     *
     * @return итератор для прохода по файлу
     */
    @Override
    public Iterator<String> iterator() {
        return fileIterator;
    }

    /**
     * Закрывает поток для чтения из файла
     *
     * @throws Exception если ресурс не может быть закрыт
     */
    @Override
    public void close() throws Exception {
        fileIterator.close();
    }

    private static class FileIterator implements Iterator<String>, AutoCloseable {
        private final BufferedReader reader;
        private String nextLine;

        public FileIterator(String filePath) {
            try {
                reader = new BufferedReader(new FileReader(filePath));
                nextLine = reader.readLine();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        /**
         * Проверяет есть ли следущая строка в файле
         *
         * @return результат проверки
         */
        @Override
        public boolean hasNext() {
            return nextLine != null;
        }

        /**
         * Возвращает следующую строку в файле
         *
         * @return следующая строка в файле
         * @throws NoSuchElementException если в файле закончились строки
         */
        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("В файле больше нет строк!");
            }
            try {
                String currentLine = nextLine;
                nextLine = reader.readLine();
                return currentLine;
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }

        }

        /**
         * Закрывает поток для чтения из файла
         *
         * @throws Exception если ресурс не может быть закрыт
         */
        @Override
        public void close() throws Exception {
            reader.close();
        }
    }
}

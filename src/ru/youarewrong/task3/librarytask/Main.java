package ru.youarewrong.task3.librarytask;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("War", "Ben Afflek"));
        System.out.println("Книга \"War\", \"Ben Afflek\" есть в библиотеке: " + library.containsBook("War", "Ben Afflek"));
        // Возврат книги
        library.addBook(new Book("Time", "Den Adron"));

        // Проверка наличия книги
        System.out.println("Книга \"Time\" \"Den Adron\" есть в библиотеке: " + library.containsBook("Time", "Den Adron"));
        System.out.println("Книга \"Sun and love\", \"Den Adron\" есть в библиотеке: " + library.containsBook("Sun and love", "Den Adron"));

        // Взятие книги из библиотеки
        var firstBook = library.getBook("Time", "Den Adron");
        System.out.println("\nКнига \"Time\" \"Den Adron\" есть в библиотеке: " + firstBook.isPresent());
        // Взятие книги из библиотеки
        var secondBook = library.getBook("Sun and love", "Den Adron");
        System.out.println("Книга \"Sun and love\" \"Den Adron\" есть в библиотеке: " + secondBook.isPresent());
    }
}

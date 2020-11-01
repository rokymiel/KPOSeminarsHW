package ru.youarewrong.task3.librarytask;

import java.util.ArrayList;
import java.util.Optional;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public Optional<Book> getBook(String name, String author) {
        var book = books.stream().filter(x -> name.equals(x.getName()) && author.equals(x.getAuthor()))
                .findAny();
        if(!book.isEmpty()){
            books.remove(book.get());
        }
        return book;
    }
    public void addBook(Book book){
        books.add(book);
    }
    public boolean containsBook(String name,String author){
        return books.stream().anyMatch(x->name.equals(x.getName()) && author.equals(x.getAuthor()));
    }
}

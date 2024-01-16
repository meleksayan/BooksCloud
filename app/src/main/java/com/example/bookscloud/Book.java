package com.example.bookscloud;

import com.google.firebase.firestore.DocumentReference;

public class Book {
    private String author_name;
    private String book_name;
    private String isbn;
    private String price;
    private String description;

    // Getter ve setter metotları



    public Book() {
        //empty constructor needed
    }

    public Book(String author_name, String book_name, String isbn, String price, String description) {
        this.author_name = author_name;
        this.book_name = book_name;
        this.isbn = isbn;
        this.price = price;
        this.description = description;
    }

    public String getauthor_name() {
        return author_name;
    }

    public String getbook_name() {
        return book_name;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }


    public void setauthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setbook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

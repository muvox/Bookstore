package com.a1704471.Bookstore.Bookstore.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    String title;
    String author;
    int year;
    String isbn;
    double price;

    public Book(){}

    public Book(String title, String author, int year, String isbn, double price) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
        this. isbn = isbn;
        this.price = price;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book: "+
                title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                '}';
    }
}

package com.a1704471.Bookstore.Bookstore;

import com.a1704471.Bookstore.Bookstore.domain.BookRepository;
import com.a1704471.Bookstore.Bookstore.domain.Category;
import com.a1704471.Bookstore.Bookstore.domain.CategoryRepository;
import com.a1704471.Bookstore.Bookstore.model.Book;
import com.a1704471.Bookstore.Bookstore.web.BookController;
import com.a1704471.Bookstore.Bookstore.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class BookstoreApplicationTests {


	@Autowired
    private BookRepository bookRepo;

	@Autowired
    private CategoryRepository catRepo;

	@Test
	public void createBook(){
		//String title, String author, int year, String isbn, double price, Category category
		Category testi = new Category("Test");
		catRepo.save(testi);

        Book book = new Book("Title1","Author authority",1990,"321-1234123",99.99,testi);
        bookRepo.save(book);

		assertThat(book.getId()).isNotNull();
		assertThat(book.getTitle()).isEqualTo("Title1");
	}

	@Test
	public void searchBook(){
        Category testi = new Category("Test");
        catRepo.save(testi);

        Book book = new Book("Title2","Author authority",1990,"321-1234123",99.99,testi);
        bookRepo.save(book);
	    List<Book> books = bookRepo.findByTitle("Title2");

	    assertThat(books).hasSize(1);
	    assertThat(books.get(0).getTitle()).isEqualTo("Title2");

	}

	@Test
	public void deleteBook(){
        Category testi = new Category("Test");
        catRepo.save(testi);

        Book book = new Book("Title3","Author authority",1990,"321-1234123",99.99,testi);
        bookRepo.save(book);
        List<Book> books = bookRepo.findByTitle("Title3");
        bookRepo.delete(books.get(0));

        List<Book> uusiLista = bookRepo.findByTitle("Title3");

        assertThat(uusiLista).hasSize(0);

    }
}

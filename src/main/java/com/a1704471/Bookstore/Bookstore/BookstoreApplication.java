package com.a1704471.Bookstore.Bookstore;

import com.a1704471.Bookstore.Bookstore.domain.BookRepository;
import com.a1704471.Bookstore.Bookstore.domain.Category;
import com.a1704471.Bookstore.Bookstore.domain.CategoryRepository;
import com.a1704471.Bookstore.Bookstore.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

    private static Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
    public CommandLineRunner insertTestData(BookRepository repo, CategoryRepository catrepo){
	    return (args) -> {
	        log.info("Inserting couple books");

	        /**
             * title, autho, year, isbn, price
             * string,string,int,string,double
             */
	        Category action = new Category("Action");
	        Category drama = new Category("Drama");
	        Category manga = new Category("Manga");

	        catrepo.save(action);
	        catrepo.save(drama);
	        catrepo.save(manga);



	        repo.save(new Book("Berserk","Kentaro Miura",2003,"978-1593070205",11.95,manga ));
            repo.save(new Book("The Blade Itself","Joe Abercrombie", 2015, "978-0316387316", 8.79,action ));
            repo.save(new Book("Before They Are Hanged" ,"Joe Abercrombie",2015,"978-0316387354", 10.39 , action));
            log.info("Fetcing all book info");

            for(Book book : repo.findAll()){
                log.info(book.toString());
            }
        };
    }
}

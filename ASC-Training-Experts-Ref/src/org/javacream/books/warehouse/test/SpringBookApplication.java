package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBookApplication {

	public static void main(String[] args) throws BookException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("books.warehouse.xml");
		BooksService booksService = context.getBean(BooksService.class);
		TestActor.doTest(booksService);
		System.out.println(booksService.newBook("HUGO"));
		context.close();
	
	}

}

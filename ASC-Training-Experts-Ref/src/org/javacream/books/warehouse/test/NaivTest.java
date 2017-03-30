package org.javacream.books.warehouse.test;

import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.junit.Test;

public class NaivTest {

	@Test(expected=NullPointerException.class) public void testMapBooksService() throws BookException{
		MapBooksService mapBooksService = new MapBooksService();
		mapBooksService.newBook("Geht eh nicht");
	}
}

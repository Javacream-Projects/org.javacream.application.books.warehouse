package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.Test;

/**
 * 
 * @author Dr. Rainer Sawitzki
 * @company Javacream
 * @mailto training@rainer-sawitzki.de
 * 
 */
public class BooksServiceTest {

	@Test
	public void testBusinessObjects() {
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		SimpleStoreService simpleStoreService = new SimpleStoreService();
		
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(simpleStoreService);
		
		randomIsbnGenerator.setPrefix("TEST:");
		randomIsbnGenerator.setCountryCode("-de");
		
		simpleStoreService.setStock(42);
		
		TestActor.doTest(mapBooksService);
		
	
	}

	

}

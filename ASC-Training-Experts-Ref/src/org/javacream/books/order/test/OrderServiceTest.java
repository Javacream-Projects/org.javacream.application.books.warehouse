package org.javacream.books.order.test;

import java.util.HashMap;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.impl.SimpleOrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceTest {

	private OrderService orderService;

	@Before
	public void init() {
		SimpleOrderService simpleOrderService = new SimpleOrderService();
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		randomIsbnGenerator.setCountryCode("-de");
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		SimpleStoreService simpleStoreService = new SimpleStoreService();
		simpleStoreService.setStock(50);
		HashMap<String, Book> books = new HashMap<>();
		Book book = new Book();
		book.setIsbn("ISBN1");
		book.setTitle("Title1");
		book.setPrice(19.99);
		books.put("ISBN1", book);
		book = new Book();
		book.setIsbn("ISBN2");
		book.setTitle("Title2");
		book.setPrice(9.99);
		books.put("ISBN2", book);
		mapBooksService.setBooks(books);
		mapBooksService.setStoreService(simpleStoreService);
		randomIsbnGenerator.setPrefix("TEST:");
		simpleOrderService.setBooksService(mapBooksService);
		simpleOrderService.setStoreService(simpleStoreService);
		orderService = simpleOrderService;
	}

	@Test
	public void createOrderOk() {
		Order order = orderService.order("ISBN1", 20);
		Assert.assertTrue(order.getStatus() == OrderStatus.OK);
	}

	@Test
	public void createOrderPending() {
		Order order = orderService.order("ISBN1", 100);
		Assert.assertTrue(order.getStatus() == OrderStatus.PENDING);
	}

	@Test
	public void createOrderUnavailable() {
		Order order = orderService.order("##ISBN2##", 20);
		Assert.assertTrue(order.getStatus() == OrderStatus.UNACCEPTABLE);
	}

}

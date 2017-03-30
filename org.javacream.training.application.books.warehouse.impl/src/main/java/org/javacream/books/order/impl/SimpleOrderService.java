package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
public class SimpleOrderService implements OrderService {
	
	private BooksService booksService;
	private StoreService storeService;
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	@Override
	public Order order(String isbn, int amount){
		OrderStatus orderStatus;
		double totalPrice = 0.0;
		try{
			Book book = booksService.findBookByIsbn(isbn);
			totalPrice = book.getPrice() * amount;
			if (storeService.getStock("books", isbn) >= amount){
				orderStatus = OrderStatus.OK;
			}else{
				orderStatus = OrderStatus.PENDING;
			}
		}catch(BookException e){
			orderStatus = OrderStatus.UNACCEPTABLE;
		}
		
		return new Order(isbn, totalPrice, orderStatus, amount);
	}

}

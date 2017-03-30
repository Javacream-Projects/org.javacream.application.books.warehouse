package org.javacream.books.order.test;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:modules_with_alias/order-application.xml")
public class OrderServiceSpringTest {

	@Autowired
	private OrderService orderService;

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

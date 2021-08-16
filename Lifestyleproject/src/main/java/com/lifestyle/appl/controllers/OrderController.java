package com.lifestyle.appl.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lifestyle.appl.beans.Order;
import com.lifestyle.appl.beans.OrderItem;
import com.lifestyle.appl.beans.User;
import com.lifestyle.appl.beans.orderDetails;
import com.lifestyle.appl.services.CartItemService;
import com.lifestyle.appl.services.OrderItemService;
import com.lifestyle.appl.services.OrderService;
import com.lifestyle.appl.services.UserService;

@CrossOrigin(origins = "*")
@RequestMapping("/lifestyle")
@RestController // (@controller +@responseBody
public class OrderController {

	@Autowired
	UserService userService;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderItemService orderItemService;

	@Autowired
	CartItemService cartItemService;

	@PostMapping("/placeorder/{userId}")
	public void getAllCartItemsByUserId(@PathVariable("userId") int userId, @RequestBody orderDetails orderdetails) {

		Order order = new Order();
		order = orderdetails.getOrder();

		List<OrderItem> orderitems = new ArrayList<OrderItem>();
		orderitems = orderdetails.getOrderitem();

		User user = userService.getUserByUserId(userId);

		order.setUser(user);
		order.getAddress().setUser(user);

		orderService.addOrder(order);

		for (OrderItem orderitem : orderitems) {
			orderitem.setOrder(order);
			orderItemService.addOrderItem(orderitem);

		}

		cartItemService.delteCartItemByUserId(userId);
	}

	// http://localhost:8090/api/lifestyle/order
	@GetMapping("/order")
	public List<Order> getOrdList() {
		System.out.println("Inside Controller");
		List<Order> ordList = orderService.viewOrder();
		return ordList;
	}

	@GetMapping("/orders/{userid}")
	public List<Order> getOrdList(@PathVariable("userid") int userid) {
		return orderService.getOrdersByUser(userid);

	}

	@GetMapping("/orderitems/{orderid}")
	public List<OrderItem> getOrderItemsByOrderId(@PathVariable("orderid") int orderid) {
		return orderItemService.getOrderItemByOrderId(orderid);
	}

}
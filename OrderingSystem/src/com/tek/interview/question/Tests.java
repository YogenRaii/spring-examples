package com.tek.interview.question;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Tests {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	Map<String, Order> o;
	
	@Before
	public void init() throws Exception{
		o = new HashMap<String, Order>();

		Order c = new Order();
		
		c.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c.add(new OrderLine(new Item("chocolate bar", (float) 0.845), 1));

		o.put("Order 1", c);

		// Reuse cart for an other order
		Order c1 = new Order();

		c1.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c1.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		o.put("Order 2", c1);

		// Reuse cart for an other order
		Order c2 = new Order();

		c2.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		c2.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		c2.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		c2.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));

		o.put("Order 3", c2);
	}
	
	@Test
	public void testOrder(){
		assertEquals(o.size(),3);
		assertTrue(o.get("Order 1").get(0).getQuantity()>0);
		assertEquals(o.get("Order 1").get(0).getItem().getDescription(),"book");
	}
	
	
	
	@Test
	public void testOrderLine() throws Exception{
		thrown.expect(Exception.class);
		thrown.expectMessage("Item is NULL");
		
		Item item = null;
		OrderLine orderLine = new OrderLine(item, 10);
				
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void testAddOrder() throws Exception {
		
        OrderLine orderLine = null;
        Order order = new Order();
        order.add(orderLine);
    }

}

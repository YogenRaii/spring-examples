package com.tek.interview.question;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Calculator {

	public static double rounding(double value) {
		return ( (int) (value * 100)) / 100;
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;
		Map<String, Order> treeMap = new TreeMap<String, Order>(o);
		// Iterate through the orders
		for (String key : treeMap.keySet()) {
			System.out.println("*******" + key + "*******");
			Order r = o.get(key);

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) {

				// Calculate the taxes
				double tax = 0;

				if (r.get(i).getItem().getDescription().toLowerCase().contains("imported")) {
					tax = r.get(i).getItem().getPrice() * 0.15; // Extra 5% tax on
					// imported items
				} else {
					tax = r.get(i).getItem().getPrice() * 0.10;
				}

				// Calculate the total price
				double totalprice = r.get(i).getItem().getPrice() + Math.ceil(tax * 100.00) / 100.00;

				// Print out the item's total price
				System.out.println("1 "+ r.get(i).getItem().getDescription() + ": " + Math.ceil(totalprice*100.00)/100.00);

				// Keep a running total
				totalTax += tax;
				total += r.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + Math.ceil(totalTax*100.00)/100.00);
			
			System.out.println("Total: " + Math.ceil(total * 100.00) / 100.00);
			
			// Print out the total amount
				grandtotal += total;
			total = total + totalTax;
			
		}

		System.out.println("Sum of orders: " + Math.ceil(grandtotal * 100.0) / 100.0);
	}
}
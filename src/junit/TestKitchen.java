/**
* Test the calculation of order prepare time and unsold fries with three scenarios:
* 1. prepare time with no unsold fries in the kitchen
* 2. prepare time with unsold fries in the kitchen
* 3. final unsold fries count after taking two orders
* 
* @author ChristinaTu
**/

package junit;

import partB.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestKitchen {

	Kitchen kitchen;
	Order order;
	Food burrito;
	Food fries;
	Food soda;

	@Before
	public void setUp() throws Exception {
		kitchen = new Kitchen();
		burrito = new Burrito("Burrito", 7);
		fries = new Fries("Fries", 4);
		soda = new Soda("Soda", 2.5);
	}

	@Test
	public void prepareTimeWithNoUnsoldFries() {
		// final order has 3 Burrito, 1 Fries
		order = new Order();
		order.addtoOrder(burrito, 3);
		order.addtoOrder(fries, 1);
		order.addtoOrder(soda, 1);

		assertEquals(18, kitchen.getPrepareTime(order), 0);
	}

	@Test
	public void prepareTimeWithUnsoldFries() {
		// first order has 3 Burrito, 1 Fries, 1 soda
		order = new Order();
		order.addtoOrder(burrito, 3);
		order.addtoOrder(fries, 1);
		kitchen.getPrepareTime(order);

		// second order has 2 Burrito, 12 Fries
		order = new Order();
		order.addtoOrder(burrito, 2);
		order.addtoOrder(fries, 12);

		assertEquals(16, kitchen.getPrepareTime(order), 0);
	}

	@Test
	public void finalUnsoldFries() {
		// first order has 3 Burrito, 1 Fries, 1 soda
		order = new Order();
		order.addtoOrder(burrito, 3);
		order.addtoOrder(fries, 1);
		kitchen.getPrepareTime(order);

		// second order has 2 Burrito, 12 Fries
		order = new Order();
		order.addtoOrder(burrito, 2);
		order.addtoOrder(fries, 12);
		kitchen.getPrepareTime(order);
		
		assertEquals(2, kitchen.getUnsoldFries(), 0);
	}

}

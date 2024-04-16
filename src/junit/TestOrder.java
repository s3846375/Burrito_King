/**
* Test the calculation of total cost of the order with three scenarios:
* 1. total cost without meals
* 2. total cost when ordering same food
* 3. total cost when ordering meals
* 
* @author ChristinaTu
**/


package junit;

import partB.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class TestOrder {
	List<Food> foods;
	Order order;
	
	@Before
	public void setUp() throws Exception {	
		foods = new ArrayList<>();
		foods.add(new Burrito("Burrito", 7));
		foods.add(new Fries("Fries", 4));
		foods.add(new Soda("Soda", 2.5));
	}

	@Test
	public void totalCostWithoutMeal() {
		//order 1 Burrito, 2 Fries
		order = new Order();
		order.addtoOrder(foods.get(0), 1);
		order.addtoOrder(foods.get(1), 2);		
		assertEquals(15, order.getTotalCost(), 0);
	}

	@Test
	public void totalCostOrderSameFood() {
		//order 1 Burrito, 1 Fries, 1 Soda, 2 Burrito
		order = new Order();
		order.addtoOrder(foods.get(0), 1);
		order.addtoOrder(foods.get(1), 1);	
		order.addtoOrder(foods.get(2), 1);
		order.addtoOrder(foods.get(0), 2);
		assertEquals(27.5, order.getTotalCost(), 0);
	}
	
	@Test
	public void totalCostWithMeal() {
		//order 1 Burrito, 5 Fries, 2 Meal
		order = new Order();
		order.addtoOrder(foods.get(0), 1);
		order.addtoOrder(foods.get(1), 5);
		order.addMealCount(2);
		for (Food f : foods) {
			order.addtoOrder(f, 2);
		}		
		assertEquals(48, order.getTotalCost(), 0);
	}
	
}

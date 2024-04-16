/**
 * Order class represents an order that holds the ordered food items and quantity.
 * Keeps track of the number of meals in the order and calculates the total cost. 
 * 
 * @author ChristinaTu
 */

package partB;
import java.util.*;

public class Order {

	private Map<Food, Integer> orderMap = new HashMap<>();
	private int mealCount = 0;
	
	/**
	 * Add food items to the order and accumulates the quantities of the same food item.
	 */
	public void addtoOrder(Food foodItem, int qty) {
		if (!orderMap.containsKey(foodItem)) {
			orderMap.put(foodItem, qty);
		} else
			orderMap.put(foodItem, orderMap.get(foodItem) + qty);
	}

	/**
	 * Displays the food items and total cost of the order.
	 */
	public void printOrder() {
		String summary = "";
		for (Map.Entry<Food, Integer> map : orderMap.entrySet()) {
			summary += map.getValue() + " " + map.getKey().getName() + ", ";
		}
		System.out.println("Total cost for " + summary + "is: $" + getTotalCost());
	}

	
	/**
	 * Calculate the total cost of the order.
	 */
	public double getTotalCost() {
		double totalCost = 0.0;
		for (Map.Entry<Food, Integer> map : orderMap.entrySet()) {
			totalCost += map.getKey().getPrice() * map.getValue();
		}
		totalCost -= getMealCount() * 3;
		return totalCost;
	}
	
	
	public Map<Food, Integer> getOrderMap() {
		return orderMap;
	}

	
	/**
	 * Keep track of the number of meals in the order
	 */
	public void addMealCount(int qty) {
		mealCount += qty;
	}
	
	public int getMealCount() {
		return mealCount;
	}

}

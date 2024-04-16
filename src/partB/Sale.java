/**
* Sale class Represents all the sold food items and quantities of the restaurant.
* Keeps track of the total count of meals sold and calculates the total revenue
* 
* @author ChristinaTu
**/

package partB;

import java.util.*;

public class Sale {

	private Map<Food, Integer> saleMap = new HashMap<>();
	private int mealCount = 0;

	/**
	 * Add food items to the sales and accumulates the quantities of the same food
	 * item.
	 */
	public void addtoSale(Food foodItem, int qty) {
		if (!saleMap.containsKey(foodItem)) {
			saleMap.put(foodItem, qty);
		} else
			saleMap.put(foodItem, saleMap.get(foodItem) + qty);
	}

	public int getMealCount() {
		return mealCount;
	}

	/**
	 * Keeps track of the total count of meals sold
	 */
	public void addMealCount(int mealCount) {
		this.mealCount += mealCount;
	}

	public Map<Food, Integer> getSaleMap() {
		return saleMap;
	}

}

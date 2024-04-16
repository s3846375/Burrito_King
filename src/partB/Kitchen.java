/**
 * Kitchen class is responsible of calculating the preparation time for each order and Keeping track of the unsold fries.
 * 
 * @author ChristinaTu
 */

package partB;

import java.util.*;

public class Kitchen {

	private int unsoldFries = 0;

	/**
	 * Calculates the preparation time for the order passed to the kitchen.
	 */
	public double getPrepareTime(Order order) {
		double prepareTime = 0.0;

		Map<Food, Integer> orderMap = order.getOrderMap();
		for (Map.Entry<Food, Integer> map : orderMap.entrySet()) {

			if (map.getKey() instanceof Burrito)
				prepareTime = Math.max(prepareTime, getBurritoTime(map.getValue()));

			else if (map.getKey() instanceof Fries)
				prepareTime = Math.max(prepareTime, getFriesTime(map.getValue()));
		}
		return prepareTime;
	}

	/**
	 * Calculates the preparation time for burritos.
	 */
	public double getBurritoTime(int qty) {
		return Math.ceil(qty / 2.0) * 9;
	}

	/**
	 * Calculates the preparation time for fries and keep track of the unsold fries.
	 */
	public double getFriesTime(int qty) {
		double friesTime = 0.0;
		if (qty <= unsoldFries) {
			unsoldFries = unsoldFries - qty;
			friesTime = 0.0;
		} else {
			if ((qty - unsoldFries) % 5 == 0) {
				friesTime = ((qty - unsoldFries) / 5) * 8;
				unsoldFries = 0;
			} else {
				friesTime = Math.ceil((qty - unsoldFries) / 5.0) * 8;
				unsoldFries = 5 - (qty - unsoldFries) % 5;
			}
		}
		return friesTime;
	}

	public int getUnsoldFries() {
		return unsoldFries;
	}

}

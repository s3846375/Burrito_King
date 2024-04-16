/**
 * 
 * This is the main program that loops through restaurant managing options of: 
 * Ordering food, displaying sales report and updating food price.
 * 
 * @author ChristinaTu
 *
 */

package partB;

import java.util.*;

public class ManageRestaurant {

	private Kitchen kitchen;
	private Sale sales;
	private List<Food> foods;
	Order order;
	private Scanner scan;

	/**
	 * Constructor: creates the Kitchen, Sales report and initiates the food list.
	 */
	public ManageRestaurant() {
		kitchen = new Kitchen();
		sales = new Sale();
		foods = new ArrayList<>();
		foods.add(new Burrito("Burrito", 7));
		foods.add(new Fries("Fries", 4));
		foods.add(new Soda("Soda", 2.5));
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		ManageRestaurant mr = new ManageRestaurant();
		mr.mainMenu();
	}
	
	/**
	 * Main menu loop to handle user input for menu options
	 */
	public void mainMenu() {
		boolean valid = false;
		int choice = 0;
		do {
			System.out.println("[[Please Select option]]");
			System.out.println("1. Order ");
			System.out.println("2. Show Sales Report ");
			System.out.println("3. Update Price ");
			System.out.println("4. Exit ");
			System.out.println("------------------------");
			System.out.println("Your choice: ");
			try {
				choice = Integer.parseInt(scan.nextLine());
				switch (choice) {
				case 1:
					performOrder();
					break;
				case 2:
					printSales();
					break;
				case 3:
					performUpdateP();
					break;
				case 4:
					valid = true;
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid input!");
				}
			} catch (Exception e) {
				System.out.println("Invalid input!");
			}
		} while (!valid);
	}

	/**
	 * Print out the food list and price (Meals not included).
	 */
	public void printFood() {
		System.out.println("======Food Menu======");
		for (Food f : foods)
			System.out.printf("%-1d. %-10s $%-5.2f\n", (foods.indexOf(f) + 1), f.getName(), f.getPrice());
	}

	/**
	 * Create a new Order and prompt users to input food item and quantity. Feedback
	 * the total cost and prepare time of the order. Update the order to the sales
	 * report.
	 * 
	 */
	public void performOrder() {

		order = new Order();
		String respond = "N";
		int choice = 0;
		int qty = 0;

		do {
			System.out.println("[[Select item to order]]");
			printFood();
			System.out.printf("%-1d. %-10s $%-5.2f\n", 4, "Meal", 10.5);
			System.out.println("=====================");

			System.out.println("Your choice: ");
			choice = validFood();

			System.out.print("Enter order quantity: ");
			qty = validQty();

			if (choice == 4) { // add Meal to the order
				order.addMealCount(qty);
				for (Food f : foods) {
					order.addtoOrder(f, qty);
				}
			} else { // add single food item to the order
				order.addtoOrder(foods.get(choice - 1), qty);
			}
			System.out.println("Continue order? (Y/N)");
			respond = validRespond();

		} while (respond.equalsIgnoreCase("Y"));

		// Display total order items and total cost
		order.printOrder();

		// Handle payment
		makePayment(order.getTotalCost());

		// Display total prepare time for the order
		System.out.println("The food will be ready in: " + kitchen.getPrepareTime(order) + "min");

		// Add the order to the sales report
		for (Map.Entry<Food, Integer> entry : order.getOrderMap().entrySet()) {
			Food key = entry.getKey();
			int value = entry.getValue();
			sales.addtoSale(key, value);
		}
		// Add Meal count to the sales report
		sales.addMealCount(order.getMealCount());
	}

	/**
	 * Get input from food options
	 */
	public int validFood() {
		boolean valid = false;
		int validFood = 0;
		do {
			try {
				validFood = Integer.parseInt(scan.nextLine());
				if (validFood > 0 && validFood < 5)
					valid = true;
				else
					System.out.println("Not in food option! Please choose again:");
			} catch (NumberFormatException e) {
				System.out.println("Not in food option! Please choose again:");
			}
		} while (!valid);
		return validFood;
	}

	/**
	 * Get valid input quantity (is an integer and > 0)
	 */
	public int validQty() {
		boolean valid = false;
		int validInt = 0;
		do {
			try {

				validInt = Integer.parseInt(scan.nextLine());
				if (validInt > 0)
					valid = true;
				else
					System.out.println("Invalid input! Please enter quantity:");
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter quantity:");
			}
		} while (!valid);
		return validInt;
	}

	/**
	 * Get valid input that is an double and > 0
	 */
	public double validDouble() {
		boolean valid = false;
		double validDouble = 0;
		do {
			try {
				validDouble = Double.parseDouble(scan.nextLine());
				if (validDouble > 0)
					valid = true;
				else
					System.out.println("Invalid input! Please enter again:");
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter again:");
			}
		} while (!valid);
		return validDouble;
	}

	/**
	 * Get valid respond of Y or N
	 */
	public String validRespond() {
		boolean valid = false;
		String validRespond = "N";
		do {
			try {
				validRespond = scan.nextLine().trim().toUpperCase();
				if (validRespond.equals("Y") || validRespond.equals("N"))
					valid = true;
				else
					System.out.println("Please enter Y or N :");
			} catch (Exception e) {
				System.out.println("Please enter Y or N :");
			}
		} while (!valid);
		return validRespond;
	}

	/**
	 * Handle the payment of the order.
	 */
	public void makePayment(double totalCost) {
		double payment = 0.0;
		do {
			System.out.println("Please enter payment: ");
			payment = validDouble();
			if (payment >= totalCost)
				System.out.println("Change returned: $" + (payment - totalCost));
			else
				System.out.println("Sorry, that’s not enough to pay for order");
		} while (payment < totalCost);
	}

	/**
	 * Prompt users to select food item and input update price.
	 */
	public void performUpdateP() {
		int choice = 0;
		double updatePrice = 0.0;
		do {
			System.out.println("[[Select item to update price]] ");
			printFood();
			System.out.println("4. Done ");
			System.out.println("=====================");

			System.out.println("Your choice: ");
			choice = validFood();
			if (choice < (foods.size() + 1)) {
				System.out.println("Enter update price :");
				updatePrice = validDouble();
				foods.get(choice - 1).updatePrice(updatePrice);
			}
		} while (choice != 4);
	}

	/**
	 * Display the total sold food items, quantity and revenue.
	 */
	public void printSales() {
		System.out.println("===== Sales Report =======");
		System.out.println("Unsold Serves of Fries: " + kitchen.getUnsoldFries());
		System.out.println("Total Sales:");

		double totalCost = 0.0;
		for (Map.Entry<Food, Integer> map : sales.getSaleMap().entrySet()) {
			totalCost += map.getKey().getPrice() * map.getValue();

			System.out.printf("%-10s %-5d $%-5.2f\n", map.getKey().getName(), map.getValue(),
					map.getKey().getPrice() * map.getValue());
		}
		// Deduct the meal discount
		totalCost -= sales.getMealCount() * 3;

		System.out.printf("%-10s %-3d %3s%-10.2f\n", "Meal", sales.getMealCount(), "-$", sales.getMealCount() * 3.0);
		System.out.println("---------------------------");
		System.out.printf("%18s%-10.2f\n\n", "$", totalCost);
	}

	

}

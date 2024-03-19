package partA;
import java.util.*;

/**
 



**/

public class ManageSales {

	private List<Food> foods = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();
	private Scanner scan = new Scanner(System.in);

	public ManageSales() {
		foods.add(new Burrito("Burrito", 7));
		foods.add(new Fries("Fries", 4, 0));
		foods.add(new Soda("Soda", 2.5));
	}

	public void printFood() {
		System.out.println("===Food Menu===");
		for (Food f : foods)
			System.out.printf("%-1d. %-10s $%-5.2f\n", (foods.indexOf(f) + 1), f.getName(), f.getPrice());
	}

	public void controller() {
		int choice;
		do {
			System.out.println("[[Please Select option]]");
			System.out.println("1. View Food Menue ");
			System.out.println("2. Order ");
			System.out.println("3. Show Sales Report ");
			System.out.println("4. Update Price ");
			System.out.println("5. Exit ");
			System.out.println("-----------------------");
			System.out.println("Your choice: ");
			choice = Integer.parseInt(scan.nextLine());
			if (choice > 5)
				System.out.println("No such option!");
			if (choice == 1)
				printFood();
			if (choice == 2)
				performOrder();
			if (choice == 3)
				printSales();
			if (choice == 4)
				performUpdateP();
		} while (choice != 5);
	}

	/**
	 * // Recored each order into the order list // Summarizes the current order
	 * items (not able to order same type food twice) // Verify the payment
	 * // Notify the waiting time
	 **/
	public void performOrder() {
		int itemCount = 0;
		String summary = "";
		double totalCost = 0.0;
		double prepareTime = 0.0;

		int choice;
		do {
			System.out.println("[[Select item to order]]");
			printFood();
			System.out.println((foods.size() + 1) + ". Done ");
			System.out.println("----------------------------");
			System.out.println("Your choice: ");
			choice = Integer.parseInt(scan.nextLine());
			if (choice < (foods.size() + 1)) {
				System.out.print("Enter order quantity: ");
				int qty = Integer.parseInt(scan.nextLine());
				double cost = foods.get(choice - 1).order(qty);
				prepareTime = Math.max(prepareTime,foods.get(choice - 1).getPrepareTime(qty));
				itemCount++;
				orders.add(new Order(foods.get(choice - 1).getName(), qty, cost));
			}
		} while (choice != (foods.size() + 1));

		for (int i = orders.size() - itemCount; i < orders.size(); i++) {
			summary += orders.get(i).getQty() + " " + orders.get(i).getName() + ", ";
			totalCost += orders.get(i).getCost();
		}

		System.out.println("Total cost for " + summary + "is: $" + totalCost);
		
		// Verify the payment
		double payment = 0.0;
		do {
			System.out.println("Please enter payment: ");
			payment = Double.parseDouble(scan.nextLine());
			if (payment >= totalCost)
				System.out.println("Change returned: $" + (payment - totalCost));
			else
				System.out.println("Sorry, that’s not enough to pay for order");
		} while (payment < totalCost);

		// Notify the waiting time
		System.out.println("The food will be ready in: " + prepareTime + "min");
      
		
	}

	public boolean getPayment(double cost, double pay) {
		boolean result = false;
		if (pay >= cost) {
			result = true;
		}
		return result;
	}

	public void printAllorders() {
		Iterator<Order> it = orders.iterator();
		while (it.hasNext()) {
			Order o = it.next();
//			System.out.println(o.getName() + ", " + o.getQty() + ", " + o.getCost());
			System.out.printf("%-8s ,%-3d,$%-10.2f\n", o.getName(), o.getQty(), o.getCost());
		}
	}

	public void performUpdateP() {
		int choice;
		do {
			System.out.println("[[Select item to update price]] ");
			printFood();
			System.out.println((foods.size() + 1) + ". Done ");
			System.out.println("----------------------------");
			System.out.println("Your choice: ");
			choice = Integer.parseInt(scan.nextLine());
			if (choice < (foods.size() + 1)) {
				System.out.println("Enter update price :");
				double updateP = Double.parseDouble(scan.nextLine());
				foods.get(choice - 1).updatePrice(updateP);
			}
		} while (choice != (foods.size() + 1));

	}

	// print total sales for Order
	public void printSales() {
		System.out.println("Unsold Serves of Fries: " + " getFriesUnsold()");
		System.out.println("Total Sales:");
		System.out.println("Unsold Serves of Fries: " + " getBurritoSold()");
		System.out.println("Unsold Serves of Fries: " + " getFriesSold()");
		System.out.println("Unsold Serves of Fries: " + " getSodaSold()");
		System.out.println("-------------------------");
		System.out.println("Unsold Serves of Fries: " + " getTotalSale()" + " getFriesUnsold()");

	}

	public static void main(String[] args) {
		ManageSales ms = new ManageSales();
		ms.controller();
		System.out.println("All orders today:");
		ms.printAllorders();

	}

}

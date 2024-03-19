package partA;
import java.util.*;

public class Order {

	// arrylist size to track size of order list

//	private String orderID;
	private String name;
	private int qty;
	private double cost;

	public Order(String name, int qty, double cost) {
		this.name = name;
		this.qty = qty;
		this.cost = cost;
	}

	public String getName() {
		return this.name;
	}

	public int getQty() {
		return this.qty;
	}

	public double getCost() {
		return this.cost;
	}

//	public void printAllOrders(List<Order> orders) {
//		Iterator<Order> it = orders.iterator();
//		while (it.hasNext()) {
//			Order o = it.next();
//			System.out.println(o.getName()+ ", " + o.getQty() + ", " + o.getCost());
//		}
//	}

	public void printTotalSale() {

	}

	public static void main(String[] args) {
		List<Order> orders = new ArrayList<>();

		orders.add(new Order("Burrito",7, 45));
		orders.add(new Order("Fries", 4, 10));
		orders.add(new Order("Soda",1, 2.5));
		orders.add(new Order("Fries", 2, 10));
		
		Iterator<Order> it = orders.iterator();
		while (it.hasNext()) {
			Order o = it.next();
			System.out.println(o.getName()+ ", " + o.getQty() + ", " + o.getCost());
		}
		
//		Order[] order = new Order[3];
//
//		order[0] = new Order( "Burrito", 3, 9.5);
//		order[1] = new Order( "Fries", 2, 6.2);
//		order[2] = new Order( "Soda", 1, 2.5);
//
//		String item = "";
//		double totalCost = 0.0;
//
//		for (int i = 0; i < 3; i++) {
//			item += order[i].getName() + ", ";
//			totalCost += order[i].getCost();
//		}
//
//		System.out.println("Total cost for " + item + "is: " + totalCost);

	}

}

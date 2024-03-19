package partA;
import java.util.Scanner;

abstract class Food {
	private String name;
	private double price;
//	private double prepare;

	private Scanner scan = new Scanner(System.in);

	public Food(String name, double price) {
		this.name = name;
		this.price = price;
//		this.prepare = prepare;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public void updatePrice(double updateP) {
		this.price = updateP;

	}

	public double order(int qty) {
		return qty * this.price;
	}

	public double getPrepareTime(int qty) {
		return 0.0 * qty;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

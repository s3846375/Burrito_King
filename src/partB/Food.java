
/**
* Food class represents a type of food item with a name and price as constructor parameters. 
* Contains a method that updates the price of the food item to the taken argument value
* 
* @author ChristinaTu
*/

package partB;

public abstract class Food {
	protected String name;
	protected double price;

	public Food(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public abstract void updatePrice(double updateP);
}

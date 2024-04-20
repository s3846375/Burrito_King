/**
 * Subclasses of Food class that represents a specific type of food item.
 * 
 * @author ChristinaTu
 */

package partB;

public class Soda extends Food {

	public Soda(String name, double price) {
		super(name, price);
	}
	@Override
	public void updatePrice(double newPrice) {
		this.price = newPrice;
	}
}


/**
 * Subclasses of Food class that represents a specific type of food item.
 *
 * @author ChristinaTu
 */

package partB;

public class Burrito extends Food {

    public Burrito(String name, double price) {
        super(name, price);
    }

    @Override
    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }
}

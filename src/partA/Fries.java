package partA;

public class Fries extends Food {

	private int unsold;

	public Fries(String name, double price, int unsold) {
		super(name, price);
		this.unsold = unsold;
	}

	@Override
	// takes 8 minutes to prepare 5 at the same time
	public double getPrepareTime(int qty) {
		double preparT = 0.0;
		if (qty <= this.unsold) {
			this.unsold = this.unsold - qty;
			preparT = 0.0;
		} else {
			if ((qty - this.unsold) % 5 == 0) {
				preparT = ((qty - this.unsold) / 5) * 8;
				this.unsold = 0;
			} else {
				preparT = (qty - this.unsold + 4) / 5 * 8; //adding 4 to perform ceiling rounding 
				this.unsold = 5 - (qty - this.unsold) % 5;
			}
		}
		return preparT;
	}

	public int getUnsold() {
		return this.unsold;
	}

	public static void main(String[] args) {
		Fries f = new Fries("Fries",10,4);
		System.out.println(f.getPrepareTime(5));
//		System.out.println(f.getPrepareTime(7));

	}

}

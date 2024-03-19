package partA;

class Burrito extends Food {

	public Burrito(String name, double price) {
		super(name, price);
	}

	@Override
	// take 9 minutes to prepare, up to 2 at the same time
	public double getPrepareTime(int qty) {
		if (qty % 2 == 0)
			return (qty / 2) * 9;
		else
			return ((qty + 1) / 2) * 9;
	}

	public static void main(String[] args) {
		Burrito b = new Burrito("Burrito", 10);
		System.out.println(b.getPrepareTime(6));
		System.out.println(b.getPrepareTime(7));

	}

}

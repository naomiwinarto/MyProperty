public class Mansion extends Property{
	private int floor, pool;

	public Mansion(String name, String type, String address, int quantity, int floor, int pool,
			long startingPrice) {
		super(name, type, address, quantity, startingPrice);
		this.floor = floor;
		this.pool = pool;
		super.setFinalPrice(generatePrice(quantity, startingPrice));
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getPool() {
		return pool;
	}

	public void setPool(int pool) {
		this.pool = pool;
	} 

	private final int floorPriceMultiplier = 750000;
	private final int poolPriceMultiplier = 125000;

	@Override
	public long generatePrice(int quantity, long startingPrice) {
		// TODO Auto-generated method stub
		long finalPrice = (long) (((startingPrice * 0.3 * quantity) + (floor * floorPriceMultiplier) + (pool * poolPriceMultiplier)) * 1.1);
		return finalPrice;
	}
}

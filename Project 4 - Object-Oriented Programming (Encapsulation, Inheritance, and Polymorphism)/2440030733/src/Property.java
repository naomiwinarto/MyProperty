import java.util.Random;

public abstract class Property {
	private String id, name, type, address;
	private int quantity;
	private long startingPrice, finalPrice;
	public abstract long generatePrice(int quantity, long startingPrice);
	
	public Property(String name, String type, String address, int quantity, long startingPrice) {
		super();
		this.id = generateID();
		this.name = name;
		this.type = type;
		this.address = address;
		this.quantity = quantity;
		this.startingPrice = startingPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(long startingPrice) {
		this.startingPrice = startingPrice;
	}

	public long getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(long finalPrice) {
		this.finalPrice = finalPrice;
	}

	private String generateID() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		char x1 = (char) ((rand.nextInt(26)+65));
		char x2 = (char) ((rand.nextInt(26)+65));
		char x3 = (char) ((rand.nextInt(26)+65));
		int y = rand.nextInt(1000);
		
		return x1+""+x2+""+x3+y;
	}
	
}

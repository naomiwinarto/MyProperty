public class Cluster extends Property{
	private String clusterType;
	private final int typeAPriceMultiplier = 5000000;
	private final int typeBPriceMultiplier = 7500000;
	
	public Cluster(String name, String type, String address, int quantity, String clusterType,
			long startingPrice) {
		super(name, type, address, quantity, startingPrice);
		this.clusterType = clusterType;
		super.setFinalPrice(generatePrice(quantity, startingPrice));
	}
	public String getcType() {
		return clusterType;
	}
	public void setcType(String clusterType) {
		this.clusterType = clusterType;
	}

	@Override
	public long generatePrice(int quantity, long startingPrice) {
		// TODO Auto-generated method stub
		long finalPrice = 0;
		if (clusterType.equals("Type A")) {
			finalPrice = (long) (((startingPrice * 0.2 * quantity) + typeAPriceMultiplier) * 1.25);
		}
		else if (clusterType.equals("Type B")) {
			finalPrice = (long) (((startingPrice * 0.2 * quantity) + typeBPriceMultiplier) * 1.25);
		}
		return finalPrice;
	}
	
	
}

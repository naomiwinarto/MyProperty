import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Property> propertyList = new ArrayList<>();
	
	public Main() {
		int menu = 0;
		while(true) {
			do {
				System.out.println("My Property");
				System.out.println("=======================");
				System.out.println("1. View Property");
				System.out.println("2. Add Property");
				System.out.println("3. Delete Property");
				System.out.println("4. Exit");
				menu = scanInt();
			} while (menu<1 || menu>4);
			
			switch (menu) {
			case 1:
				viewProperty();
				break;
			case 2:
				addProperty();
				break;
			case 3:
				deleteProperty();
				break;
			case 4:
				System.out.println("Thank You!");
				return;
			}
			System.out.println("Press Enter to Continue!");
			scan.nextLine();
		}
	}

	private void deleteProperty() {
		viewProperty();
		
		if(!propertyList.isEmpty()) {
			System.out.print("Input property ID to be deleted: ");
			String toBeDel = scan.nextLine();
			for (int i=0; i<propertyList.size(); i++) {
				if(propertyList.get(i).getId().equals(toBeDel)) {
					System.out.println(propertyList.get(i).getName() + " has been removed from property list.");
					propertyList.remove(i);
					return;
				}
			}
			System.out.println("Property with ID "+ toBeDel +" not found");
		}
	}
	
	private void addProperty() {
		String name, type, address;
		int quantity = 0;
		
		do {
			System.out.print("Input property name [5-20]: ");
			name = scan.nextLine();
		} while (name.length()<5 || name.length()>20);
		do {
			System.out.print("Input property type [Mansion | Cluster]: ");
			type = scan.nextLine();
		} while (!type.equals("Mansion") && !type.equals("Cluster"));
		do {
			System.out.print("Input room quantity [5-20]: ");
			quantity = scanInt();
		} while (quantity<5 || quantity>20);
		do {
			System.out.print("Input location address [ends with \"Street\"]: ");
			address = scan.nextLine();
		} while (!address.endsWith(" Street"));
		
		if(type.equals("Mansion")) {
			int floor = 0, pool = 0;
			long startingPrice = 0;
			
			do {
				System.out.print("Input total building floors [1-5]: ");
				floor = scanInt();
			} while (floor<1 || floor>5);
			do {
				System.out.print("Input pool size [20-50]: ");
				pool = scanInt();
			} while (pool<20 || pool>50);
			do {
				System.out.print("Input starting price [min. 50000000]: ");
				startingPrice = scanInt();
			} while (startingPrice<50000000);
			
			String x;
			do {
				System.out.print("Are you sure you want to add new property (Y/N)? ");
				x = scan.nextLine();
			} while (!x.equalsIgnoreCase("Y") && !x.equalsIgnoreCase("N"));
			
			if(x.equalsIgnoreCase("Y")) {
				Mansion mansion = new Mansion(name, type, address, quantity, floor, pool, startingPrice);
				propertyList.add(mansion);
				System.out.println("Property added successfully.");
			} else {
				System.out.println("Failed to add property.");
				return;
			}
		}
		else if (type.equals("Cluster")) {
			String clusterType;
			long startingPrice = 0;
			do {
				System.out.print("Input cluster type [Type A | Type B]: ");
				clusterType = scan.nextLine();
			} while (!clusterType.equals("Type A") && !clusterType.equals("Type B"));
			do {
				System.out.print("Input starting price [min. 35000000]: ");
				startingPrice = scanInt();
			} while (startingPrice<35000000);
			
			String x;
			do {
				System.out.print("Are you sure you want to add new property (Y/N)? ");
				x = scan.nextLine();
			} while (!x.equalsIgnoreCase("Y") && !x.equalsIgnoreCase("N"));
			
			if(x.equalsIgnoreCase("Y")) {
				Cluster cluster = new Cluster(name, type, address, quantity, clusterType, startingPrice);
				propertyList.add(cluster);
				System.out.println("Property added successfully.");
			} else {
				System.out.println("Failed to add property.");
				return;
			}
		}
		
	}

	private void viewProperty() {
		if(propertyList.isEmpty()) {
			System.out.println("There is no property!");
			return;
		}
		else {
			for (int i=0; i<propertyList.size(); i++) {
				System.out.println("(No. "+ (i+1) + ")");
				System.out.println("Property ID \t: " + propertyList.get(i).getId());
				System.out.println("Property Name \t: " + propertyList.get(i).getName());
				System.out.println("Property Type \t: " + propertyList.get(i).getType());
				System.out.println("Quantity Room \t: " + propertyList.get(i).getQuantity());
				if(propertyList.get(i) instanceof Mansion) {
					System.out.println("Floor \t\t: " + ((Mansion) propertyList.get(i)).getFloor());
					System.out.println("Pool Size \t: " + ((Mansion) propertyList.get(i)).getPool());
				}
				else if (propertyList.get(i) instanceof Cluster) {
					System.out.println("Cluster Type \t: " + ((Cluster) propertyList.get(i)).getcType());
				}
				System.out.println("Location \t: " + propertyList.get(i).getAddress());
				System.out.println("Price (IDR) \t: " + propertyList.get(i).getFinalPrice());
			}
		}
	}

	private int scanInt() {
		int x = -1;
		try {
			x = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			scan.nextLine();
		}
		return x;
	}

	public static void main(String[] args) {
		new Main();
	}

}

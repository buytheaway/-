import java.util.ArrayList;
import java.util.Scanner;

class SteamInventoryItem {
    protected String name;
    protected String itemType;
    protected String type;

    public SteamInventoryItem(String name, String itemType, String type) {
        this.name = name;
        this.itemType = itemType;
        this.type = type;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", Type: " + itemType + ", Type: " + type);
    }
}

class SkinItem extends SteamInventoryItem {
    private String skinType;
    private double skinPrice;

    public SkinItem(String name, String itemType, String type, String skinType, double skinPrice) {
        super(name, itemType, type);
        this.skinType = skinType;
        this.skinPrice = skinPrice;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Skin Type: " + skinType + ", Skin Price: $" + skinPrice);
    }
}

class SteamInventory {
    private ArrayList<SteamInventoryItem> items;

    public SteamInventory() {
        items = new ArrayList<>();
    }

    public void addItem(SteamInventoryItem item) {
        items.add(item);
    }

    public ArrayList<SteamInventoryItem> searchItems(String query) {
        ArrayList<SteamInventoryItem> foundItems = new ArrayList<>();
        for (SteamInventoryItem item : items) {
            if (item.name.toLowerCase().contains(query.toLowerCase())) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }
}

public class Main {
    public static void main(String[] args) {
        SteamInventory inventory = new SteamInventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Skin Item");
            System.out.println("2. Search for items");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter skin name: ");
                    String skinName = scanner.nextLine();
                    System.out.print("Enter skin type: ");
                    String skinType = scanner.nextLine();
                    System.out.print("Enter skin rarity: ");
                    String skinRarity = scanner.nextLine();
                    System.out.print("Enter skin price: ");
                    double skinPrice = scanner.nextDouble();
                    scanner.nextLine();
                    inventory.addItem(new SkinItem(skinName, "Skin", skinRarity, skinType, skinPrice));
                    break;
                case "2":
                    System.out.print("Enter the name of the item: ");
                    String query = scanner.nextLine();
                    ArrayList<SteamInventoryItem> foundItems = inventory.searchItems(query);
                    if (!foundItems.isEmpty()) {
                        System.out.println("Found items:");
                        for (SteamInventoryItem item : foundItems) {
                            item.displayDetails();
                        }
                    } else {
                        System.out.println("No items found.");
                    }
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

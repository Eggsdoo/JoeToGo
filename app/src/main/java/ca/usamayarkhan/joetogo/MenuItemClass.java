package ca.usamayarkhan.joetogo;

public class MenuItemClass {
    private String itemName;
    private String itemDescription;
    private double itemPrice;

    public MenuItemClass (String itemName, String itemDescription, double itemPrice) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}


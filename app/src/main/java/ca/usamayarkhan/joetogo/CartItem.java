package ca.usamayarkhan.joetogo;

public class CartItem {
    private MenuItemClass item;
    private int quantity;

    public CartItem(MenuItemClass item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItemClass getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }
}

package ca.usamayarkhan.joetogo;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShopAdapter extends RecyclerView.Adapter<CoffeeShopAdapter.ViewHolder> {
    private List<MenuItemClass> itemList;
    private List<CartItem> cartItems;
    public CoffeeShopAdapter(List<MenuItemClass> itemList) {
        this.itemList = itemList;
        this.cartItems = new ArrayList<>();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemNameTextView;
        public TextView itemDescriptionTextView;
        public TextView itemPriceTextView;
        public Button addToCartButton;
        public Button removeFromCartButton;

        public ViewHolder(View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
            itemDescriptionTextView = itemView.findViewById(R.id.itemDescriptionTextView);
            itemPriceTextView = itemView.findViewById(R.id.itemPriceTextView);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
            removeFromCartButton = itemView.findViewById(R.id.removeFromCartButton);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuItemClass item = itemList.get(position);

        holder.itemNameTextView.setText(item.getItemName());
        holder.itemDescriptionTextView.setText(item.getItemDescription());
        holder.itemPriceTextView.setText(String.format("$%.2f", item.getItemPrice()));

        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // add to cart
                addToCart(item);
            }
        });

        holder.removeFromCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // remove from cart
                removeFromCart(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private void addToCart(MenuItemClass item) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getItem().getItemName().equals(item.getItemName())) {
                cartItem.incrementQuantity();
                notifyDataSetChanged();
                return;
            }
        }

        cartItems.add(new CartItem(item, 1));
        notifyDataSetChanged();
    }

    private void removeFromCart(MenuItemClass item) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getItem().getItemName().equals(item.getItemName())) {
                if (cartItem.getQuantity() > 1) {
                    cartItem.decrementQuantity();
                } else {
                    cartItems.remove(cartItem);
                }
                notifyDataSetChanged();
                return;
            }
        }
    }
    public List<CartItem> getCartItems() {
        return cartItems;
    }
}


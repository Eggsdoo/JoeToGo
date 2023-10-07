package ca.usamayarkhan.joetogo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    TextView greetingTextView;

    private RecyclerView menuRecyclerView;
    private CoffeeShopAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        greetingTextView = rootView.findViewById(R.id.greetingTextView);
        greetingTextView.setText("Welcome to your local Joe"); // I can change my greeting here


        menuRecyclerView = rootView.findViewById(R.id.menuRecyclerView);

        // adding whatever items i can think of to the menu
        List<MenuItemClass> coffeeShopItems = new ArrayList<>();
        coffeeShopItems.add(new MenuItemClass("Cappuccino", "Espresso with steamed milk and foam", 3.99));
        coffeeShopItems.add(new MenuItemClass("Latte", "Espresso with steamed milk", 4.49));
        coffeeShopItems.add(new MenuItemClass("Espresso", "Strong black coffee made by forcing steam through finely-ground coffee beans.", 2.49));
        coffeeShopItems.add(new MenuItemClass("Mocha", "Espresso with steamed milk, chocolate, and whipped cream.", 4.99));
        coffeeShopItems.add(new MenuItemClass("Americano", "Diluted espresso with hot water.", 3.29));
        coffeeShopItems.add(new MenuItemClass("Caramel Macchiato", "Espresso with vanilla syrup, steamed milk, and caramel drizzle.", 4.79));
        coffeeShopItems.add(new MenuItemClass("Iced Coffee", "Chilled coffee served over ice cubes.", 3.49));
        coffeeShopItems.add(new MenuItemClass("Croissant", "Flaky and buttery pastry.", 2.99));
        coffeeShopItems.add(new MenuItemClass("Blueberry Muffin", "Moist muffin with blueberries.", 2.49));
        coffeeShopItems.add(new MenuItemClass("Chocolate Chip Cookie", "Delicious chocolate chip cookie.", 1.99));
        coffeeShopItems.add(new MenuItemClass("Flat White", "Espresso with microfoam steamed milk.", 4.99));
        coffeeShopItems.add(new MenuItemClass("Chai Latte", "Spiced tea with steamed milk.", 3.79));
        coffeeShopItems.add(new MenuItemClass("Hot Chocolate", "Rich and creamy chocolate drink.", 3.99));
        coffeeShopItems.add(new MenuItemClass("Cinnamon Roll", "Sweet pastry with cinnamon and icing.", 3.49));
        coffeeShopItems.add(new MenuItemClass("Iced Tea", "Refreshing iced tea.", 2.49));
        coffeeShopItems.add(new MenuItemClass("Bagel with Cream Cheese", "Toasted bagel with cream cheese.", 2.99));
        coffeeShopItems.add(new MenuItemClass("Scone", "Flaky pastry with fruit or nuts.", 2.79));
        coffeeShopItems.add(new MenuItemClass("Fruit Salad", "Fresh fruit salad.", 3.29));
        coffeeShopItems.add(new MenuItemClass("Greek Yogurt Parfait", "Layered yogurt with granola and berries.", 3.99));
        coffeeShopItems.add(new MenuItemClass("Cranberry Orange Muffin", "Moist muffin with cranberries and orange zest.", 2.49));


        // this will set up the RecyclerView with the adapter :)
        adapter = new CoffeeShopAdapter(coffeeShopItems);
        menuRecyclerView.setAdapter(adapter);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }
}
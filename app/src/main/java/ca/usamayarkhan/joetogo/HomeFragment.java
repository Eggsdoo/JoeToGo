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
        // Setting the greeting text
        greetingTextView.setText("Welcome to your local Joe");


        menuRecyclerView = rootView.findViewById(R.id.menuRecyclerView);

        // Create sample coffee shop items
        List<MenuItemClass> coffeeShopItems = new ArrayList<>();
        coffeeShopItems.add(new MenuItemClass("Cappuccino", "Espresso with steamed milk and foam", 3.99));
        coffeeShopItems.add(new MenuItemClass("Latte", "Espresso with steamed milk", 4.49));
        // Add more items as needed

        // Set up the RecyclerView with the adapter
        adapter = new CoffeeShopAdapter(coffeeShopItems);
        menuRecyclerView.setAdapter(adapter);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }
}
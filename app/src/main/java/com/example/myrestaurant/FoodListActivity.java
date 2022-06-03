package com.example.myrestaurant;

import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class FoodListActivity extends AppCompatActivity {

    final String FILE_NAME = "UserOrder";
    final String CATEGORY = "category";

    ArrayAdapter<String> adapter;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        TextView tvSeeCart = findViewById(R.id.seeCart);
        total = findViewById(R.id.total);
        ListView listView = findViewById(R.id.MyListView);

        //load shared preferences file
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        //look for saved String, CATEGORY
        String category = sharedPreferences.getString(CATEGORY, "s");
        //set list view based on category
        listView.setAdapter(setListView(category));

        listView.setOnItemClickListener((parent, view, position, id) -> {
            //determine the foodItem based on its position in the listview
            FoodItem foodItem = foodItemSelect(position, category);
            MyRestaurant app = (MyRestaurant) getApplication();
            //set the foodItem
            app.setFoodItem(foodItem);
            //launch DetailActivity
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            startActivity(intent);
        });

        tvSeeCart.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CartActivity.class);
            startActivity(intent);
        });
    }

    private FoodItem foodItemSelect(int position, String category) {
        switch (category) {
            case "s":
                switch (position) {
                    case 0:
                        return FoodItem.newCapSalad();
                    case 1:
                        return FoodItem.newCaesSalad();
                    case 2:
                        return FoodItem.newGrdnSalad();
                }
            case "b":
                switch (position) {
                    case 0:
                        return FoodItem.newChickenBurger();
                    case 1:
                        return FoodItem.newBeefBurger();
                    case 2:
                        return FoodItem.newVegeBurger();
                }
            case "p":
                switch (position) {
                    case 0:
                        return FoodItem.newPepPizza();
                    case 1:
                        return FoodItem.newMeatPizza();
                    case 2:
                        return FoodItem.newVegePizza();
                }
            case "d":
                switch (position) {
                    case 0:
                        return FoodItem.newCokeDrink();
                    case 1:
                        return FoodItem.newfantaDrink();
                    case 2:
                        return FoodItem.newWaterDrink();
                }
        }
        return null;
    }

    private ArrayAdapter<String> setListView(String s) {

        switch (s) {
            case "s":
                adapter = new ArrayAdapter<>(this, R.layout.foodlist_item,
                        Arrays.asList(getResources().getStringArray(R.array.salads)));
                return adapter;
            case "b":
                adapter = new ArrayAdapter<>(this, R.layout.foodlist_item,
                        Arrays.asList(getResources().getStringArray(R.array.burgers)));
                return adapter;
            case "p":
                adapter = new ArrayAdapter<>(this, R.layout.foodlist_item,
                        Arrays.asList(getResources().getStringArray(R.array.pizza)));
                return adapter;
            case "d":
                adapter = new ArrayAdapter<>(this, R.layout.foodlist_item,
                        Arrays.asList(getResources().getStringArray(R.array.drinks)));
                return adapter;
            default: return null;
        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onResume() {
        super.onResume();

        MyRestaurant app = (MyRestaurant) getApplication();
        //update total
        total.setText(format("%.2f", app.getCartTotal()));
    }
}
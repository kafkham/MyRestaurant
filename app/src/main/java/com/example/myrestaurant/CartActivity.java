package com.example.myrestaurant;

import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        TextView tvClearBtn = findViewById(R.id.clearButton);
        TextView total = findViewById(R.id.cartTotal);
        ListView listView = findViewById(R.id.cartListView);

        MyRestaurant app = (MyRestaurant) getApplication();

        ArrayList<FoodItem> cartContents = new ArrayList<>(app.getCart());
        foodlistAdapter adapter = new foodlistAdapter(getApplicationContext(), cartContents);
        listView.setAdapter(adapter);
//        listView.setAdapter(new ArrayAdapter<>(this, R.layout.cart_item, cartContents));
//        ArrayList<String> cartContents = new ArrayList<>();
//        app.getCart().forEach(foodItem -> cartContents.add(foodItem.toString()));

        //update total
        total.setText(format("%.2f", app.getCartTotal()));

        tvClearBtn.setOnClickListener(v -> {
            app.getCart().clear();
            listView.setAdapter(null);
            total.setText(getString(R.string.Total));
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
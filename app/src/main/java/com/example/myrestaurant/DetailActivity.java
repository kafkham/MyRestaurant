package com.example.myrestaurant;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    static int qty;
    MyRestaurant app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Button btnAddToCart = findViewById(R.id.addToCart);
        TextView tvQuantity = findViewById(R.id.quantity);
        TextView tvTitle = findViewById(R.id.title);
        TextView tvPrice = findViewById(R.id.price);
        TextView tvDescription = findViewById(R.id.description);
        ImageView ivImage = findViewById(R.id.imageView);

        app = (MyRestaurant) getApplication();
        FoodItem foodItem = app.getFoodItem();

        if(foodItem != null) {
            ivImage.setImageResource(foodItem.getImgID());
            tvTitle.setText(foodItem.getName());
            tvDescription.setText(foodItem.getDescription());
            tvPrice.setText(String.format("%s%s", getString(R.string.dollarSign), foodItem.getPrice()));
        }

        btnAddToCart.setOnClickListener(v -> {

            String q = tvQuantity.getText().toString();

            try {
                qty = Integer.parseInt(q);
            }
            catch (NumberFormatException n) {
                qty = 0;
            }
            if (qty != 0 && foodItem != null) {
                updateCart(foodItem, qty);
            }
        });

    }

    private void updateCart(FoodItem foodItem, int qty) {
        foodItem.setQty(foodItem.getQty() + qty);
        app.addToCart(foodItem);
        Toast.makeText(DetailActivity.this, qty + " items added to cart", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        qty = 0;
        finish();
    }
}
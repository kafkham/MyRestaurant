package com.example.myrestaurant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final String FILE_NAME = "UserOrder";
    final String CATEGORY = "category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout salad_fl = findViewById(R.id.salad);
        FrameLayout burger_fl = findViewById(R.id.burger);
        FrameLayout pizza_fl = findViewById(R.id.pizza);
        FrameLayout drink_fl = findViewById(R.id.drink);

        salad_fl.setOnClickListener(v -> updateCategory("s"));
        burger_fl.setOnClickListener(v -> updateCategory("b"));
        pizza_fl.setOnClickListener(v -> updateCategory("p"));
        drink_fl.setOnClickListener(v -> updateCategory("d"));
    }

    private void updateCategory(String s) {
        //create shared preferences & editor
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putString(CATEGORY, s);
        ed.commit();
        Intent intent = new Intent(getApplicationContext(), FoodListActivity.class);
        startActivity(intent);
    }
}
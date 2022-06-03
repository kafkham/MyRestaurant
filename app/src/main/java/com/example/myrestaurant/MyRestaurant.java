package com.example.myrestaurant;

import android.app.Application;

import java.util.ArrayList;

public class MyRestaurant extends Application {

    private FoodItem foodItem = null;
    private final ArrayList<FoodItem> cart = new ArrayList<>();

    public FoodItem getFoodItem() {
        return foodItem;
    }
    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public double getCartTotal() {
        return cart.stream().mapToDouble(foodItem1 -> foodItem1.getQty() * foodItem1.getPrice()).sum();
    }

    public void addToCart(FoodItem foodItem) {
        if (!cart.contains(foodItem)) {
            cart.add(foodItem);
        }
    }

    public ArrayList<FoodItem> getCart() {
        return cart;
    }
}

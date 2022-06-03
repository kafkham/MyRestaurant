package com.example.myrestaurant;


import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

public class FoodItem {

    private final String name;
    private final String description;
    private final double price;
    private final int imgID;
    private int qty;

    private FoodItem(String name, String description, double price, int imgID) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.qty = 0;
        this.imgID = imgID;
    }

    @NonNull
    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return (name + "\t\t\t" + qty + "\t\t\t" + price + "\t\t\t\t" + String.format("%.2f", (qty * price)));
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) { this.qty = qty; }
    public int getImgID() {
        return imgID;
    }

    static FoodItem chickenBurger = null;
    static FoodItem beefBurger = null;
    static FoodItem vegeBurger = null;
    static FoodItem capSalad = null;
    static FoodItem caesSalad = null;
    static FoodItem grdnSalad = null;
    static FoodItem vegePizza = null;
    static FoodItem meatPizza = null;
    static FoodItem pepPizza = null;
    static FoodItem cokeDrink = null;
    static FoodItem waterDrink = null;
    static FoodItem fantaDrink = null;

    static FoodItem newChickenBurger() {
        if (chickenBurger == null) {
            chickenBurger = new FoodItem("Chicken Burger", "Crispy chicken with " +
                    "cheese, tomatoes, mushrooms and ranch dressing", 10.99, R.drawable.chickenburger);
        }
        return chickenBurger;
    }
    static FoodItem newBeefBurger() {
        if (beefBurger == null) {
            beefBurger = new FoodItem("Beef Burger", "Juicy beef with cheese, " +
                    "tomatoes, mushrooms, ketchup, mustard.", 11.99, R.drawable.beefburger);
        }
        return beefBurger;
    }
    static FoodItem newVegeBurger() {
        if (vegeBurger == null) {
            vegeBurger = new FoodItem("Veggie Burger", "Tasty plant-based patty with " +
                    "lettuce, tomatoes, mushrooms, ketchup, mustard.", 10.99, R.drawable.vegeburger);
        }
        return vegeBurger;
    }
    static FoodItem newCapSalad() {
        if (capSalad == null) {
            capSalad = new FoodItem("Caprese Salad", "Fresh tomatoes, basil and " +
                    "mozzarella, drizzled with olive oil and balsamic vinegar.", 8.99, R.drawable.capresesalad);
        }
        return capSalad;
    }
    static FoodItem newCaesSalad() {
        if (caesSalad == null) {
            caesSalad = new FoodItem("Caesar Salad", "Fresh lettuce, toasted croutons and " +
                    "bacon bits tossed in our homemade caesar dressing.", 7.99, R.drawable.caesarsalad);
        }
        return caesSalad;
    }
    static FoodItem newGrdnSalad() {
        if (grdnSalad == null) {
            grdnSalad = new FoodItem("Garden Salad", "Mixed greens, tomatoes, onion, " +
                    "carrot and cucumber. Dressed with italian vinaigrette.", 7.99, R.drawable.gardensalad);
        }
        return grdnSalad;
    }
    static FoodItem newPepPizza() {
        if (pepPizza == null) {
            pepPizza = new FoodItem("Pepperoni Pizza", "Dough made from scratch, fresh " +
                    "tomato sauce, italian pepperoni and mozzarella.", 15.99, R.drawable.peppizza);
        }
        return pepPizza;
    }
    static FoodItem newMeatPizza() {
        if (meatPizza == null) {
            meatPizza = new FoodItem("Meatlovers Pizza", "Dough made from scratch, fresh " +
                    "tomato sauce, bacon, ham and mozzarella.", 17.99, R.drawable.meatpizza);
        }
        return meatPizza;
    }
    static FoodItem newVegePizza() {
        if (vegePizza == null) {
            vegePizza = new FoodItem("Vegetarian Pizza", "Dough made from scratch, fresh " +
                    "tomato sauce, mushrooms and basil.", 14.99, R.drawable.vegepizza);
        }
        return vegePizza;
    }
    static FoodItem newCokeDrink() {
        if (cokeDrink == null) {
            cokeDrink = new FoodItem("Coca Cola", "Refreshing Coca Cola. 330mL.",
                    1.99, R.drawable.cokedrink);
        }
        return cokeDrink;
    }
    static FoodItem newWaterDrink() {
        if (waterDrink == null) {
            waterDrink = new FoodItem("Water", "Aquafina. 500mL.",
                    0.99, R.drawable.waterdrink);
        }
        return waterDrink;
    }
    static FoodItem newfantaDrink() {
        if (fantaDrink == null) {
            fantaDrink = new FoodItem("Fanta", "Tasty Fanta. 330mL.",
                    1.99, R.drawable.fantadrink);
        }
        return fantaDrink;
    }
}

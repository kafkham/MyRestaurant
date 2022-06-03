package com.example.myrestaurant;

import static java.lang.String.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class foodlistAdapter extends BaseAdapter {

    List<FoodItem> cartContents;
    Context m_context;

    public foodlistAdapter(Context context, ArrayList<FoodItem> arrayList) {
        this.cartContents = arrayList;
        m_context = context;
    }

    @Override
    public int getCount() {
        return cartContents.size();
    }

    @Override
    public Object getItem(int position) {
        return cartContents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder") View v = View.inflate(m_context, R.layout.cart2_item2, null);

        TextView itemName = v.findViewById(R.id.cart_list_name);
        itemName.setText(cartContents.get(position).getName());
        TextView itemQTY = v.findViewById(R.id.cart_list_qty);
        itemQTY.setText(String.valueOf(cartContents.get(position).getQty()));
        TextView itemPrice = v.findViewById(R.id.cart_list_price);
        itemPrice.setText(valueOf(cartContents.get(position).getPrice()));
        TextView itemTotal = v.findViewById(R.id.cart_list_total);
        itemTotal.setText(format("%.2f",cartContents.get(position).getQty()*cartContents.get(position).getPrice()));

        return v;
    }
}

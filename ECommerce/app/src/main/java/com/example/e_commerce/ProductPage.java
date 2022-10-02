package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.e_commerce.model.Order;

public class ProductPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
    }

    public void addToCart(View view) {

        int item_id = getIntent().getIntExtra("productId", 0);
        Order.items_id.add(item_id);
        Toast.makeText(this, "Добавлено!", Toast.LENGTH_LONG).show();
    }
}
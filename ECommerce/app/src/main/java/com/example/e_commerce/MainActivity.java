 package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.e_commerce.adapter.CategoryAdapter;
import com.example.e_commerce.adapter.ProductAdapter;
import com.example.e_commerce.model.Category;
import com.example.e_commerce.model.Product;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler;
    RecyclerView productRecycler;
    CategoryAdapter categoryAdapter;
    static ProductAdapter productAdapter;
    static List<Product> productList = new ArrayList<>();
    static List<Product> fullProductList = new ArrayList<>();


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Цветы"));
        categoryList.add(new Category(2, "Букеты"));
        categoryList.add(new Category(3, "Вазы"));
        categoryList.add(new Category(4, "Горшки"));
        categoryList.add(new Category(5, "Прочее"));

        setCategoryRecycler(categoryList);

        productList.add(new Product(1, "schefflera", "Шеффлера", "7500 тг", 1));
        productList.add(new Product(2, "catharanthus", "Катарантус", "2500 тг", 1));
        productList.add(new Product(3, "g_for_orchid_simple", "Горшок для орхидей Газонcity", "300 тг", 4));

        fullProductList.addAll(productList);

        setProductRecycler(productList);

    }

    public void openShoppingCart(View view){

        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);

    }

     private void setProductRecycler(List<Product> productList) {
        // horisontal прокрутка
         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

         // design
         productRecycler = findViewById(R.id.productRecycler);
         productRecycler.setLayoutManager(layoutManager);

         productAdapter = new ProductAdapter(this, productList);
         productRecycler.setAdapter(productAdapter);
     }

     private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }




    public static void showProductsByCategory(int category){

         productList.clear();
         productList.addAll(fullProductList);

         List<Product> filterProducts = new ArrayList<>();

        for(Product p : productList){
            if(p.getCategory() == category)
                filterProducts.add(p);
        }

        productList.clear();
        productList.addAll(filterProducts);

        productAdapter.notifyDataSetChanged();
    }




 }
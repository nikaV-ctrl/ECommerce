package com.example.e_commerce.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.ProductPage;
import com.example.e_commerce.R;
import com.example.e_commerce.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItems = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductAdapter.ProductViewHolder(productItems);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {

        // гет - получает ресурсы, по какому имени, обращаться по позиции определенной картинки, в папке дравабл, гет пакаж- из названия получить индентификатор
        int imageId = context.getResources().getIdentifier(products.get(position).getImg(), "drawable", context.getPackageName());
        // подставлять определенное изображение, сет - айди нужной картинки, из названия найти нужную картинку строка выше
        holder.productImage.setImageResource(imageId);

        holder.productTitle.setText(products.get(position).getTitle());
        holder.productPrice.setText(products.get(position).getPrice());


        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view){

                Intent intent = new Intent(context, ProductPage.class);
                context.startActivity(intent);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(holder.productImage, "productImage")
                );

                intent.putExtra("productImage", imageId);
                intent.putExtra("productTitle", products.get(position).getTitle());
                intent.putExtra("productPrice", products.get(position).getPrice());
                //intent.putExtra("productText", products.get(position).getText());

                intent.putExtra("productId", products.get(position).getId());





            }
        });

    }

    @Override
    public int getItemCount() {

        return products.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView productImage;
        TextView productTitle, productPrice;

        public ProductViewHolder(@NonNull View itemView) {

            super(itemView);

            productImage = itemView.findViewById(R.id.productImage);
            productTitle = itemView.findViewById(R.id.productTitle);
            productPrice = itemView.findViewById(R.id.productPrice);
        }
    }
}

package com.example.prm_app_shopping.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.prm_app_shopping.R;
import com.example.prm_app_shopping.databinding.ActivityProductDetailBinding;

public class ProductDetailActivity extends AppCompatActivity {

    ActivityProductDetailBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name = getIntent().getStringExtra("name");
        String image = getIntent().getStringExtra("image");
//        int id = getIntent().getIntExtra("id", 0);
        double price = getIntent().getDoubleExtra("price", 0);

        Glide.with(this)
                .load(image)
                .into(binding.productImage);


        getSupportActionBar().setTitle(name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // display the product details
        TextView productName = findViewById(R.id.textViewProductDetail);
        TextView productPrice = findViewById(R.id.textViewProductDetail2);

        productName.setText(name);
        productPrice.setText(String.valueOf(price)) ;
//
//// set the product information in the TextViews
//        label.setText(product.getName());
////        productPrice.setText(String.valueOf(product.getPrice()));


//        // get product ID from Intent
//        int productId = getIntent().getIntExtra("product_id", -1);
//
//        // TODO: use the product ID to fetch the product details from the database or API
//
//        // display the product details
//        TextView productName = findViewById(R.id.label);
//        TextView productPrice = findViewById(R.id.price);
//        ImageView productImage = findViewById(R.id.image);
//
//        // TODO: set the product information in the TextViews and ImageView
    }


    public void clickAdd(View view) {
        Toast.makeText(this, "Order has been placed. ", Toast.LENGTH_SHORT).show();
        startActivity(new Intent( ProductDetailActivity.this, MainActivity.class ));
        finish();
    }



// goi ten san pham tren header
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
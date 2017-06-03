package com.xorsat.net.book_store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goToShopActivity(View view)
    {
        Intent shopintent = new Intent(this,ShopActivity.class);
        startActivity(shopintent);
    }
}

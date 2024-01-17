package com.example.bookscloud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    startActivity(new Intent(ProfileActivity.this, HomePageActivity.class));
                    return true;
                } else if (itemId == R.id.favorites) {
                    startActivity(new Intent(ProfileActivity.this, FavoritesActivity.class));
                    return true;
                } else if (itemId == R.id.cart) {
                    startActivity(new Intent(ProfileActivity.this, CartActivity.class));
                    return true;
                } else if (itemId == R.id.blog) {
                    startActivity(new Intent(ProfileActivity.this, ReviewActivity.class));
                    return true;
                } else if (itemId == R.id.profile) {
                    startActivity(new Intent(ProfileActivity.this, ProfileActivity.class));
                    return true;
                }
                return false;
            }
        });
    }
}
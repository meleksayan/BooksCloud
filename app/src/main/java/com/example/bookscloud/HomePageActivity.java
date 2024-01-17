package com.example.bookscloud;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class HomePageActivity extends AppCompatActivity {

    private static final String TAG = "FirebaseStorageCheck";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ImageButton sucvecezaButton = findViewById(R.id.imageButton6);
        ImageButton ucurtmavcisiButton = findViewById(R.id.imageButton7);
        ImageButton bilinmeyenbkmButton = findViewById(R.id.imageButton8);
        ImageButton simyaci = findViewById(R.id.imageButton4);
        ImageButton sekerportakali = findViewById(R.id.imageButton3);
        ImageButton satranc = findViewById(R.id.imageButton5);

        sucvecezaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, new SucvecezaFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        simyaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, new SimyaciFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        sekerportakali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, new SekerPortakaliFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        satranc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, new SatrancFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        ucurtmavcisiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, new UcurtmavcisiFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        bilinmeyenbkmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, new BilinmeyenbirkmFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


        Button viewAllButton = findViewById(R.id.viewAll);
        viewAllButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, ViewAll.class);
            startActivity(intent);
        });

        Button viewAll2Button = findViewById(R.id.viewAll2);
        viewAll2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, ViewAll.class);
                startActivity(intent);
            }
        });


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    startActivity(new Intent(HomePageActivity.this, HomePageActivity.class));
                    return true;
                } else if (itemId == R.id.favorites) {
                    startActivity(new Intent(HomePageActivity.this, FavoritesActivity.class));
                    return true;
                } else if (itemId == R.id.cart) {
                    startActivity(new Intent(HomePageActivity.this, CartActivity.class));
                    return true;
                } else if (itemId == R.id.blog) {
                    startActivity(new Intent(HomePageActivity.this, ReviewActivity.class));
                    return true;
                } else if (itemId == R.id.profile) {
                    startActivity(new Intent(HomePageActivity.this, ProfileActivity.class));
                    return true;
                }
                return false;
            }
        });

        EditText searchEditText = findViewById(R.id.searchbox);
        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String searchedBook = searchEditText.getText().toString();

                    Intent searchIntent = new Intent(HomePageActivity.this, SearchActivity.class);
                    searchIntent.putExtra("SEARCHED_BOOK", searchedBook);
                    startActivity(searchIntent);

                    return true;
                }
                return false;
            }
   });

    }
}
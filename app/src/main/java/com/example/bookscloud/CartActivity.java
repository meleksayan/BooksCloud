package com.example.bookscloud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.checkerframework.checker.units.qual.C;

public class CartActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference booksRef = db.collection("cart");

    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Button gamebtn = findViewById(R.id.gameButton);
        gamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameFragment gameFragment = new GameFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.cart, gameFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


        Button confirmbtn = findViewById(R.id.confirmbtn);
        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmFragment confirmFragment = new ConfirmFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.cart, confirmFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    startActivity(new Intent(CartActivity.this, HomePageActivity.class));
                    return true;
                } else if (itemId == R.id.favorites) {
                    startActivity(new Intent(CartActivity.this, FavoritesActivity.class));
                    return true;
                } else if (itemId == R.id.cart) {
                    startActivity(new Intent(CartActivity.this, CartActivity.class));
                    bottomNav.getMenu().findItem(R.id.cart).setChecked(true);
                    return true;
                } else if (itemId == R.id.blog) {
                    startActivity(new Intent(CartActivity.this, ReviewActivity.class));
                    return true;
                } else if (itemId == R.id.profile) {
                    startActivity(new Intent(CartActivity.this, ProfileActivity.class));
                    return true;
                }
                return false;
            }
        });

        setUpRecyclerViewCart();
    }

    private void setUpRecyclerViewCart() {
        Query query = booksRef.orderBy("book_name",Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Book> options = new FirestoreRecyclerOptions.Builder<Book>().setQuery(query, Book.class).build();

        adapter = new BookAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recyclerviewcart);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
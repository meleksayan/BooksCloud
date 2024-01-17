package com.example.bookscloud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class FavoritesActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference booksRef = db.collection("favorites");

    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        setUpRecyclerViewFavorites();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    startActivity(new Intent(FavoritesActivity.this, HomePageActivity.class));
                    return true;
                } else if (itemId == R.id.favorites) {
                    startActivity(new Intent(FavoritesActivity.this, FavoritesActivity.class));
                    return true;
                } else if (itemId == R.id.cart) {
                    startActivity(new Intent(FavoritesActivity.this, CartActivity.class));
                    return true;
                } else if (itemId == R.id.blog) {
                    startActivity(new Intent(FavoritesActivity.this, ReviewActivity.class));
                    return true;
                } else if (itemId == R.id.profile) {
                    startActivity(new Intent(FavoritesActivity.this, ProfileActivity.class));
                    return true;
                }
                return false;
            }
        });
    }

    private void setUpRecyclerViewFavorites() {
        Query query = booksRef.orderBy("book_name", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Book> options = new FirestoreRecyclerOptions.Builder<Book>().setQuery(query, Book.class).build();

        adapter = new BookAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recyclerviewfavorites);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.favorites) {
            Intent intent = new Intent(this, FavoritesActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
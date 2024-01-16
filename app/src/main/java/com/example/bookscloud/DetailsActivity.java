package com.example.bookscloud;

import static com.google.firebase.appcheck.internal.util.Logger.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {

    private TextView textViewBookName;
    private TextView textViewAuthorName;
    private TextView textViewPrice;

    private ImageButton addFavorite;

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_item);

        textViewBookName = findViewById(R.id.book_name);
        textViewAuthorName = findViewById(R.id.author_name);
        textViewPrice = findViewById(R.id.book_price);

        addFavorite = findViewById(R.id.addfavorite);

        firestore = FirebaseFirestore.getInstance();

        addFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addedToFavorites();
            }
        });

    }

    private void addedToFavorites() {
        String book_name;
        String author_name;
        String price;

        final HashMap<String, Object> favoriteMap = new HashMap<>();

        favoriteMap.put("book_name", textViewBookName.getText());
        favoriteMap.put("author_name", textViewAuthorName.getText());
        favoriteMap.put("price", textViewPrice.getText());

        firestore.collection("favorites").add(favoriteMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "Added to favorites: " + task.getResult().getId());
                    Toast.makeText(DetailsActivity.this, "Added to favorites", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Log.w(TAG, "Error adding to favorites", task.getException());
                    Toast.makeText(DetailsActivity.this, "Error adding to favorites", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

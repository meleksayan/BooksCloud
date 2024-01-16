package com.example.bookscloud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class BookListActivity extends AppCompatActivity {

    private LinearLayout bookListLayout;
    private FirebaseFirestore firestore;
    private String collectionName = "books"; // Firestore koleksiyon adınızı buraya ekleyin

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        bookListLayout = findViewById(R.id.bookListLayout);
        firestore = FirebaseFirestore.getInstance();

        firestore.collection(collectionName).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                String bookName = document.getString("book_name");
                                String authorName = document.getString("author_name");
                                String price = document.getString("price");
                                String bookCoverUrl = document.getString("book_cover_url");

                                LinearLayout bookLayout = new LinearLayout(BookListActivity.this);
                                bookLayout.setOrientation(LinearLayout.HORIZONTAL);


                                // TextView'ler oluşturma
                                TextView bookNameTextView = new TextView(BookListActivity.this);
                                bookNameTextView.setText(bookName);

                                TextView authorNameTextView = new TextView(BookListActivity.this);
                                authorNameTextView.setText(authorName);

                                TextView priceTextView = new TextView(BookListActivity.this);
                                priceTextView.setText(price);

                                bookLayout.addView(bookNameTextView);
                                bookLayout.addView(authorNameTextView);
                                bookLayout.addView(priceTextView);

                                bookListLayout.addView(bookLayout);
                            }
                        } else {

                        }
                    }
                });
    }
}
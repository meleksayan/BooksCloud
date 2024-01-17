package com.example.bookscloud;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Locale;

public class SearchActivity extends AppCompatActivity {
    private FirebaseFirestore firestore;
    private String searchedBook;
    private TextView bookNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        firestore = FirebaseFirestore.getInstance();
        searchedBook = getIntent().getStringExtra("SEARCHED_BOOK");
        bookNameTextView = findViewById(R.id.bookNameTextView);

        Query query = firestore.collection("books")
                .orderBy("book_name")
                .startAt(searchedBook.toLowerCase(Locale.getDefault()))
                .endAt(searchedBook.toLowerCase(Locale.getDefault()) + "\uf8ff");

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    QuerySnapshot querySnapshot = task.getResult();
                    if (querySnapshot != null && !querySnapshot.isEmpty()) {
                        showBookFoundMessage();
                        displayBookNames(querySnapshot);
                    } else {
                        showBookNotFoundMessage();
                    }
                } else {
                    showErrorMessage(task.getException().getMessage());
                }
            }
        });
    }

    private void displayBookNames(QuerySnapshot querySnapshot) {
        StringBuilder bookNames = new StringBuilder();
        for (DocumentSnapshot documentSnapshot : querySnapshot.getDocuments()) {
            String bookName = documentSnapshot.getString("book_name");
            if (bookName != null) {
                bookNames.append(bookName).append("\n");
            }
        }
        bookNameTextView.setText("Kitap Adları:\n" + bookNames.toString());
    }

    private void showBookFoundMessage() {
        Toast.makeText(SearchActivity.this, "Kitap bulundu.", Toast.LENGTH_SHORT).show();
    }

    private void showBookNotFoundMessage() {
        Toast.makeText(SearchActivity.this, "Aradığınız kitap bulunamadı.", Toast.LENGTH_SHORT).show();
    }

    private void showErrorMessage(String errorMessage) {
        Toast.makeText(SearchActivity.this, "Sorgu hatası: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}
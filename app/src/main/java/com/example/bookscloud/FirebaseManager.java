package com.example.bookscloud;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FirebaseManager {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference booksCollection = db.collection("books");

    public interface OnBookListListener {
        void onSuccess(List<Book> bookList);
        void onFailure(String failure);
    }

    public void getBookList(OnBookListListener listener) {
        booksCollection.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    List<Book> bookList = new ArrayList<>();
                    for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                        Book book = document.toObject(Book.class);
                        bookList.add(book);
                    }
                    listener.onSuccess(bookList);
                })
                .addOnFailureListener(e -> {
                    listener.onFailure(e.getMessage());
                });
    }
}


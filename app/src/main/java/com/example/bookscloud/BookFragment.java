package com.example.bookscloud;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class BookFragment extends Fragment {

    private FirebaseManager firebaseManager;

    // onCreate, onCreateView ve diğer metotlar
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseManager = new FirebaseManager();
        firebaseManager.getBookList(new FirebaseManager.OnBookListListener() {
            @Override
             public void onSuccess(List<Book> bookList) {
                mValues.clear();
                mValues.addAll(bookList);
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(String hataMesaji) {
                // Hata durumunda işlemler
            }
        });
    }

    public interface OnBookSelected {
        void bookSelected(Book book);
    }*/


    // onAttach, onDetach ve diğer metotlar
}



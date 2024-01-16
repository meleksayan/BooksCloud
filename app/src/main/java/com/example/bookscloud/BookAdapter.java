package com.example.bookscloud;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;



public class BookAdapter extends FirestoreRecyclerAdapter<Book, BookAdapter.BookHolder> {

    public BookAdapter(@NonNull FirestoreRecyclerOptions<Book> options){
        super(options);
    }

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();
    StorageReference bookcoverRef = storageRef.child("bookcovers");
    @Override
    protected void onBindViewHolder(@NonNull BookHolder holder, int position, @NonNull Book model) {
        holder.textViewBookName.setText(model.getbook_name());
        holder.textViewAuthorName.setText(model.getauthor_name());
        holder.textViewPrice.setText(model.getPrice());

    }
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new BookHolder(v);
    }
    class BookHolder extends RecyclerView.ViewHolder{

        TextView textViewBookName;
        TextView textViewAuthorName;
        TextView textViewPrice;

        public BookHolder(@NonNull View itemView) {
            super(itemView);
            textViewBookName = itemView.findViewById(R.id.book_name);
            textViewAuthorName = itemView.findViewById(R.id.author_name);
            textViewPrice = itemView.findViewById(R.id.book_price);

        }
    }

}

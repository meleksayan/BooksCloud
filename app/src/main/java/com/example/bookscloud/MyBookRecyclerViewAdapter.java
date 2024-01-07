package com.example.bookscloud;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/*
public class MyBookRecyclerViewAdapter extends RecyclerView.Adapter<MyBookRecyclerViewAdapter.ViewHolder> {

    private final List<Book> mValues;
    private BookFragment.OnBookSelected mListener;
    int selectedIndex;


    public MyBookRecyclerViewAdapter(List<Book> items, BookFragment.OnBookSelected listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(Integer.toString(position + 1)); // Listelerde indeks 0'dan değil, 1'den başlar genellikle
        holder.mContentView.setText(mValues.get(position).getBookName());
        holder.mAuthorView.setText(mValues.get(position).getAuthorName());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.bookSelected(holder.mItem);
                    notifyItemChanged(selectedIndex);
                    selectedIndex = holder.getLayoutPosition();
                    notifyItemChanged(selectedIndex);
                }
            }
        });
        holder.itemView.setBackgroundColor(selectedIndex == position ? Color.GREEN : Color.TRANSPARENT);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final View mView;
        public final TextView mContentView;
        public final TextView mAuthorView;
        public Book mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
            mContentView = view.findViewById(R.id.content);
            mAuthorView = view.findViewById(R.id.author); // layout dosyanızda bu id'ye sahip bir TextView varsa
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
*/
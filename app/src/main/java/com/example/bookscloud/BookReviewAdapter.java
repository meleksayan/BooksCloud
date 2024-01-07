package com.example.bookscloud;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.List;

public class BookReviewAdapter extends BaseAdapter {

    List<BookReview> bookReviewList;
    LayoutInflater layoutInflater;

    public BookReviewAdapter(Activity activity, List<BookReview> bookReviewList) {
        this.bookReviewList = bookReviewList;
        layoutInflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return bookReviewList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookReviewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView;
        rowView = layoutInflater.inflate(R.layout.row_book_review, null);
        EditText txtTitle = rowView.findViewById(R.id.txtTitle);
        EditText txtAuthor = rowView.findViewById(R.id.txtAuthor);
        EditText txtReview = rowView.findViewById(R.id.txtReview);

        BookReview bookReview = bookReviewList.get(position);
        txtTitle.setText(bookReview.getTitle());
        txtAuthor.setText(bookReview.getAuthor());
        txtReview.setText(bookReview.getReview());

        return rowView;
    }
}

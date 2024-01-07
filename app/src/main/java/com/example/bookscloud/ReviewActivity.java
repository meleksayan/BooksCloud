package com.example.bookscloud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

public class ReviewActivity extends AppCompatActivity {


    private static final int ADD_REVIEW_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        LinearLayout llReviewsContainer = findViewById(R.id.llReviewsContainer);

        Button btnAddNewReview = findViewById(R.id.btnAddNewReview);

        btnAddNewReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReviewActivity.this, BookReviewActivity.class);
                startActivityForResult(intent, ADD_REVIEW_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_REVIEW_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra("title");
            String author = data.getStringExtra("author");
            String review = data.getStringExtra("review");


            addReviewToContainer(title, author, review);
        }
    }

    private void addReviewToContainer(String title, String author, String review) {
        LinearLayout llReviewsContainer = findViewById(R.id.llReviewsContainer);

        TextView textView = new TextView(this);
        textView.setText(String.format("%s\n%s\n%s\n", title, author, review));
        textView.setTextSize(16);
        textView.setPadding(0, 0, 0, 16);


        llReviewsContainer.addView(textView);
    }
}
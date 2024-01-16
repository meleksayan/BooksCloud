package com.example.bookscloud;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BookReviewActivity extends AppCompatActivity {

    TextView txtTitle;
    TextView txtAuthor;
    TextView txtReview;
    ImageButton btnOk;
    ImageButton btnCancel;

    static final int CAPTURE_IMAGE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_review);

        txtTitle = findViewById(R.id.txtTitle);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtReview = findViewById(R.id.txtReview);



        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookReview bookReview = new BookReview();
                bookReview.setTitle(txtTitle.getText().toString());
                bookReview.setAuthor(txtAuthor.getText().toString());
                bookReview.setReview(txtReview.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("bookReview", bookReview);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }
}

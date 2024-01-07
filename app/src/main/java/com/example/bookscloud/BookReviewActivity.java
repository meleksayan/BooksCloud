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
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("title", txtTitle.getText().toString());
                bundle.putString("author", txtAuthor.getText().toString());
                bundle.putString("review", txtReview.getText().toString());
                intent.putExtras(bundle);
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

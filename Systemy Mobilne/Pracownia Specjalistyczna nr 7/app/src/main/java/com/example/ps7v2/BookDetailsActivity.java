package com.example.ps7v2;

import static com.example.ps7v2.MainActivity.IMAGE_URL_BASE;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class BookDetailsActivity extends AppCompatActivity {

    public final static String EXTRA_BOOK_DETAILS = "EXTRA_BOOK_DETAILS";

    private TextView bookTitleTextView;
    private TextView bookAuthorTextView;
    private ImageView bookCover;
    private TextView bookLanguagesTextView;
    private TextView bookTimesTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        bookTitleTextView = findViewById(R.id.book_title);
        bookTimesTextView = findViewById(R.id.book_title);
        bookAuthorTextView = findViewById(R.id.book_author);
        bookLanguagesTextView = findViewById(R.id.book_languages);
        bookTimesTextView = findViewById(R.id.book_times);

        bookCover = findViewById(R.id.img_cover);

        Book book = (Book) getIntent().getSerializableExtra(EXTRA_BOOK_DETAILS);


        bookTitleTextView.setText(book.getTitle());
        bookAuthorTextView.setText(TextUtils.join(", ", book.getAuthors()));
        bookLanguagesTextView.setText(TextUtils.join(", ", book.getLanguages()));
        bookTimesTextView.setText(TextUtils.join(", ", book.getTimes()));

        if (book.getCover() != null) {
            Picasso.with(getApplicationContext())
                    .load(IMAGE_URL_BASE + book.getCover() + "-L.jpg")
                    .placeholder(R.drawable.ic_baseline_book_24).into(bookCover);
        } else {
            bookCover.setImageResource(R.drawable.ic_baseline_book_24);
        }

    }
}
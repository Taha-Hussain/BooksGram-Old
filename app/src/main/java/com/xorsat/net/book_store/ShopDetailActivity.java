package com.xorsat.net.book_store;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xorsat.net.model.Books;

/**
 * Created by Taha on 19/03/2016.
 */
public class ShopDetailActivity extends AppCompatActivity{

    public static Books mBookDetail;

    TextView bookName;
    ImageView bookImage;
    TextView bookPrice;
    TextView bookDescription;
    ImageView share;
    ImageView favourite;
    Button addToCart;
    TextView bookAuthor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

     bookName = (TextView) findViewById(R.id.detail_textView_bookName);
     bookImage = (ImageView) findViewById(R.id.detail_imageView_bookImage);
     bookPrice = (TextView) findViewById(R.id.detail_textView_bookPrice);
     bookDescription = (TextView) findViewById(R.id.detail_textView_bookDescription);
     share = (ImageView) findViewById(R.id.detail_imageView_share);
     favourite = (ImageView) findViewById(R.id.detail_imageView_favourite);
     bookAuthor = (TextView) findViewById(R.id.detail_textView_bookAuthor);
     addToCart = (Button) findViewById(R.id.detail_button_addToCart);


        bookName.setText(mBookDetail.getBook_name());
        bookImage.setImageResource(this.getResources().getIdentifier("drawable/" + mBookDetail.getBook_logo() + "_large", null, this.getPackageName()));

        bookPrice.setText(mBookDetail.getBook_price());
        bookAuthor.setText(mBookDetail.getBook_publisher());
        bookDescription.setText(mBookDetail.getBook_description());

    }

    public void onClick_share(View v) {
        String strShareText = String.format(getResources().getString(R.string.message_book_share),
                mBookDetail.getBook_name(), mBookDetail.getBook_price());

        Intent mIntent = new Intent();
        mIntent.setAction(Intent.ACTION_SEND);
        mIntent.putExtra(Intent.EXTRA_TEXT, strShareText);
        mIntent.setType("text/plain");
        //startActivity(mIntent);
        startActivity(Intent.createChooser(mIntent, "Share: '" + mBookDetail.getBook_name() + "'"));
    }
}

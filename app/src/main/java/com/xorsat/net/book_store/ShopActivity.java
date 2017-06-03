package com.xorsat.net.book_store;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.xorsat.net.adapter.BookAdapter;
import com.xorsat.net.model.BookDatasource;
import com.xorsat.net.model.Books;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    ArrayList<Books> array_list;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        context = this;
        ListView mListViewBooks = (ListView) findViewById(R.id.booklist_listview);
        BookDatasource mApplicationDatasource = new BookDatasource();
        array_list = mApplicationDatasource.getList();

        BookAdapter mBookAdapter = new BookAdapter(this,R.layout.row_book_list, array_list);
        mListViewBooks.setAdapter(mBookAdapter);

        mListViewBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Books _mBook = array_list.get(position);
                    ShopDetailActivity.mBookDetail = _mBook;
                startActivity(new Intent(context, ShopDetailActivity.class));

            }
        });

    }
}

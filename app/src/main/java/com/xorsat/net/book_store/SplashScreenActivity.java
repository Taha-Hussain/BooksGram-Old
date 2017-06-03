package com.xorsat.net.book_store;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xorsat.net.book_store.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new get_data_AsynchTask().execute();
    }

    private class get_data_AsynchTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent mIntent = new Intent();
            mIntent.setClass(SplashScreenActivity.this,HomeActivity.class);
            startActivity(mIntent);
            finish();
            super.onPostExecute(aVoid);
        }
    }
}

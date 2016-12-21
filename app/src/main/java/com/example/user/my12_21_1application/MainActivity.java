package com.example.user.my12_21_1application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import layout.BlankFragment;

public class MainActivity extends AppCompatActivity {

    private static final String MY_CONSTANT = "hahaha";

    private static final String MY_KEY = "MY_KEY_BUNDLE";

    private static final String TAG = "MyActivityTAG_";

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.a_main_text);

        getSupportFragmentManager()
                .beginTransaction()
                .add(new BlankFragment(), "FRAGMENT_TAG")
                .commit();
    }

    public void doMagic(View view) {
        textView.setText(MY_CONSTANT);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String str = textView.getText().toString();
        outState.putString(MY_KEY, str);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String str = savedInstanceState.getString(MY_KEY, "");
        textView.setText(str);
    }

    public void startCounter(View view) {
        for (int i = 0; i < 50; i++) {
            Log.d(TAG, "startCounter: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printLog(View view) {
        Log.d(TAG, "printLog: " + "I'm smart");
    }
}

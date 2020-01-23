package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeaderTextView;
    private TextView mReplyTextView;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.twoactivities.extra.message";
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_Main);
        mReplyHeaderTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG,"Button Clickered");
        Intent intent = new Intent(this, SecondActivity.class);
        String mes = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, mes);
        startActivityForResult(intent, TEXT_REQUEST);
    }
    @Override
    public void onActivityResult(int reqCode, int resCode, Intent d){
        super.onActivityResult(reqCode,resCode,d);
        if(reqCode == TEXT_REQUEST){
            if(resCode == RESULT_OK){
                String reply = d.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeaderTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}

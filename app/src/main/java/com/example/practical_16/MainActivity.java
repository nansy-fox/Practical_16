package com.example.practical_16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "myDate";
    public static final String APP_PREFERENCES_TEXT = "Text";
    SharedPreferences settings;
    EditText editText;
    TextView tvInfo;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        editText= findViewById(R.id.edText);
        tvInfo = findViewById(R.id.YourText);
        String strText = settings.getString(APP_PREFERENCES_TEXT,"");
        editText.setText(strText);
    }
    @Override
    protected void onPause(){
        super.onPause();

        String strText = editText.getText().toString();
        editor = settings.edit();
        editor.putString(APP_PREFERENCES_TEXT, strText);
        editor.apply();
    }
    public void BtnSave (View v) {

        String strText = editText.getText().toString();
        editor = settings.edit();
        editor.putString(APP_PREFERENCES_TEXT, strText);
        editor.apply();
    }
    public void btnLoad (View view) {
        TextView nameView = findViewById(R.id.YourText);
        String name = settings.getString(APP_PREFERENCES_TEXT,"не определено");
        nameView.setText(name);
    }
}
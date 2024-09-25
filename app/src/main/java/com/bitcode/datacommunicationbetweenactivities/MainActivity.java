package com.bitcode.datacommunicationbetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtRollNumber;
    Button btnNext;
    String username;
    String rollNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();
    }

    private void initializeViews(){
            edtName = findViewById(R.id.edtName);
            edtRollNumber = findViewById(R.id.edtRollNumber);
            btnNext = findViewById(R.id.btnNext);
    }

    private void initializeListeners(){
        btnNext.setOnClickListener(new MyBtnNextClickListener());
    }

    class MyBtnNextClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,
                                        SecondActivity.class);

            username = edtName.getText().toString();
            rollNumber = edtRollNumber.getText().toString();

            intent.putExtra("name",username);
            intent.putExtra("roll_number",rollNumber);

            startActivityForResult(intent,1);
        }
    }

    //backward navigation
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        int value = bundle.getInt("key1");
        Log.e("tag", value + "");
    }
}
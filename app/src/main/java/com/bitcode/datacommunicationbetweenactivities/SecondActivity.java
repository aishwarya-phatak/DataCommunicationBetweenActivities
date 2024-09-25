package com.bitcode.datacommunicationbetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txtName,txtRollNumber;
    Button btnBack;
    String name;
    String rollNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initializeViews();
        extractData();
        initializeListeners();
    }

    private void initializeViews(){
        txtName = findViewById(R.id.txtName);
        txtRollNumber = findViewById(R.id.txtRollNumber);
        btnBack = findViewById(R.id.btnBack);
    }

    private void extractData(){
        Intent i = getIntent();
        name = i.getStringExtra("name");
        rollNumber = i.getStringExtra("roll_number");

        txtName.setText(name);
        txtRollNumber.setText(rollNumber);
    }

    //to pass data back to FirstActivity
    private void initializeListeners(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("key1", 101);

                setResult(1,i);
                finish();
            }
        });
    }
}

package com.nagel.lab3template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent nameIntent = getIntent();
        String recipeName = nameIntent.getStringExtra("name");
        TextView txtName = findViewById(R.id.txtRecipeName);
        txtName.setText(recipeName);
    }
}
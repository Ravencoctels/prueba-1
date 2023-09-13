package com.example.prueba_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Pizza extends AppCompatActivity {

    private ImageButton Pizza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        Pizza = (ImageButton) findViewById(R.id.Pizza);


        Pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Pizza.this, MainActivity.class);
                startActivity(a);
            }
        });
    }
}

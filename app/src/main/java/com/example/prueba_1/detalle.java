package com.example.prueba_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class detalle extends AppCompatActivity {

    private ImageButton ib_1_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        ib_1_1 = findViewById(R.id.ib_1_1);


        ib_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(detalle.this, MainActivity.class );
                startActivity(a);
            }
        });

    }
}
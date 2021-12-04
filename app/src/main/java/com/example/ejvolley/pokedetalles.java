package com.example.ejvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class pokedetalles extends AppCompatActivity {

    String pokenumero;
    TextView ejemplo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedetalles);
        //ENCONTRAR ID
        ejemplo=findViewById(R.id.txtejemplo);

        //RECUPERAR VARIABLE
        pokenumero = getIntent().getStringExtra("numero");

        //CAMBIAR TEXTO
        ejemplo.setText(pokenumero);
    }
}
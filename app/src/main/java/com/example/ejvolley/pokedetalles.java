package com.example.ejvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class pokedetalles extends AppCompatActivity {

    //VARIABLES
    String pokenumero;
    String imagen_url;
    String pokenombre;
    //VIEWS
    TextView ejemplo;
    ImageView pokesprite;
    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedetalles);
        //ENCONTRAR ID
        ejemplo=findViewById(R.id.txtejemplo);
        pokesprite=findViewById(R.id.pokeimagen);
        regresar = findViewById(R.id.regresar_btn);

        //RECUPERAR VARIABLE
        pokenumero = getIntent().getStringExtra("numero");
        pokenombre = getIntent().getStringExtra("nombre");
        imagen_url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokenumero + ".png";
        Picasso.get().load(imagen_url).into(pokesprite);

        //CAMBIAR TEXTO
        ejemplo.setText(pokenombre);

        //ACCIONES
        regresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent ir = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(ir);
            }
        });
    }
}
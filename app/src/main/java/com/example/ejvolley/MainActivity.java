package com.example.ejvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.ejvolley.Adaptadores.PokeAdapter;
import com.example.ejvolley.Clases.Pokemon;
import com.example.ejvolley.SingleTon.MySingleTon;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //VARIABLES
    String url ="https://pokeapi.co/api/v2/pokemon?limit=151";
    TextView TextoDemo;
    RecyclerView re;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VIEWS
        TextoDemo=findViewById(R.id.txt1);
        re=findViewById(R.id.recyclerId);

        //EVENTOS
        CargarAPI();

    }

    public void CargarAPI(){

        //CREAR SINGLETON (SANTA)
        MySingleTon.getInstance(this);


        //JSON OBJECT
        /*
        //método, url, parametros a envuar, método on response, método onError
        JsonObjectRequest carta1 = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray PokeJson = response.getJSONArray("results");
                    //List<Pokemon> lp = new ArrayList<>();

                    for (int i = 0; i < PokeJson.length(); i++) {
                        //Pokemon p = new Pokemon(PokeJson.getJSONObject(i).getString("name"), PokeJson.getJSONObject(i).getString("url"));
                        //lp.add(p);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //final Gson gson = new Gson();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MySingleTon.getInstance(MainActivity.this).addToRequestQue(carta1);
        */

        //JSON OBJECT (GSON)
        //método, url, parametros a envuar, método on response, método onError
        JsonObjectRequest carta1 = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                final Gson gson = new Gson();

                try {
                    JSONArray PokeJson = response.getJSONArray("results");
                    final Type tipoListaPokemones = new TypeToken<List<Pokemon>>(){}.getType();
                    final List<Pokemon> listaPokemon = gson.fromJson(PokeJson.toString(),tipoListaPokemones);

                    //Adaptador
                    PokeAdapter Ad = new PokeAdapter(listaPokemon);
                    LinearLayoutManager lr = new LinearLayoutManager(getApplicationContext());
                    re.setLayoutManager(lr);
                    re.setHasFixedSize(true);
                    re.setAdapter(Ad);

                    Ad.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String pokenumero;
                            String nombre;
                            pokenumero = listaPokemon.get(re.getChildAdapterPosition(v)).getNumero();
                            nombre = listaPokemon.get(re.getChildAdapterPosition(v)).getName();
                            //Toast.makeText(getApplicationContext(), pokedetalles, Toast.LENGTH_SHORT).show();
                            Intent ir = new Intent(v.getContext(), pokedetalles.class);
                            ir.putExtra("numero", pokenumero);
                            ir.putExtra("nombre", nombre);
                            v.getContext().startActivity(ir);
                        }
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MySingleTon.getInstance(MainActivity.this).addToRequestQue(carta1);

        //JSON STRING
        /*
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TextoDemo.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        TextoDemo.setText("error");
                    }
                });
        MySingleTon.getInstance(MainActivity.this).addToRequestQue(stringRequest);
         */
    }

}
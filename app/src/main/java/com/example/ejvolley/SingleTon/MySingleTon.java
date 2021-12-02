package com.example.ejvolley.SingleTon;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;

//REQUEST QUEUE = SANTA CLAUS
// MySingleTon = Verificar que exista un sólo santa claus

public class MySingleTon {
    private static MySingleTon mySingleTon;
    private RequestQueue requestQueue;
    private static Context mctx;

    //Constructor privado (sólo se accede desde dentro de la clase)
    private MySingleTon(Context context){
        this.mctx=context;
        this.requestQueue=getRequestQueue();

    }
    //Solicita requestQueue
    public RequestQueue getRequestQueue(){
        if (requestQueue==null){ //Verifica si ya existe un requestQueue
            requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }
    //Manda a llamar al constructor
    public static synchronized MySingleTon getInstance(Context context){
        if (mySingleTon==null){ //Si no existe una instancia
            mySingleTon=new MySingleTon(context);
        }
        return mySingleTon;
    }
    //AGREGAR REQUEST ("carta")
    public<T> void addToRequestQue(Request<T> request){
        requestQueue.add(request);
    }
    //<T> ACEPTA LOS 4 TIPOS DE "CARTAS" IMAGEN, JSON, STRING, ARREGLO DE JSONS
}

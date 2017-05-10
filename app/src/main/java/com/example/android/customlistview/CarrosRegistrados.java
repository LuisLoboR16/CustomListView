package com.example.android.customlistview;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class CarrosRegistrados extends AppCompatActivity {
    private ArrayList<Carro> carros;
    Resources res;
    private int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros_registrados);

        contar();
    }
    public void contar(){
        carros = Datos.getCarros();
        contador = carros.size();
        new AlertDialog.Builder(this).setMessage("El numero de carros registrados es: "+contador).show();
    }

}

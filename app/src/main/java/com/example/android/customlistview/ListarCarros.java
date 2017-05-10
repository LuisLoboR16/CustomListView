package com.example.android.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListarCarros extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_carros);

        lista = (ListView)findViewById(R.id.lvListarCarros);
        carros = Datos.getCarros();

        AdaptadorCarro adapter = new AdaptadorCarro(this, carros);
        lista.setAdapter(adapter);
    }
}

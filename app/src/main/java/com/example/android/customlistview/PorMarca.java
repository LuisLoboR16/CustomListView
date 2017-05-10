package com.example.android.customlistview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PorMarca extends AppCompatActivity {
    private ArrayList<Carro> carros;
    private int numero;
    private String[] opc1;
    private Resources res;
    private Spinner lol;
    private ArrayAdapter<String> adaptador1;
    private TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_por_marca);

        res = this.getResources();
        lol=(Spinner)findViewById(R.id.cbxMarca);
        t = (TextView)findViewById(R.id.txtMensaje);
        opc1 = res.getStringArray(R.array.marcas);
        adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc1);
        lol.setAdapter(adaptador1);

    }
    public void Buscar(View v){
        int c=0;
        carros = Datos.getCarros();
        for (int i = 0; i < carros.size() ; i++) {
            numero = carros.get(i).getPrecio();
            if (lol.getSelectedItem().toString().equals(carros.get(i).getMarca())){
                 c = c+1;
            }
    }
      t.setText(res.getString(R.string.nombreM)+" "+c);
    }
}

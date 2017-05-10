package com.example.android.customlistview;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class RegistrarCarros extends AppCompatActivity {
    public EditText placa,precio;
    private Spinner marca,modelo,color;
    private ArrayAdapter<String> adaptador1,adaptador2,adaptador3;
    private String[] opc1,opc2,opc3;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_carros);

        res= this.getResources();
        placa = (EditText)findViewById(R.id.txtPlaca);
        marca = (Spinner)findViewById(R.id.spiMarca);
        modelo = (Spinner)findViewById(R.id.spiModelo);
        color = (Spinner)findViewById(R.id.spiColor);
        precio = (EditText)findViewById(R.id.txtPrecio);

        opc1 = res.getStringArray(R.array.marcas);
        opc2 = res.getStringArray(R.array.modelos);
        opc3 = res.getStringArray(R.array.colores);

        adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc1);
        adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc2);
        adaptador3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc3);

        marca.setAdapter(adaptador1);
        modelo.setAdapter(adaptador2);
        color.setAdapter(adaptador3);

    }

    public void registrar (View v){
        String pl, aux="",foto, marc, model, col;
        int pre;
        if(validarCaja()) {
            pl = placa.getText().toString().trim();
            marc = marca.getSelectedItem().toString();
            model = modelo.getSelectedItem().toString();
            col = color.getSelectedItem().toString();
            pre = Integer.parseInt(precio.getText().toString().trim());

            foto = String.valueOf(fotoAleatoria());
            Carro c = new Carro(foto, pl, marc, model, col, pre);
            c.guardar();

            new AlertDialog.Builder(this).setMessage("Registro guardado").show();
            limpiar();
        }
    }

    public void borrar(View v){
        limpiar();
    }

    public void limpiar(){
        placa.setText("");
        precio.setText("");
        placa.requestFocus();
    }

    public int fotoAleatoria(){
        int fotos[] = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};
        int numero = (int) (Math.random() * 2);
        return fotos[numero];
    }

    public boolean validarCaja(){
        if (placa.getText().toString().isEmpty() ){
            placa.setError(getResources().getString(R.string.ErrorPlaca));
            return false;
        }

        if (precio.getText().toString().isEmpty() ){
            precio.setError(getResources().getString(R.string.ErrorPrecio));
            return false;
        }
        return true;
    }
}

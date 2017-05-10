package com.example.android.customlistview;

import java.util.ArrayList;

/**
 * Created by Android on 05/05/2017.
 */

public class Datos {
    private static ArrayList<Carro> carros = new ArrayList<>();
    public static void guardar (Carro c){
        carros.add(c);
    }
    public static ArrayList<Carro> getCarros(){
        return carros;
    }
}

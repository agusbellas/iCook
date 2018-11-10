package com.cifprodolfoucha.icook;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetallesReceta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.like);

        TextView nombre = (TextView) findViewById(R.id.txt_nombre_detalles);
        TextView ingredientes = (TextView) findViewById(R.id.txt_ing_desc);
        TextView preparacion = (TextView) findViewById(R.id.txt_preparacion);

        ImageView imagen = (ImageView) findViewById(R.id.iv_descripcion);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        if(bundle!=null){

            String i ="";
            String ing = bundle.getString("ING");

            String[] ingrediente = ing.split(",");

            for(String s : ingrediente){
                i+="-"+s+"\n";
            }
            nombre.setText(bundle.getString("NOM"));
            ingredientes.setText(i);
            preparacion.setText(bundle.getString("PREP"));
            imagen.setImageResource(bundle.getInt("IMG"));
        }

    }
}

package com.cifprodolfoucha.icook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetallesReceta extends AppCompatActivity {

    static boolean favorito = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_conteint);

        final FloatingActionButton fab_like = (FloatingActionButton) findViewById(R.id.fab_like);

        int colorFav = getResources().getColor(R.color.fab_red);
        int color = getResources().getColor(R.color.colorPrimary);
        final ColorStateList cstFav = new ColorStateList(new int[][]{new int[0]},new int[]{colorFav});
        final ColorStateList cst = new ColorStateList(new int[][]{new int[0]},new int[]{color});

        //final boolean favorito = false;

        TextView nombre = (TextView) findViewById(R.id.txt_nombre_detalles);
        TextView ingredientes = (TextView) findViewById(R.id.txt_ing_desc);
        TextView preparacion = (TextView) findViewById(R.id.txt_preparacion);

        ImageView imagen = (ImageView) findViewById(R.id.iv_descripcion);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        if(bundle!=null){

            String i ="";
            ArrayList<String> ing = bundle.getStringArrayList("ING");


            for(String s : ing){
                i+="-"+s+"\n";
            }
            nombre.setText(bundle.getString("NOM"));
            ingredientes.setText(i);
            preparacion.setText(bundle.getString("PREP"));
            imagen.setImageResource(bundle.getInt("IMG"));

            if(bundle.getBoolean("FAV")){
                fab_like.setBackgroundTintList(cstFav);
                favorito = true;
            }

        }


        fab_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(favorito) {
                    fab_like.setBackgroundTintList(cstFav);
                    favorito = false;
                }else {
                    fab_like.setBackgroundTintList(cst);
                    favorito = true;
                }

            }
        });


    }
}

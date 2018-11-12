package com.cifprodolfoucha.icook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListarRecetas extends AppCompatActivity {

    ListView lista;

    String[][] datos = {

            {"Huevos fritos","Principales","1h 15min","Huevos,Patatas,Sal","Rompes los huevos en una sarten y los sacas cuando esten listos."},
            {"Ensalada","Entrantes","15min","Lechuga","Echas lechuga en un bol. Le echas lo que quieras y lo aliñas."},
            {"Chocolate","Postres","5min","Chocolate","Sacas una tableta de la alacena y listo."},
            {"Langostinos con gabardina","Entrantes","30min","16 langostinos,1 huevo,8 g de levadura,80 g de harina,60 ml de cerveza,1/2 limón,aceite de oliva virgen extra,sal,perejil","Para hacer la pasta orly, coloca el huevo en un bol y bátelo un poco con una varilla.\nAgrega la cerveza y sigue batiendo. \nIncorpora la harina, la levadura y una pizca de sal y sigue batiendo. \nDeja reposar 15 minutos.\nPela los langostinos dejándoles la parte final de la colita sin pelar. \nSazona. \nPásalos por la pasta orly y fríelos en una sartén con aceite. \nEscúrrelos sobre un plato cubierto con papel absorbente.\nSirve, adorna con el medio limón y una ramita de perejil."}
    };

    String[] ingredientes = {"huevos","patatas","sal"};
    int[] datosImg = {R.drawable.huevosfritos,R.drawable.ensalada,R.drawable.ic_fin_postre,R.drawable.presentacion};
/*
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String tipo = bundle.getString("TIPO");
        //referimos a la lista
        lista = (ListView) findViewById(R.id.lv_lista);

        String[][] datosFin = null;
        int[] datosImgFin = null;
        int contador = 0;
/*
        for(int i = 0 ; i<datosImg.length;i++)
            if (datos[i][1].equals(tipo)) {
                datosFin[contador][1] = datos[i][1];
                datosFin[contador][2] = datos[i][2];
                datosFin[contador][3] = datos[i][3];
                datosFin[contador][4] = datos[i][4];

                datosImgFin[contador] = datosImg[i];
                contador++;
            }
*/
        lista.setAdapter(new Adaptador(this,datos,datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent visorReceta = new Intent(view.getContext(),DetallesReceta.class);
                visorReceta.putExtra("NOM",datos[position][0]);
                visorReceta.putExtra("ING", datos[position][3]);
                visorReceta.putExtra("PREP",datos[position][4]);
                visorReceta.putExtra("IMG",datosImg[position]);
                startActivity(visorReceta);
            }
        });
/*

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListarRecetas.this,"Pulsado", RECEIVER_VISIBLE_TO_INSTANT_APPS);

                return false;
            };
        });*/

        registerForContextMenu(lista);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_longclick,menu);
    }


}

package com.cifprodolfoucha.icook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cifprodolfoucha.icook.clases.*;
import com.cifprodolfoucha.icook.adaptadores.AdaptadorListar;

import java.util.ArrayList;

public class ListarRecetas extends AppCompatActivity {

    ListView lista;

    ArrayList<Receta> recetas = new ArrayList<>();

    String[][] datos = {

            {"Huevos fritos","Principales","1h 15min","Huevos,Patatas,Sal","Rompes los huevos en una sarten y los sacas cuando esten listos."},
            {"Ensalada","Entrantes","15min","Lechuga","Echas lechuga en un bol. Le echas lo que quieras y lo aliñas."},
            {"Chocolate","Postres","5min","Chocolate","Sacas una tableta de la alacena y listo."},
            {"Langostinos con gabardina","Entrantes","30min","16 langostinos,1 huevo,8 g de levadura,80 g de harina,60 ml de cerveza,1/2 limón,aceite de oliva virgen extra,sal,perejil","Para hacer la pasta orly, coloca el huevo en un bol y bátelo un poco con una varilla.\nAgrega la cerveza y sigue batiendo. \nIncorpora la harina, la levadura y una pizca de sal y sigue batiendo. \nDeja reposar 15 minutos.\nPela los langostinos dejándoles la parte final de la colita sin pelar. \nSazona. \nPásalos por la pasta orly y fríelos en una sartén con aceite. \nEscúrrelos sobre un plato cubierto con papel absorbente.\nSirve, adorna con el medio limón y una ramita de perejil. asdasdasdasdasd\n ahsdhashdahsdhashdasd\n asdjasjdajsdjasjdjasdjajsdjasd\n \n aashdhasdahsdhasd"}
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

        FloatingActionButton addRec = (FloatingActionButton) findViewById(R.id.add_receipe);
        addRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        for(int i = 0 ; i<datosImg.length;i++){

            ArrayList<String> ingredientes = new ArrayList<>();
            if(datos[i][1].toUpperCase().trim().equals(tipo.toUpperCase().trim())){

                for(String s: datos[i][3].split(",")){
                    ingredientes.add(s);
                }
                                       //id,      imagen,     nombre,     tipo,       tiempo,  ingredientes,preparacion
                Receta r = new Receta(i+"",datosImg[i],datos[i][0],datos[i][1],datos[i][2],ingredientes,datos[i][4] );
                recetas.add(r);
            }
        }


        lista.setAdapter(new AdaptadorListar(this,recetas));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Receta r = recetas.get(position);

                Intent visorReceta = new Intent(view.getContext(),DetallesReceta.class);

                visorReceta.putExtra("NOM",r.getNombre());
                visorReceta.putExtra("ING", r.getIngredientes());
                visorReceta.putExtra("PREP",r.getPreparacion());
                visorReceta.putExtra("IMG",r.getImagen());
                visorReceta.putExtra("FAV",r.isFavorito());

                //visorReceta.putExtra("RECETA",Receta r);
                startActivity(visorReceta);
            }
        });

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

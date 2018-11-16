package com.cifprodolfoucha.icook.adaptadores;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.cifprodolfoucha.icook.clases.Receta;
import com.cifprodolfoucha.icook.R;

import java.util.ArrayList;

public class AdaptadorListar extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;

    ArrayList<Receta> recetas = new ArrayList<>();

    public AdaptadorListar(){

    }

    public AdaptadorListar(Context contexto, ArrayList<Receta> recetas){
        this.contexto = contexto;

        //this.tipo= tipo;

        this.recetas = recetas;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //creamos una vista a partir del layout modelo_lista
        final View vista = inflater.inflate(R.layout.modelo_lista,null);

        //introducimos los valores a partir de los id
        TextView nombre = (TextView) vista.findViewById(R.id.txt_titulo_receta);
        TextView tipo = (TextView) vista.findViewById(R.id.txt_tipo);
        TextView duracion = (TextView) vista.findViewById(R.id.txt_duracion);
        ImageView imgFav = (ImageView) vista.findViewById(R.id.iv_list_fav);

        Receta r = recetas.get(position);

        if(r.getNombre().equals("Langostinos con gabardina")){
            r.setFavorito(true);
        }

        ImageView imagen =(ImageView) vista.findViewById(R.id.iv_receta);

            nombre.setText(r.getNombre());
            tipo.setText(r.getTipo());
            duracion.setText("Tiempo estimado: " + r.getTiempo());
            imagen.setImageResource(r.getImagen());

            if(r.isFavorito()){

                imgFav.setImageResource(R.drawable.ic_favourites);
            }

        return vista;
    }

    @Override
    public int getCount() {
        return recetas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}

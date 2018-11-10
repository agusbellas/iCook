package com.cifprodolfoucha.icook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    String[][] datos;
    int[] datosImg;
    String tipo;

    public Adaptador(){

    }

    public Adaptador(Context contexto, String[][] datos, int[] imagenes){
        this.contexto = contexto;
        this.datos = datos;
        this.datosImg = imagenes;
        this.tipo= tipo;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //creamos una vista a partir del layout elementolista
        final View vista = inflater.inflate(R.layout.elemento_lista,null);

        //introducimos los valores a partir de los id
        TextView nombre = (TextView) vista.findViewById(R.id.txt_titulo_receta);
        TextView tipo = (TextView) vista.findViewById(R.id.txt_tipo);
        TextView duracion = (TextView) vista.findViewById(R.id.txt_duracion);

        ImageView imagen =(ImageView) vista.findViewById(R.id.iv_receta);

            nombre.setText(datos[position][0]);
            tipo.setText(datos[position][1]);
            duracion.setText("Tiempo estimado: " + datos[position][2]);
            imagen.setImageResource(datosImg[position]);

        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
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

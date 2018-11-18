package com.cifprodolfoucha.icook.Preferencias;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.cifprodolfoucha.icook.R;

public class DietaPref extends Activity {


    public static final String DATO_DIETA ="DIETA";

    private SharedPreferences datosGlobales;


    private void gestionPref() {

        final Spinner sp = (Spinner) findViewById(R.id.sp_dieta);


        Button aceptar = (Button)findViewById(R.id.btn_pref);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dato = "0";

                if (((String) sp.getSelectedItem()).equals(R.string.vegan)) {
                    dato = "1";
                } else if (((String) sp.getSelectedItem()).equals(R.string.veget)) {
                    dato = "2";
                } else if (((String) sp.getSelectedItem()).equals(R.string.all)) {
                    dato = "3";
                }

                SharedPreferences.Editor editorGlobal = datosGlobales.edit();
                editorGlobal.putString(DATO_DIETA, dato);
                editorGlobal.commit();


            }
        });


    }
}

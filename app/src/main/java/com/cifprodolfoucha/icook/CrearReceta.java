package com.cifprodolfoucha.icook;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.cifprodolfoucha.icook.adaptadores.GuardarImagen;


public class CrearReceta extends Activity {

    private final int CODIGO_IDENTIFICADOR=1;
    ImageView image;
    private void guardarFoto(){

    }


        //...
        private static final int CAMERA_PERMISSION_REQUEST_CODE = 1;
        private static final int TARJETASD_PERMISSION_REQUEST_CODE = 2;
        private static final  int REQUEST_IMAGE_CAPTURE=1;
        //...

        private void permissionGrantedT() {
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {


            if (requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK) {


                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");

                image = findViewById(R.id.iv_sacarFoto);
                image.setImageBitmap(imageBitmap);


                image.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        //convertir imagen a bitmap
                        image.buildDrawingCache();
                        Bitmap bmap = image.getDrawingCache();

                        //guardar imagen
                        GuardarImagen savefile = new GuardarImagen();
                        savefile.GuardarImagen(CrearReceta.this, bmap);
                        return false;
                    }
                });
            }
        }

        private void permissionGrantedF() {
            //Toast.makeText(this, getString(R.string.permission_granted), Toast.LENGTH_SHORT).show();



            Intent tomarFoto= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            if (tomarFoto.resolveActivity(getPackageManager()) !=null) {

                startActivityForResult(tomarFoto, REQUEST_IMAGE_CAPTURE);

            }


            Toast.makeText(this, "Aceptado", Toast.LENGTH_SHORT).show();
        }

        private void permissionRejected() {
            Toast.makeText(this, "Rechazado", Toast.LENGTH_SHORT).show();
        }



        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_crear_receta);




            Button boton = (Button)findViewById(R.id.btnSacarF);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ((Build.VERSION.SDK_INT >= 24)) {

                        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                            //Si el permiso no se encuentra concedido se solicita
                            requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
                        } else {
                            //Si el permiso esá concedico prosigue con el flujo normal
                            permissionGrantedF();
                        }

                    }
                }
            });

        }

    }

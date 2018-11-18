package com.cifprodolfoucha.icook;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cifprodolfoucha.icook.adaptadores.GuardarImagen;

public class ModificarReceta extends Activity {


    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1;
    private static final int REQUEST_IMAGE_CAPTURE=1;

    private Bundle extras;

    private Bitmap imageBitmap;
    ImageView image;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK) {

            extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");

            image = findViewById(R.id.iv_photo);
            image.setImageBitmap(imageBitmap);


            image.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    image.buildDrawingCache();
                    Bitmap bmap = image.getDrawingCache();

                    //guardamos imagen
                    GuardarImagen savefile = new GuardarImagen();
                    savefile.guardar(ModificarReceta.this, bmap);
                    return false;
                }
            });
        }
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

                    //comprobamos permiso
                    if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        //Solicitamos permiso
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
                    } else {

                        //sacamos foto
                        Intent tomarFoto= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                        if (tomarFoto.resolveActivity(getPackageManager()) !=null) {
                            startActivityForResult(tomarFoto, REQUEST_IMAGE_CAPTURE);
                        }

                    }

                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putParcelable("BitmapImage",imageBitmap);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        if(savedInstanceState != null) {

            Bitmap bitmapimage = savedInstanceState.getParcelable("BitmapImage");
            image = findViewById(R.id.iv_photo);
            image.setImageBitmap(bitmapimage);
        }

        super.onRestoreInstanceState(savedInstanceState);
    }
}

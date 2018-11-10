package com.cifprodolfoucha.icook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

public class Menu_Principal_iCook extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Aqui las funciones del boton flotante

        FloatingActionButton addRec = (FloatingActionButton) findViewById(R.id.add_receipe);
        addRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button entrantes = (Button) findViewById(R.id.btn_entrantes);
        entrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent visorReceta = new Intent(v.getContext(),ListarRecetas.class);
                visorReceta.putExtra("TIPO","Entrantes");
                startActivity(visorReceta);
            }
        });

        Button principales = (Button) findViewById(R.id.btn_principales);
        principales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorReceta = new Intent(v.getContext(),ListarRecetas.class);
                visorReceta.putExtra("TIPO","Principales");
                startActivity(visorReceta);
            }
        });

        Button postres = (Button) findViewById(R.id.btn_postres);
        postres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorReceta = new Intent(v.getContext(),ListarRecetas.class);
                visorReceta.putExtra("TIPO","Postres");
                startActivity(visorReceta);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu__principal_i_cook, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_preferences) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //acciones que ejecutaran dependiendo de la opcion del menu seleccionado

        if (id == R.id.nav_favoritos) {

        } else if (id == R.id.nav_entrantes) {

        } else if (id == R.id.nav_principales) {

        } else if (id == R.id.nav_postres) {

        }
        //Guardamos modelo en caso de que busquemos añadir mas al menu desplegable
        /* else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

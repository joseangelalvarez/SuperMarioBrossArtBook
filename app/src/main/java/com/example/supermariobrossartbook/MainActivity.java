package com.example.supermariobrossartbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.List;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.ActionBarDrawerToggle;

/**
 * Activity principal que muestra el listado de personajes.
 * Tiene un menú superior con "Acerca de..." y un Navigation Drawer lateral.
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PersonajeAdapter adapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topAppBar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                topAppBar,
                R.string.drawer_open,
                R.string.drawer_close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.nav_home) {
                    drawerLayout.closeDrawers();
                    return true;
                } else if (id == R.id.nav_ajustes) {
                    // Aquí podría ir la navegación a ajustes
                    drawerLayout.closeDrawers();
                    return true;
                } else if (id == R.id.nav_idioma) {
                    // Aquí podría ir la navegación a pantalla de idioma
                    drawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });

        // Lista de personajes
        List<Personaje> personajes = Arrays.asList(
                new Personaje("Mario", R.drawable.mario, "Héroe del Reino Champiñón", Arrays.asList("Salto alto", "Valentía")),
                new Personaje("Luigi", R.drawable.luigi, "Hermano de Mario", Arrays.asList("Salto alto", "Algo miedoso")),
                new Personaje("Peach", R.drawable.peach, "Princesa del Reino Champiñón", Arrays.asList("Planear en el aire", "Usar champiñones")),
                new Personaje("Toad", R.drawable.toad, "Habitante del Reino Champiñón", Arrays.asList("Velocidad", "Conocimiento del reino"))
        );

        recyclerView = findViewById(R.id.recyclerViewPersonajes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PersonajeAdapter(personajes, new PersonajeAdapter.OnPersonajeClickListener() {
            @Override
            public void onPersonajeClick(Personaje personajeSeleccionado) {
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("NOMBRE", personajeSeleccionado.getNombre());
                intent.putExtra("IMAGEN", personajeSeleccionado.getImagenResId());
                intent.putExtra("DESCRIPCION", personajeSeleccionado.getDescripcion());
                intent.putStringArrayListExtra("HABILIDADES", new java.util.ArrayList<>(personajeSeleccionado.getHabilidades()));
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

        // Mostrar Snackbar de bienvenida
        Snackbar.make(recyclerView, getString(R.string.bienvenido_mundo_mario), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_acerca_de) {
            mostrarDialogAcercaDe();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra un diálogo "Acerca de..." con información de la app.
     */
    private void mostrarDialogAcercaDe() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.acerca_de))
                .setIcon(R.mipmap.ic_launcher)
                .setMessage(getString(R.string.mensaje_acerca_de))
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Cerrar diálogo
                    }
                })
                .show();
    }
}

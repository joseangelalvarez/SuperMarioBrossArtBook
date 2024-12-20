package com.example.supermariobrossartbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Activity que muestra el detalle de un personaje seleccionado.
 * Recibe los datos a través del Intent desde MainActivity.
 */
public class DetalleActivity extends AppCompatActivity {
    private ImageView imgDetalle;
    private TextView tvNombre;
    private TextView tvDescripcion;
    private TextView tvHabilidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        imgDetalle = findViewById(R.id.imgDetalle);
        tvNombre = findViewById(R.id.tvNombreDetalle);
        tvDescripcion = findViewById(R.id.tvDescripcionDetalle);
        tvHabilidades = findViewById(R.id.tvHabilidadesDetalle);

        String nombre = getIntent().getStringExtra("NOMBRE");
        int imagen = getIntent().getIntExtra("IMAGEN", 0);
        String descripcion = getIntent().getStringExtra("DESCRIPCION");
        ArrayList<String> habilidades = getIntent().getStringArrayListExtra("HABILIDADES");

        imgDetalle.setImageResource(imagen);
        tvNombre.setText(nombre);
        tvDescripcion.setText(descripcion);

        if (habilidades != null) {
            tvHabilidades.setText(android.text.TextUtils.join(", ", habilidades));
        }

        // Mostrar Toast al abrir esta pantalla
        Toast.makeText(this, getString(R.string.personaje_seleccionado, nombre), Toast.LENGTH_SHORT).show();
    }
}

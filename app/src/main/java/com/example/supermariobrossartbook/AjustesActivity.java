package com.example.supermariobrossartbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class AjustesActivity extends AppCompatActivity {
    private Switch switchIdioma;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Antes de llamar a super.onCreate, ajustamos el idioma según la preferencia guardada
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isEnglish = prefs.getBoolean("idioma_ingles", false);
        aplicarIdioma(isEnglish ? "en" : "es");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        switchIdioma = findViewById(R.id.switch_idioma);
        switchIdioma.setChecked(isEnglish);

        switchIdioma.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Guardar la preferencia del idioma
            prefs.edit().putBoolean("idioma_ingles", isChecked).apply();
            finish();

            Intent intent = new Intent(AjustesActivity.this, MainActivity.class);
            startActivity(intent);

            // Ajustar el idioma nuevamente
            aplicarIdioma(isChecked ? "en" : "es");

            // Reiniciar la actividad para que se apliquen los cambios
            recreate();
        });
    }

    /**
     * Aplica la configuración de idioma antes de inflar la vista.
     * @param languageCode Código del idioma, por ejemplo "en" o "es".
     */
    private void aplicarIdioma(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        // Actualizar configuración
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}


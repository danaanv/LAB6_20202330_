package com.example.lab6_20202330_;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_ingresos:
                        loadFragment(new IngresosFragment());
                        return true;
                    case R.id.navigation_egresos:
                        loadFragment(new EgresosFragment());
                        return true;
                    case R.id.navigation_resumen:
                        loadFragment(new ResumenFragment());
                        return true;
                    case R.id.navigation_cerrar_sesion:
                        // Cerrar sesión y volver a la pantalla de inicio de sesión
                        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        return true;
                }
                return false;
            }
        });
        // Cargar el fragmento por defecto
        loadFragment(new IngresosFragment());
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}

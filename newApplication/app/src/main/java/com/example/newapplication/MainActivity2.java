package com.example.newapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button btnDrama, btnComics, btnFantasy, btnScience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Gestion EdgeToEdge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buttonsContainer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Liaison des boutons
        btnDrama = findViewById(R.id.btnDrama);
        btnComics = findViewById(R.id.btnComics);
        btnFantasy = findViewById(R.id.btnFantasy);
        btnScience = findViewById(R.id.btnScience);

        // Listeners sur les boutons
        btnDrama.setOnClickListener(v -> {
            Toast.makeText(MainActivity2.this, "Drama sélectionné", Toast.LENGTH_SHORT).show();
            // Ici tu peux ouvrir une nouvelle activité pour les livres Drama
        });

        btnComics.setOnClickListener(v -> {
            Toast.makeText(MainActivity2.this, "Comics sélectionné", Toast.LENGTH_SHORT).show();
            // Ici tu peux ouvrir une nouvelle activité pour les livres Comics
        });

        btnFantasy.setOnClickListener(v -> {
            Toast.makeText(MainActivity2.this, "Fantasy sélectionné", Toast.LENGTH_SHORT).show();
            // Ici tu peux ouvrir une nouvelle activité pour les livres Fantasy
        });

        btnScience.setOnClickListener(v -> {
            Toast.makeText(MainActivity2.this, "Science sélectionné", Toast.LENGTH_SHORT).show();
            // Ici tu peux ouvrir une nouvelle activité pour les livres Science
        });
    }
}

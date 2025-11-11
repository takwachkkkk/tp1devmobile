package com.example.newapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btnDrama, btnComics, btnFantasy, btnScience, btnretour;
    TextView tvBonjour; // TextView pour afficher le message de bienvenue

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // ton fichier XML

        // 🔹 Liaison avec les vues XML
        btnDrama = findViewById(R.id.btnDrama);
        btnComics = findViewById(R.id.btnComics);
        btnFantasy = findViewById(R.id.btnFantasy);
        btnScience = findViewById(R.id.btnScience);
        btnretour = findViewById(R.id.btnretour);
        tvBonjour = findViewById(R.id.tvBonjour);

        // 🔹 Récupération prénom/nom depuis Intent
        Intent intent = getIntent();
        String prenom = intent.getStringExtra("prenom");
        String nom = intent.getStringExtra("nom");

        if (prenom != null && nom != null) {
            tvBonjour.setText("Bonjour " + prenom + " " + nom );
        }


        // 🔹 Écouteurs pour chaque bouton
        btnDrama.setOnClickListener(v ->
                Toast.makeText(MainActivity2.this, "Catégorie : Drama ", Toast.LENGTH_SHORT).show()
        );

        btnComics.setOnClickListener(v ->
                Toast.makeText(MainActivity2.this, "Catégorie : Comics ", Toast.LENGTH_SHORT).show()
        );

        btnFantasy.setOnClickListener(v ->
                Toast.makeText(MainActivity2.this, "Catégorie : Fantasy ", Toast.LENGTH_SHORT).show()
        );

        btnScience.setOnClickListener(v ->
                Toast.makeText(MainActivity2.this, "Catégorie : Science ", Toast.LENGTH_SHORT).show()
        );

        // 🔹 Bouton retour vers MainActivity
        btnretour.setOnClickListener(v -> {
            Intent retourIntent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(retourIntent);
            finish(); // ferme MainActivity2 pour ne pas revenir dessus
        });
    }
}

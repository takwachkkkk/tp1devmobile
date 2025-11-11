package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editEmail, editPassword;
    Button btnLogin, btnCreateAccount;
    ProgressBar progBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // ton XML

        // Liaison avec les vues
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnlogin);
        btnCreateAccount = findViewById(R.id.btnlogin1);
        progBar = findViewById(R.id.progbar);

        progBar.setVisibility(View.GONE);

        //  Bouton Login → Aller à la page des catégories
        btnLogin.setOnClickListener(v -> {
            String email = editEmail.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Veuillez remplir les deux champs", Toast.LENGTH_SHORT).show();
            } else {
                progBar.setVisibility(View.VISIBLE);
                btnLogin.setEnabled(false);

                // Simulation d’un chargement (2 secondes)
                progBar.postDelayed(() -> {
                    progBar.setVisibility(View.GONE);
                    btnLogin.setEnabled(true);

                    // Extraction prénom et nom depuis l’email
                    String prenom = "";
                    String nom = "";
                    if (email.contains("@")) {
                        String part = email.split("@")[0]; // "prenom.nom"
                        String[] names = part.split("\\.");
                        if (names.length == 2) {
                            prenom = names[0];
                            nom = names[1];
                        }
                    }
                    //  Passage à MainActivity2
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("prenom", prenom);
                    intent.putExtra("nom", nom);
                    startActivity(intent);
                    finish();
                }, 2000);
            }
        });
        // Bouton "Créer un nouveau compte" → Aller à la page de création
        btnCreateAccount.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);
        });
    }
}

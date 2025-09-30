package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail, editPassword;
    private Button btnLogin;
    private ProgressBar progbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Relie le Java avec ton XML

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnlogin);   // ⚠️ correspond à ton XML
        progbar = findViewById(R.id.progbar);

        btnLogin.setOnClickListener(v -> {
            progbar.setVisibility(View.VISIBLE); // Affiche la barre

            String email = editEmail.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Connexion réussie !", Toast.LENGTH_SHORT).show();
            }

            progbar.setVisibility(View.GONE); // Cache après le traitement
        });
    }
}


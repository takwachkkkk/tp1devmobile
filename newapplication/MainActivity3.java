package com.example.newapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText editEmail, editDate, editPhone, editPassword;
    Button btnCreateAccount;
    ProgressBar progBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3); // ton XML de création de compte

        // 🔹 Liaison avec les vues XML
        editEmail = findViewById(R.id.editEmail);
        editDate = findViewById(R.id.editdate);
        editPhone = findViewById(R.id.editphone);
        editPassword = findViewById(R.id.editPassword);
        btnCreateAccount = findViewById(R.id.btnlogin1);
        progBar = findViewById(R.id.progbar);

        // Masquer la barre de progression au début
        progBar.setVisibility(View.GONE);

        // 🔹 Action du bouton "Créer un nouveau compte"
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editEmail.getText().toString().trim();
                String date = editDate.getText().toString().trim();
                String phone = editPhone.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                // Vérification basique des champs
                if (email.isEmpty() || date.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity3.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    // Affiche la barre de progression
                    progBar.setVisibility(View.VISIBLE);
                    btnCreateAccount.setEnabled(false);

                    // Simulation du processus d’inscription (2 secondes)
                    progBar.postDelayed(() -> {
                        progBar.setVisibility(View.GONE);
                        btnCreateAccount.setEnabled(true);

                        // 🔹 Affiche le toast
                        Toast toast = Toast.makeText(MainActivity3.this, "Compte enregistré ", Toast.LENGTH_SHORT);
                        toast.show();

                        // 🔹 Démarre MainActivity2 après 1 seconde (1000 ms)
                        btnCreateAccount.postDelayed(() -> {
                            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                            startActivity(intent);
                            finish();
                        }, 1000);

                    }, 2000); // délai simulation création compte
                }
            }
        });
    }
}

package com.example.newapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private EditText editEmail, editDate, editPhone, editPassword;
    private Button btnCreateAccount;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Gestion EdgeToEdge (optionnel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Liaison des vues XML avec le Java
        editEmail = findViewById(R.id.editEmail);
        editDate = findViewById(R.id.editdate);
        editPhone = findViewById(R.id.editphone);
        editPassword = findViewById(R.id.editPassword);
        btnCreateAccount = findViewById(R.id.btnlogin1);
        progressBar = findViewById(R.id.progbar);

        // ProgressBar caché par défaut
        progressBar.setVisibility(View.GONE);

        // Listener sur le bouton
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Afficher la ProgressBar pendant l'opération
                progressBar.setVisibility(View.VISIBLE);

                // Récupérer les valeurs saisies
                String email = editEmail.getText().toString().trim();
                String date = editDate.getText().toString().trim();
                String phone = editPhone.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                // Vérification simple
                if(email.isEmpty() || date.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity3.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                // Ici tu peux ajouter le code pour enregistrer l'utilisateur
                // Par exemple, envoyer à un serveur ou sauvegarder en local
                Toast.makeText(MainActivity3.this, "Compte créé avec succès !", Toast.LENGTH_SHORT).show();

                // Cacher la ProgressBar après l'opération
                progressBar.setVisibility(View.GONE);

                // Optionnel : vider les champs
                editEmail.setText("");
                editDate.setText("");
                editPhone.setText("");
                editPassword.setText("");
            }
        });
    }
}

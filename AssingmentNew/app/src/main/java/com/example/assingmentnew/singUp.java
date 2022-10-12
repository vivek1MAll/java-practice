package com.example.assingmentnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class singUp extends AppCompatActivity {

    EditText email, password;
    Button sign;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        firebaseAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.emailSingUp);
        password = findViewById(R.id.passwordSingUp);
        sign = findViewById(R.id.singUp);

        sign.setOnClickListener(view -> createAccount());


    }

    public void createAccount() {
        String email1 = email.getText().toString();
        String password1 = password.getText().toString();

        boolean isValidate = validateEmail(email1, password1);
        if (!isValidate) {
            return;
        }
        createMethodForFirebase(email1, password1);

    }

    public void createMethodForFirebase(String email1, String password1) {
        firebaseAuth.createUserWithEmailAndPassword(email1, password1).addOnCompleteListener(singUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(singUp.this, "The user is created", Toast.LENGTH_SHORT).show();
                    Objects.requireNonNull(firebaseAuth.getCurrentUser()).sendEmailVerification();
                    firebaseAuth.signOut();
                    finish();
                } else {
                    Toast.makeText(singUp.this, Objects.requireNonNull(task.getException()).getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            }

        });


    }

    boolean validateEmail(String email1, String password1) {
        if (email1.length() <= 0 & !Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            email.setError("email is invalid");
            return false;
        }
        if (password1.length() <= 0 & password1.matches("@!#%&")) {
            password.setError("your pass word is to short");
            return false;

        }
        return true;
    }
}



package com.example.assingmentnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class loginPage extends AppCompatActivity {

    EditText emailLogin, passwordLogin;
    Button login;
    TextView forgetPassword, singUpScreen;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        emailLogin = findViewById(R.id.emailLogin);
        passwordLogin = findViewById(R.id.passwordLogin);
        forgetPassword = findViewById(R.id.forgetPassword);
        singUpScreen = findViewById(R.id.singUp);
        login = findViewById(R.id.loginbtn);

        firebaseAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(view -> loginUser());

        singUpScreen.setOnClickListener(view -> startActivity(new Intent(this, singUp.class)));


    }

    public void loginUser() {
        String emailLogin = this.emailLogin.getText().toString();
        String passwordLogin = this.passwordLogin.getText().toString();

        boolean isValidate = validateEmail(emailLogin, passwordLogin);
        if (!isValidate) {
            return;
        }
        createMethodForFirebaseLogin(emailLogin, passwordLogin);


    }

    private void createMethodForFirebaseLogin(String emailLogin, String passwordLogin) {

        firebaseAuth.signInWithEmailAndPassword(emailLogin, passwordLogin).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(loginPage.this, "login Successfully", Toast.LENGTH_SHORT).show();
                firebaseAuth.getCurrentUser();
                firebaseAuth.signOut();
                finish();
            } else {
                Toast.makeText(loginPage.this, "login not successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }


    boolean validateEmail(String email1, String password1) {
        if (email1.length() <= 0 & !Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            emailLogin.setError("email is invalid");
            return false;
        }
        if (password1.length() <= 0) {
            passwordLogin.setError("your pass word is to short");
            return false;

        }
        return true;
    }


}


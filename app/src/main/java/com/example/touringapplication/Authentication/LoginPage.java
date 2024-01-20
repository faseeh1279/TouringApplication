package com.example.touringapplication.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.view.Window;
import android.view.WindowManager;
import com.example.touringapplication.MainActivity;
import com.example.touringapplication.MainUI.HomePage;
import com.example.touringapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText ed1, ed2;
    Button btn_signup, btn_signin;
    ProgressBar progressBar;

    SharedPreferences sharedPreferences;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_page);
        ed1 =  findViewById(R.id.email);
        ed2 = findViewById(R.id.password);
        btn_signin = findViewById(R.id.btn_sign_in);
        btn_signup = findViewById(R.id.btn_sign_up);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.INVISIBLE);
        firebaseAuth = FirebaseAuth.getInstance();
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        String email = sharedPreferences.getString("email", null);
        String password = sharedPreferences.getString("password", null);
        if ((email!=null)&&(password!=null)){
            Intent obj = new Intent(LoginPage.this, MainActivity.class);
            startActivity(obj);
        }

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(LoginPage.this, SignUp.class);
                startActivity(obj);
            }
        });
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email = ed1.getText().toString();
                String password = ed2.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progressBar.setVisibility(View.INVISIBLE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email", email);
                        editor.putString("password", password);
                        editor.apply();
                        Intent obj = new Intent(LoginPage.this, MainActivity.class);
                        startActivity(obj);
                        Toast.makeText(LoginPage.this, "Login Successfull!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(LoginPage.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
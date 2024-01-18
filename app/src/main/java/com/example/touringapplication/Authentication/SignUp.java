package com.example.touringapplication.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.view.Window;
import android.view.WindowManager;
import com.example.touringapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText ed1, ed2;
    Button btn_signin, btn_signup;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        ed1 = findViewById(R.id.email);
        ed2 = findViewById(R.id.password);
        btn_signin = findViewById(R.id.btn_sign_in);
        btn_signup = findViewById(R.id.btn_sign_up);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.INVISIBLE);
        firebaseAuth = FirebaseAuth.getInstance();
        btn_signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent obj = new Intent(SignUp.this, LoginPage.class);
                startActivity(obj);
            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email = ed1.getText().toString();
                String password = ed2.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(SignUp.this, "Sign Up Successfully!", Toast.LENGTH_SHORT).show();
                        Intent obj = new Intent(SignUp.this, LoginPage.class);
                        progressBar.setVisibility(View.INVISIBLE);
                        startActivity(obj);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(SignUp.this, "Something Went Wrong! Try Again", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
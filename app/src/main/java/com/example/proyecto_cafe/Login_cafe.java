package com.example.proyecto_cafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_cafe extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText correo;
    private EditText clave;
    //private Button ingresar;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cafe);

        mAuth = FirebaseAuth.getInstance();

        correo=(EditText) findViewById(R.id.txt_correo);
        clave=(EditText) findViewById(R.id.clave);



        //ingresar= (Button) findViewById(R.id.btn_ingresar);
        registrar= (Button) findViewById(R.id.btn_registro);

       /* ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next=new Intent(Login_cafe.this,Menu_principal.class);
                startActivity(next);


            }
        }); */
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next=new Intent(Login_cafe.this,Registrarse.class);
                startActivity(next);
            }
        });
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void IniciarSesion (View view)
    {


        if (checkEmptyFields(correo, clave)){
            mAuth.signInWithEmailAndPassword(correo.getText().toString(), clave.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(Login_cafe.this, "Autenticación exitosa.",
                                        Toast.LENGTH_SHORT).show();
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent next=new Intent(Login_cafe.this,Menu_principal.class);
                                startActivity(next);

                            } else {

                                Toast.makeText(Login_cafe.this, "Autenticación Fallida.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }else{
            Toast.makeText(this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
        }



    }

    public boolean checkEmptyFields(EditText user, EditText pass){

        return !user.getText().toString().equals("") && !pass.getText().toString().equals("");

    }




}
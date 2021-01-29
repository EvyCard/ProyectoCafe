package com.example.proyecto_cafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.google.firebase.auth.FirebaseAuth;

public class Menu_principal extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private Button cerrar_sesion;
    //private GridView menup;
    private CardView materiap;
    private CardView proceso;
    private CardView envasado;
    private CardView analisis_calidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        mAuth = FirebaseAuth.getInstance();

        materiap =(CardView) findViewById(R.id.card_materiap);
        proceso=(CardView) findViewById(R.id.card_procesa);
        envasado=(CardView) findViewById(R.id.card_envasado);
        analisis_calidad=(CardView) findViewById(R.id.card_analisis);

        materiap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modulo =new Intent(Menu_principal.this, Recepcion_almacenamiento.class);
                startActivity(modulo);
            }
        });

        proceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modulo =new Intent(Menu_principal.this, Pantalla4_2.class);
                startActivity(modulo);
            }
        });

        envasado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modulo =new Intent(Menu_principal.this, Envase_etiquetado.class);
                startActivity(modulo);
            }
        });

        analisis_calidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modulo =new Intent(Menu_principal.this, Pantalla_ensayo.class);
                startActivity(modulo);
            }
        });

        cerrar_sesion=(Button) findViewById(R.id.btn_cerrar);
        //menup=(GridView) findViewById(R.id.main_menu);


        cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signOut();

                Intent finish=new Intent(Menu_principal.this,Login_cafe.class);
                startActivity(finish);


            }
        });
    }




}
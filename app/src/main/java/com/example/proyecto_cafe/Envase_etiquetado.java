package com.example.proyecto_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_cafe.controllers.EnvaseEtiquetado;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Envase_etiquetado extends AppCompatActivity {

    private Button regresar;
    private Button siguiente;

    private EditText fechaEnvasado;
    private EditText cantidadEmpaques;
    private EditText cantidadCajas;
    private EditText fechaEtiquetado;
    private EditText fechaElaboracion;
    private EditText fechaCaducidad;

    public boolean emptyFields(EditText fechaEnvasado, EditText cantidadEmpaques, EditText cantidadCajas,
                               EditText fechaEtiquetado, EditText fechaElaboracion, EditText fechaCaducidad){

        return !fechaEnvasado.getText().toString().equals("") && !cantidadEmpaques.getText().toString().equals("") && !cantidadCajas.getText().toString().equals("")&&
                !fechaEtiquetado.getText().toString().equals("") && !fechaElaboracion.getText().toString().equals("") && !fechaCaducidad.getText().toString().equals("");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envase_etiquetado);

        fechaEnvasado = (EditText) findViewById(R.id.fechaEnvasado);
        cantidadEmpaques = (EditText) findViewById(R.id.cantidadEmpaques);
        cantidadCajas = (EditText) findViewById(R.id.cantidadCajas);
        fechaEtiquetado = (EditText) findViewById(R.id.fechaEtiquetado);
        fechaElaboracion = (EditText) findViewById(R.id.fechaElaboracion);
        fechaCaducidad = (EditText) findViewById(R.id.fechaCaducidad);




        siguiente= (Button) findViewById(R.id.btn_siguiente);
        regresar= (Button) findViewById(R.id.btn_regresar);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next=new Intent(Envase_etiquetado.this, Pantalla_ensayo.class);
                startActivity(next);


            }
        });


        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent back=new Intent(Envase_etiquetado.this, Pantalla4_2.class);
                startActivity(back);


            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.opciones,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int idm = item.getItemId();
        if (idm==R.id.op_home) {
            Toast.makeText(Envase_etiquetado.this, "Ir a Menú Principal", Toast.LENGTH_SHORT).show();
            Intent menup=new Intent(Envase_etiquetado.this,Menu_principal.class);
            startActivity(menup);

        }
        else if(idm==R.id.op_list){
            Toast.makeText(Envase_etiquetado.this, "Ver lista", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_add){
            Toast.makeText(Envase_etiquetado.this, "Agregar", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_save){

            if (emptyFields( fechaEnvasado,  cantidadEmpaques,  cantidadCajas,
                     fechaEtiquetado,  fechaElaboracion, fechaCaducidad)){

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference("envasado");

                EnvaseEtiquetado envase = new EnvaseEtiquetado(fechaEnvasado.getText().toString(), cantidadEmpaques.getText().toString(),
                        cantidadCajas.getText().toString(), fechaEtiquetado.getText().toString(), fechaElaboracion.getText().toString(), fechaCaducidad.getText().toString());

                databaseReference.setValue(envase);

                Toast.makeText(this, "Datos guardados exitosamente", Toast.LENGTH_SHORT).show();
                fechaEnvasado.setText("");
                cantidadEmpaques.setText("");
                cantidadCajas.setText("");
                fechaEtiquetado.setText("");
                fechaElaboracion.setText("");
                fechaCaducidad.setText("");

            }


            Toast.makeText(Envase_etiquetado.this, "Guardar", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_delete){
            Toast.makeText(Envase_etiquetado.this, "Eliminar", Toast.LENGTH_SHORT).show();

        }
        return true;




    }
}
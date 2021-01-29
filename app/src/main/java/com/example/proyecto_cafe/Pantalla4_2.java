package com.example.proyecto_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyecto_cafe.controllers.Pantalla_4_class;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Pantalla4_2 extends AppCompatActivity {

    private Button regresar;
    private Button siguiente;
    private Spinner color_sp;


    private EditText pesoCafe;
    private EditText pesoCafeTostado;
    private EditText pesoHidrolosis;
    private EditText pesoExtracto;
    private EditText pesoConcentrado;
    private EditText pesoCafeSoluble;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla4_2);

        siguiente= (Button) findViewById(R.id.btn_siguiente);
        regresar= (Button) findViewById(R.id.btn_regresar);
        color_sp=(Spinner) findViewById(R.id.spinner_color);

        String[] color={"Claro","Medio","Oscuro","Extra Oscuro"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,color);
        color_sp.setAdapter(adapter);


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next=new Intent(Pantalla4_2.this, Envase_etiquetado.class);
                startActivity(next);


            }
        });


        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent back=new Intent(Pantalla4_2.this, Recepcion_almacenamiento.class);
                startActivity(back);


            }
        });

        pesoCafe = (EditText) findViewById(R.id.pesoCafe);
        pesoCafeTostado = (EditText)findViewById(R.id.pesoCafeTostado);
        pesoHidrolosis = (EditText)findViewById(R.id.pesoHidrolosis);
        pesoExtracto = (EditText) findViewById(R.id.pesoExtracto);
        pesoConcentrado = (EditText) findViewById(R.id.pesoConcentrado);
        pesoCafeSoluble = (EditText) findViewById(R.id.pesoCafeSoluble);



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
            Toast.makeText(Pantalla4_2.this, "Ir a Menú Principal", Toast.LENGTH_SHORT).show();
            Intent menup=new Intent(Pantalla4_2.this,Menu_principal.class);
            startActivity(menup);

        }
        else if(idm==R.id.op_list){
            Toast.makeText(Pantalla4_2.this, "Ver lista", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_add){






            Toast.makeText(Pantalla4_2.this, "Agregar", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_save){

            if(emptyFields(pesoCafe,pesoCafeTostado, pesoHidrolosis, pesoExtracto, pesoConcentrado, pesoCafeSoluble)){
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference baseAdapter = firebaseDatabase.getReference("proceso");

                Pantalla_4_class pantallazo = new Pantalla_4_class(
                        Integer.parseInt(pesoCafe.getText().toString()),
                        Integer.parseInt(pesoCafeTostado.getText().toString()),
                        Integer.parseInt(pesoHidrolosis.getText().toString()),
                        Integer.parseInt(pesoExtracto.getText().toString()) ,
                        Integer.parseInt(pesoConcentrado.getText().toString()) ,
                        Integer.parseInt(pesoCafeSoluble.getText().toString()) ,
                        color_sp.getSelectedItem().toString());


                baseAdapter.setValue(pantallazo);
                Toast.makeText(Pantalla4_2.this, "Guardar", Toast.LENGTH_SHORT).show();


                pesoCafe.setText("");
                pesoCafeTostado.setText("");
                pesoHidrolosis.setText("");
                pesoExtracto.setText("");
                pesoConcentrado.setText("");
                pesoCafeSoluble.setText("");
            }










        }
        else if(idm==R.id.op_delete){
            Toast.makeText(Pantalla4_2.this, "Eliminar", Toast.LENGTH_SHORT).show();

        }
        return true;




    }

    public boolean emptyFields(EditText pesoCafe,
             EditText pesoCafeTostado,
             EditText pesoHidrolosis,
             EditText pesoExtracto,
             EditText pesoConcentrado,
             EditText pesoCafeSoluble){


        return !pesoCafe.getText().toString().equals("") && !pesoCafeTostado.getText().toString().equals("") && !pesoHidrolosis.getText().toString().equals("") &&
                !pesoExtracto.getText().toString().equals("") && !pesoConcentrado.getText().toString().equals("") && !pesoCafeSoluble.getText().toString().equals("");

    }



}
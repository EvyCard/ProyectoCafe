package com.example.proyecto_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Pantalla4_2 extends AppCompatActivity {

    private Button regresar;
    private Button siguiente;
    private Spinner color_sp;

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
            Toast.makeText(Pantalla4_2.this, "Guardar", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_delete){
            Toast.makeText(Pantalla4_2.this, "Eliminar", Toast.LENGTH_SHORT).show();

        }
        return true;




    }
}
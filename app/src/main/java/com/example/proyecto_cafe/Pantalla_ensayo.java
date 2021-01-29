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

public class Pantalla_ensayo extends AppCompatActivity {

    private Button regresar;
    private Button siguiente;
    private Spinner sp_aroma;
    private Spinner sp_sabor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_ensayo);


        siguiente= (Button) findViewById(R.id.btn_siguiente);
        regresar= (Button) findViewById(R.id.btn_regresar);
        sp_aroma=(Spinner) findViewById(R.id.aroma);
        sp_sabor=(Spinner) findViewById(R.id.sabor);

        Integer[] sabor={1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> adapter1=new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item,sabor);
        sp_sabor.setAdapter(adapter1);

        Integer[] aroma={1,2,3,4,5};
        ArrayAdapter<Integer> adapter2=new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,aroma);
        sp_aroma.setAdapter(adapter2);


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next=new Intent(Pantalla_ensayo.this, Reporte.class);
                startActivity(next);


            }
        });


        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent back=new Intent(Pantalla_ensayo.this, Envase_etiquetado.class);
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
            Toast.makeText(Pantalla_ensayo.this, "Ir a Menú Principal", Toast.LENGTH_SHORT).show();
            Intent menup=new Intent(Pantalla_ensayo.this,Menu_principal.class);
            startActivity(menup);

        }
        else if(idm==R.id.op_list){
            Toast.makeText(Pantalla_ensayo.this, "Ver lista", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_add){
            Toast.makeText(Pantalla_ensayo.this, "Agregar", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_save){
            Toast.makeText(Pantalla_ensayo.this, "Guardar", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_delete){
            Toast.makeText(Pantalla_ensayo.this, "Eliminar", Toast.LENGTH_SHORT).show();

        }
        return true;




    }
}
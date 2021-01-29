package com.example.proyecto_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Reporte extends AppCompatActivity {

    private Button regresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        regresar=(Button)findViewById(R.id.btn_regresar);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent regresar=new Intent(Reporte.this, Pantalla_ensayo.class);
                startActivity(regresar);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.opciones,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item=menu.findItem(R.id.op_list);
        MenuItem item2=menu.findItem(R.id.more);
        item.setEnabled(false);
        item2.setEnabled(false);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int idm = item.getItemId();
        if (idm==R.id.op_home) {
            Toast.makeText(Reporte.this, "Ir a Menú Principal", Toast.LENGTH_SHORT).show();
            Intent menup=new Intent(Reporte.this,Menu_principal.class);
            startActivity(menup);

       }

        /*
        else if(idm==R.id.op_list){
            setVisible(false);
            //Toast.makeText(Reporte.this, "Ver lista", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_add){
            setVisible(false);
            //Toast.makeText(Reporte.this, "Agregar", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_save){
            setVisible(false);
            //Toast.makeText(Reporte.this, "Guardar", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_delete){
            setVisible(false);
            //Toast.makeText(Reporte.this, "Eliminar", Toast.LENGTH_SHORT).show();

        }*/
        return true;




    }
}
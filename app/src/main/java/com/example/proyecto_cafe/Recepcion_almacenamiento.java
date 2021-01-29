package com.example.proyecto_cafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Recepcion_almacenamiento extends AppCompatActivity {

    private EditText fecha_mp;
    private EditText lotes_acep;
    private EditText lotes_rechazados;
    private EditText sacos_cafe_r;
    private EditText sacos_cafe_a;
    private LinearLayout contenedor_list_mp;

    private RadioButton ag1;
    private RadioButton ag2;
    private RadioButton ag3;
    private RadioButton ag4;
    private RadioButton select_ag;
    private RadioButton select_rg;

    private RadioButton rg1;
    private RadioButton rg2;
    private RadioButton rg3;

    private RadioGroup radiog_arab;
    //private RadioGroup radiog_rob;


    private Button siguiente;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepcion_almacenamiento);



        fecha_mp=(EditText) findViewById(R.id.fecha_mp);
        lotes_acep=(EditText) findViewById(R.id.lotes_acept);
        lotes_rechazados=(EditText) findViewById(R.id.lotes_rechazados);
        sacos_cafe_r=(EditText) findViewById(R.id.saco_cafe_r);
        sacos_cafe_a=(EditText) findViewById(R.id.saco_cafe_a);
        ag1=(RadioButton) findViewById(R.id.rd_ag1);
        ag2=(RadioButton) findViewById(R.id.rd_ag2);
        ag3=(RadioButton) findViewById(R.id.rd_ag3);
        ag4=(RadioButton) findViewById(R.id.rd_ag4);
        rg1=(RadioButton)findViewById(R.id.rd_rg1);
        rg2=(RadioButton)findViewById(R.id.rd_rg2);
        rg3=(RadioButton)findViewById(R.id.rd_rg3);
        //radiog_arab=(RadioGroup)findViewById(R.id.radiogroup_arab);
        //radiog_rob=(RadioGroup)findViewById(R.id.radiogroup_rob);
        contenedor_list_mp=(LinearLayout) findViewById(R.id.conten_list_mp);

        inicializarFirebase();

        siguiente = (Button) findViewById(R.id.btn_siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next = new Intent(Recepcion_almacenamiento.this, Pantalla4_2.class);
                startActivity(next);
            }
        });

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.opciones,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String m_fecha_mp= fecha_mp.getText().toString();
        String m_lotes_acept=lotes_acep.getText().toString();
        String m_lotes_rechazado=lotes_rechazados.getText().toString();
        String m_sacos_cafe_arab=sacos_cafe_a.getText().toString();
        String m_sacos_cafe_rob=sacos_cafe_r.getText().toString();
        String m_id_mp;
        //String m_grado_rob=select_rg.getText().toString();
        //String m_grado_arab=select_ag.getText().toString();

        int idm = item.getItemId();
        if (idm==R.id.op_home) {
            Intent menuprincipal=new Intent(Recepcion_almacenamiento.this,Menu_principal.class);
            startActivity(menuprincipal);
            Toast.makeText(Recepcion_almacenamiento.this, "Ir a Menú Principal", Toast.LENGTH_SHORT).show();


        }
        else if(idm==R.id.op_list){
            contenedor_list_mp.setVisibility(View.VISIBLE);
            Toast.makeText(Recepcion_almacenamiento.this, "Ver lista", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_add){
            if(m_fecha_mp.equals("") || m_lotes_acept.equals("")|| m_lotes_rechazado.equals("")|| m_sacos_cafe_arab.equals("")|| m_sacos_cafe_rob.equals("")/*|| m_grado_rob.equals("")|| m_grado_arab.equals("")*/){
                validacion();
            }
            else {
                Modelo_MateriaPrima modelo_mp= new Modelo_MateriaPrima();
                //modelo_mp.setM_id_mp(m_id_mp);
                modelo_mp.setM_fecha_mp(m_fecha_mp);
                modelo_mp.setM_lotes_acept(m_lotes_acept);
                modelo_mp.setM_lotes_rechazado(m_lotes_rechazado);
                modelo_mp.setM_sacos_cafe_arab(m_sacos_cafe_arab);
                modelo_mp.setM_sacos_cafe_arab(m_sacos_cafe_arab);
                databaseReference.child("materia_prima").child(modelo_mp.getM_id_mp()).setValue(modelo_mp);

                Toast.makeText(Recepcion_almacenamiento.this, "Agregar", Toast.LENGTH_SHORT).show();
                LimpiarCajas();
            }

        }
        else if(idm==R.id.op_save){
            Toast.makeText(Recepcion_almacenamiento.this, "Guardar", Toast.LENGTH_SHORT).show();

        }
        else if(idm==R.id.op_delete){
            Toast.makeText(Recepcion_almacenamiento.this, "Eliminar", Toast.LENGTH_SHORT).show();

        }
        return true;




        }

    private void LimpiarCajas() {

        fecha_mp.setText(" ");
        lotes_acep.setText(" ");
        lotes_rechazados.setText(" ");
        sacos_cafe_r.setText(" ");
        sacos_cafe_a.setText(" ");
    }

    private void validacion() {
        String m_fecha_mp= fecha_mp.getText().toString();
        String m_lotes_acept=lotes_acep.getText().toString();
        String m_lotes_rechazado=lotes_rechazados.getText().toString();
        String m_sacos_cafe_arab=sacos_cafe_a.getText().toString();
        String m_sacos_cafe_rob=sacos_cafe_r.getText().toString();
        //String m_grado_rob=select_rg.getText().toString();
        //String m_grado_arab=select_ag.getText().toString();

        if(m_fecha_mp.equals("")){
            fecha_mp.setError("Debe ingresar una fecha");
        }
        else if(m_lotes_acept.equals("")){
            lotes_acep.setError("Debe ingresar la cantidad de lotes aceptados");

        }
        else if (m_lotes_rechazado.equals("")){
            lotes_rechazados.setError("Debe ingresar la cantidad de lotes rechazados");
        }
        else if (m_sacos_cafe_arab.equals("")){
            sacos_cafe_a.setError("Debe ingresar la cantidad de sacos de café arábico");
        }
        else if (m_sacos_cafe_rob.equals("")){
            sacos_cafe_r.setError("Debe ingresar la cantidad de de sacos de café robusta");        }
       /* else if (m_grado_rob.equals("")){
            select_rg.setError("Debe seleccionar una variedad");
        }
        else if (m_grado_arab.equals("")){
            select_ag.setError("Debe seleccionar una variedad");
        }*/


    }
}

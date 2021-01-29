package com.example.proyecto_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Pantalla_ensayo extends AppCompatActivity {

    private Button regresar;
    private Button siguiente;



    private Spinner sp_aroma;
    private Spinner sp_sabor;
    private EditText txt_fechataza;
    private TextView show_puntaje;
    private TextView show_categoria;
    private EditText txt_fechasol;
    private EditText txt_tiempo_c;
    private EditText txt_tiempo_f;
    private TextView show_resultado_final;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_ensayo);


        siguiente= (Button) findViewById(R.id.btn_siguiente);
        regresar= (Button) findViewById(R.id.btn_regresar);
        sp_aroma=(Spinner) findViewById(R.id.aroma);
        sp_sabor=(Spinner) findViewById(R.id.sabor);

        txt_fechataza = (EditText) findViewById(R.id.txt_fechataza);
        show_puntaje = (TextView) findViewById(R.id.show_puntaje);
        show_categoria = (TextView) findViewById(R.id.show_categoria);
        txt_fechasol = (EditText) findViewById(R.id.txt_fechasol);
        txt_tiempo_c = (EditText) findViewById(R.id.txt_tiempo_c);
        txt_tiempo_f = (EditText) findViewById(R.id.txt_tiempo_f);
        show_resultado_final = (TextView) findViewById(R.id.show_resultado_final);





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
            //
            //Toast.makeText(this, ""+generarCalculo(sp_aroma.getSelectedItem().toString(), sp_sabor.getSelectedItem().toString()), Toast.LENGTH_SHORT).show();
            //show_puntaje.setText(String.valueOf(generarCalculo(sp_aroma.getSelectedItem().toString(), sp_sabor.getSelectedItem().toString())));
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("ensayo_analisis_2");



            if (checkEmptyFields(txt_fechataza,txt_fechasol,
                    txt_tiempo_c,txt_tiempo_f )){

                show_puntaje.setText(String.valueOf(generarCalculo(sp_aroma.getSelectedItem().toString(), sp_sabor.getSelectedItem().toString())));
                show_categoria.setText(getResultado(show_puntaje.getText().toString()));
                show_resultado_final.setText(getPrueba(txt_tiempo_c.getText().toString(), txt_tiempo_f.getText().toString()));
                Pantalla_ensayo_class pantalla = new Pantalla_ensayo_class(show_categoria.getText().toString(),txt_fechasol.getText().toString(),txt_fechataza.getText().toString(),show_puntaje.getText().toString(),
                        show_resultado_final.getText().toString(),txt_tiempo_c.getText().toString(),txt_tiempo_f.getText().toString(),sp_aroma.getSelectedItem().toString(),sp_sabor.getSelectedItem().toString());


                databaseReference.setValue(pantalla);
                clearFiels(txt_fechataza,show_puntaje ,show_categoria ,txt_fechasol,
                        txt_tiempo_c,txt_tiempo_f, show_resultado_final);
                Toast.makeText(Pantalla_ensayo.this, "", Toast.LENGTH_SHORT).show();


            }else{
                Toast.makeText(this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
            }

        }
        else if(idm==R.id.op_delete){
            Toast.makeText(Pantalla_ensayo.this, "Eliminar", Toast.LENGTH_SHORT).show();

        }
        return true;
    }

    public boolean checkEmptyFields(EditText txt_fechataza,EditText txt_fechasol,EditText txt_tiempo_c,
             EditText txt_tiempo_f){


        return !txt_fechataza.getText().toString().equals("") &&!txt_fechasol.getText().toString().equals("")&& !txt_tiempo_c.getText().toString().equals("") && !txt_tiempo_f.getText().toString().equals("");

    }

    public int generarCalculo(String aroma, String sabor ){

        try {

            int aroma_ = Integer.parseInt(aroma);
            int sabor_ = Integer.parseInt(sabor);


            return  aroma_ + sabor_ ;


        }catch (Exception e ){
            e.printStackTrace();
            return 1;

        }

    }

    public String getResultado(String resultado_){
        int resultado = Integer.parseInt(resultado_);

        if (resultado >= 12 && resultado <= 15){
            return "Buena";
        }else if (resultado >= 10 && resultado <= 11){
            return  "Muy claro";
        }else if(resultado >= 8 && resultado <= 9){
            return "Claro";
        }else if(resultado >= 6 && resultado <= 7){
            return  "Mediano";
        } else if (resultado <= 5){
            return   "Pobre";
        }

        return "Nada";


    }


    public String getPrueba(String aguaCalient_, String aguaFria_){

        int aguaCaliente = Integer.parseInt(aguaCalient_);
        int aguaFria = Integer.parseInt(aguaFria_);

        if(aguaCaliente<= 30 && aguaFria <= 3){
            return "Aprobado";
        }else{
            return "Desaprobado";
        }



    }

    public void clearFiels(EditText txt_fechataza,TextView showPuntaje, TextView showCategoria,  EditText txt_fechasol,EditText txt_tiempo_c,
                           EditText txt_tiempo_f, TextView show_resultado_final){

        txt_fechataza.setText("");
        showPuntaje.setText("");
        showCategoria.setText("");
        txt_fechasol.setText("");
        txt_tiempo_c.setText("");
        txt_tiempo_f.setText("");
        show_resultado_final.setText("");
    }


}
package com.example.maldonado.intendencia;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.maldonado.intendencia.utilidades.utilidades;


public class Registro extends AppCompatActivity{

    Spinner spiner;
    String [] contenido;
    ArrayAdapter<String> adaptador;
    EditText campoId, campoNombre, campoApellido, campoContrasena;
    RadioButton radio1, radio2;
    String campoTurno="", campoArea="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);




        spiner = (Spinner) findViewById(R.id.spinerAreaX);

        contenido = new String[5];
        contenido[0] = "Area 1";
        contenido[1] = "Area 2";
        contenido[2] = "Area 3";
        contenido[3] = "Area 4";
        contenido[4] = "Area 5";
        contenido[3] = "Area 6";
        contenido[4] = "Area 7";

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contenido);
        spiner.setAdapter(adaptador);


        campoId = (EditText)findViewById(R.id.etId);
        campoNombre = (EditText)findViewById(R.id.etNombre);
        campoApellido = (EditText)findViewById(R.id.etApellido);
        campoContrasena = (EditText)findViewById(R.id.etContrasena);
        radio1 = (RadioButton)findViewById(R.id.Radio1);
        radio2 = (RadioButton)findViewById(R.id.Radio2);



        spiner  = (Spinner)findViewById(R.id.spinerAreaX);


        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                campoArea = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void btnRegistrar(View view){

        if(radio1.isChecked()==true){
            campoTurno="dia";
        }
        if(radio2.isChecked()==true){
            campoTurno="tarde";
        }

        if (campoId.getText().toString().equals("") || campoNombre.getText().toString().equals("") || campoApellido.getText().toString().equals("")
                || campoContrasena.getText().toString().equals("") || campoTurno.equals("")){
            Toast.makeText(getApplicationContext(),"Complete los campos", Toast.LENGTH_SHORT).show();
        }else{
            registrarUsuarios();
        }

    }

    private void registrarUsuarios() {

        conexionSQLiteHelper conn = new conexionSQLiteHelper(this, "bd_intendencia", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();



        ContentValues values = new ContentValues();
        values.put(utilidades.CAMPO_ID, campoId.getText().toString());
        values.put(utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
        values.put(utilidades.CAMPO_APELLIDO, campoApellido.getText().toString());
        values.put(utilidades.CAMPO_CONTRASENA, campoContrasena.getText().toString());
        values.put(utilidades.CAMPO_AREA, campoArea);
        values.put(utilidades.CAMPO_TURNO, campoTurno);


        Long idResultante  = db.insert(utilidades.TABLA_USUARIO, utilidades.CAMPO_ID, values);
        Toast.makeText(getApplicationContext(),"Id registro"+idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}

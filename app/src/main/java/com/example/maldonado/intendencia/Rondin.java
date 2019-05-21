package com.example.maldonado.intendencia;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maldonado.intendencia.utilidades.utilidades;


public class Rondin extends AppCompatActivity {

    private CheckBox cbPizarron, cbPiso, cbBasura, cbBanco, cbEscritorio;
    private EditText campoPizarron, campoPiso, campoBasura, campoBanco, campoEscritorio, campoId, campoSubArea ;
    private TextView campoPrefecto;

    Spinner spiner;
    String campoArea;
    String [] contenido;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rondin);


        spiner = (Spinner) findViewById(R.id.sp1);
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

        spiner = (Spinner) findViewById(R.id.sp1);
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                campoArea = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        cbPizarron=(CheckBox)findViewById(R.id.cbPizarron);
        cbPiso=(CheckBox)findViewById(R.id.cbPiso);
        cbBasura=(CheckBox)findViewById(R.id.cbBasura);
        cbBanco=(CheckBox)findViewById(R.id.cbBanco);
        cbEscritorio=(CheckBox)findViewById(R.id.cbEscritorio);


        campoId = (EditText)findViewById(R.id.etIdRondin);
        //campoArea
        campoSubArea = (EditText)findViewById(R.id.etSubArea);
        campoPrefecto = (TextView)findViewById(R.id.tvPrefectoRondin);
        campoPiso=(EditText)findViewById(R.id.etPiso);
        campoPizarron=(EditText)findViewById(R.id.etPizarron);
        campoEscritorio=(EditText)findViewById(R.id.etEscritorio);
        campoBasura=(EditText)findViewById(R.id.etBasura);
        campoBanco=(EditText)findViewById(R.id.etBanco);


    }

    public void btnRegistrarRondin(View view){
        registrarRondin();
    }

    private void registrarRondin() {
        conexionSQLiteHelper conn = new conexionSQLiteHelper(this, "bd_intendencia", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(utilidades.RONDIN_ID, campoId.getText().toString());
        values.put(utilidades.RONDIN_AREA, campoArea);
        values.put(utilidades.RONDIN_SUBAREA, campoSubArea.getText().toString());
        values.put(utilidades.RONDIN_PREFECTO, campoPrefecto.getText().toString());
        values.put(utilidades.RONDIN_PISO, campoPiso.getText().toString());
        values.put(utilidades.RONDIN_PIZARRON, campoPizarron.getText().toString());
        values.put(utilidades.RONDIN_ESCRITORIO, campoEscritorio.getText().toString());
        values.put(utilidades.RONDIN_BASURA, campoBasura.getText().toString());
        values.put(utilidades.RONDIN_BANCO, campoBanco.getText().toString());


        /*

        values.put(utilidades.RONDIN_ID, "1");
        values.put(utilidades.RONDIN_AREA, "1");
        values.put(utilidades.RONDIN_SUBAREA, "1");
        values.put(utilidades.RONDIN_PREFECTO, "1");
        values.put(utilidades.RONDIN_PISO, "1");
        values.put(utilidades.RONDIN_PIZARRON, "1");
        values.put(utilidades.RONDIN_ESCRITORIO, "1");
        values.put(utilidades.RONDIN_BASURA, "1");
        values.put(utilidades.RONDIN_BANCO, "1");*/



        Long idResultante  = db.insert(utilidades.TABLA_RONDIN, utilidades.RONDIN_ID, values);
        Toast.makeText(getApplicationContext(),"Id registro"+idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }

    public void Pizarron(View view){
        if(cbPizarron.isChecked()==true)
            campoPizarron.setVisibility(View.VISIBLE);
        else
            campoPizarron.setVisibility(View.INVISIBLE);


    }
    public void  Piso(View view){
        if(cbPiso.isChecked()==true)
            campoPiso.setVisibility(View.VISIBLE);
        else
            campoPiso.setVisibility(View.INVISIBLE);
    }

    public void Basura(View view){
        if(cbBasura.isChecked()==true)
            campoBasura.setVisibility(View.VISIBLE);
        else
            campoBasura.setVisibility(View.INVISIBLE);


    }
    public void Banco(View view){
        if(cbBanco.isChecked()==true)
            campoBanco.setVisibility(View.VISIBLE);
        else
            campoBanco.setVisibility(View.INVISIBLE);

    }
    public void Escritorio(View view){
        if(cbEscritorio.isChecked()==true)
            campoEscritorio.setVisibility(View.VISIBLE);
        else
            campoEscritorio.setVisibility(View.INVISIBLE);
    }
}

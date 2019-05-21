package com.example.maldonado.intendencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


public class Rondin extends AppCompatActivity {

    private CheckBox cbPizarron, cbPiso, cbBasura, cbBanco, cbEscritorio;
    private EditText etPizarron, etPiso, etBasura, etBanco, etEscritorio;

    Spinner spiner;
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








        cbPizarron=(CheckBox)findViewById(R.id.cbPizarron);
        etPizarron=(EditText)findViewById(R.id.etPizarron);
        cbPiso=(CheckBox)findViewById(R.id.cbPiso);
        etPiso=(EditText)findViewById(R.id.etPiso);
        cbBasura=(CheckBox)findViewById(R.id.cbBasura);
        etBasura=(EditText)findViewById(R.id.etBasura);
        cbBanco=(CheckBox)findViewById(R.id.cbBanco);
        etBanco=(EditText)findViewById(R.id.etBanco);
        cbEscritorio=(CheckBox)findViewById(R.id.cbEscritorio);
        etEscritorio=(EditText)findViewById(R.id.etEscritorio);

        Button btnRegInicio = (Button)findViewById(R.id.btnEntrar);



        btnRegInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Rondin.this, Inicio.class);
                Rondin.this.startActivity(i);
                finish();
            }
        });
    }
    public void Pizarron(View view){
        if(cbPizarron.isChecked()==true)
            etPizarron.setVisibility(View.VISIBLE);
        else
            etPizarron.setVisibility(View.INVISIBLE);


    }
    public void  Piso(View view){
        if(cbPiso.isChecked()==true)
            etPiso.setVisibility(View.VISIBLE);
        else
            etPiso.setVisibility(View.INVISIBLE);


    }
    public void Basura(View view){
        if(cbBasura.isChecked()==true)
            etBasura.setVisibility(View.VISIBLE);
        else
            etBasura.setVisibility(View.INVISIBLE);


    }
    public void Banco(View view){
        if(cbBanco.isChecked()==true)
            etBanco.setVisibility(View.VISIBLE);
        else
            etBanco.setVisibility(View.INVISIBLE);

    }
    public void Escritorio(View view){
        if(cbEscritorio.isChecked()==true)
            etEscritorio.setVisibility(View.VISIBLE);
        else
            etEscritorio.setVisibility(View.INVISIBLE);
    }
}

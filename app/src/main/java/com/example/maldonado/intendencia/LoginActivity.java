package com.example.maldonado.intendencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    //variables del login
    EditText Usuario, Contraseña;
    Button btnEntrar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        conexionSQLiteHelper conn = new conexionSQLiteHelper(this, "bd_intendencia", null, 1);

        //titulo del actividad login
        this.setTitle(R.string.Login_titulo);

        //instanciar variables
        Usuario = (EditText) findViewById(R.id.etUsuario);
        Contraseña = (EditText) findViewById(R.id.etContraseña);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Usuario.getText().toString().equals("") || Contraseña.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Complete los campos", Toast.LENGTH_SHORT).show();
                }else if(Usuario.getText().toString().equals("user") || Contraseña.getText().toString().equals("user")){

                    Toast.makeText(getApplicationContext(),"Bienvenido!!!", Toast.LENGTH_SHORT).show();
                    Intent intencion = new Intent(LoginActivity.this, Inicio.class);
                    startActivity(intencion);
                    finish();
                }else{

                }
            }
        });

    }
}

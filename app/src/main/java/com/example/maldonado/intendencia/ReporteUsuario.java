package com.example.maldonado.intendencia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maldonado.intendencia.utilidades.utilidades;

public class ReporteUsuario extends AppCompatActivity {

    EditText campoId, campoNombre, campoApellido, campoArea, campoTurno;
    conexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_usuario);

        campoId = (EditText)findViewById(R.id.etIdRU);
        campoNombre = (EditText)findViewById(R.id.etNombreRU);
        campoApellido  = (EditText)findViewById(R.id.etApellidoRU);
        campoArea = (EditText)findViewById(R.id.etAreaRU);
        campoTurno  = (EditText)findViewById(R.id.etTurnoRU);
        conn= new conexionSQLiteHelper(getApplicationContext(), "bd_intendencia", null, 1);

    }

    public void btnActualizar(View view) {
        actualizar();
        limpiar();
    }

    private void limpiar() {
        campoId.setText("");
        campoNombre.setText("");
        campoApellido.setText("");
        campoArea.setText("");
        campoTurno.setText("");
    }

    public void btnBuscar(View view){
        if(campoId.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Inserte un Id", Toast.LENGTH_SHORT).show();
        }else{
                buscar();
        }
    }


    public void btnEliminar(View view) {
        SQLiteDatabase db = conn.getWritableDatabase();
        String [] parametros = {campoId.getText().toString()};

        db.delete(utilidades.TABLA_USUARIO, utilidades.CAMPO_ID+"=?", parametros);
        db.close();
        Toast.makeText(getApplicationContext(),"Registro Eliminado **", Toast.LENGTH_SHORT).show();
        limpiar();
    }

    private void actualizar() {

            SQLiteDatabase db = conn.getWritableDatabase();
            String [] parametros = {campoId.getText().toString()};
            ContentValues values = new ContentValues();

            values.put(utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
            values.put(utilidades.CAMPO_APELLIDO, campoApellido.getText().toString());
            values.put(utilidades.CAMPO_AREA, campoArea.getText().toString());
            values.put(utilidades.CAMPO_TURNO, campoTurno.getText().toString());

            db.update(utilidades.TABLA_USUARIO, values, utilidades.CAMPO_ID+"=?", parametros);
            db.close();
            Toast.makeText(getApplicationContext(),"Registro Actualizado!!", Toast.LENGTH_SHORT).show();

    }

    private void buscar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String [] parametros = {campoId.getText().toString()};
        String [] campos = {utilidades.CAMPO_NOMBRE,utilidades.CAMPO_APELLIDO, utilidades.CAMPO_AREA, utilidades.CAMPO_TURNO};
        try{

            Cursor cursor = db.query(utilidades.TABLA_USUARIO, campos, utilidades.CAMPO_ID+"=?", parametros, null, null, null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoApellido.setText(cursor.getString(1));
            campoArea.setText(cursor.getString(2));
            campoTurno.setText(cursor.getString(3));
            cursor.close();
            Toast.makeText(getApplicationContext(),"Consulta Exitosa!!", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Fallo la consulta", Toast.LENGTH_SHORT).show();
        }


    }
}

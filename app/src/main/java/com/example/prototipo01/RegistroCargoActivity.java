package com.example.prototipo01;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prototipo01.utilidades.Utilidades;

import java.util.Calendar;


public class RegistroCargoActivity extends AppCompatActivity {

    EditText campoNombreCargo,campoDetalleCargo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cargo);

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        campoNombreCargo= (EditText) findViewById(R.id.campoNombreCargo);
        campoDetalleCargo= (EditText) findViewById(R.id.campoDetalleCargo);

    }


    public void onClick(View view) {
        registrarUsuarios();
        //registrarUsuariosSql();
    }


    private void registrarUsuarios() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE_CARGO,campoNombreCargo.getText().toString());
        values.put(Utilidades.CAMPO_DETALLE_CARGO,campoDetalleCargo.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_CARGO,Utilidades.CAMPO_NOMBRE_CARGO,values);

        Toast.makeText(getApplicationContext(),"Registrado correctamente: "+idResultante, Toast.LENGTH_SHORT).show();

        db.close();
    }
}

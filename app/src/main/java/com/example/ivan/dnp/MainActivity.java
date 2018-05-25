package com.example.ivan.dnp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button) findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ServiceActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    public void alta(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,

                "prueba", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();



        ContentValues registro = new ContentValues();

        registro.put("UserCode", 123);
        registro.put("UserName", "Borrego");
        registro.put("UserImage", "unable");
        registro.put("UserCategoria", "propietario");

        //registro.put("numero", numero);

        // los inserto en la base de datos
        bd.insert("user", null, registro);

        bd.close();

        // ponemos los campos a vacío para insertar el siguiente usuario
        Log.d("prueba", "BD insertada ");
       // et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");

        Toast.makeText(this, "Datos del usuario cargados", Toast.LENGTH_SHORT).show();

    }

}

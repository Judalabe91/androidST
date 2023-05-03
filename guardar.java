package com.example.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class guardar extends AppCompatActivity {

    private Button button;
    private EditText edittext1;
    private EditText edittext2;
    private EditText edittext3;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar);
        button = findViewById(R.id.btn_save);
        edittext1 = findViewById(R.id.editTextname);
        edittext2 = findViewById(R.id.editTextfecha);
        edittext3 = findViewById(R.id.editTexttel);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ConfigBaseSQLite admin = new ConfigBaseSQLite(guardar.this,
                        "BD_Citas", null, 2);
                SQLiteDatabase bd = admin.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("nombre", edittext1.getText().toString());
                registro.put("fecha", edittext2.getText().toString());
                registro.put("telefono", edittext3.getText().toString());

                bd.insert("usuario", null, registro);

                bd.close();
                edittext1.setText("");
                edittext2.setText("");
                edittext3.setText("");
                Toast.makeText(getApplicationContext(), "Datos almacenados correctamente",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }


}
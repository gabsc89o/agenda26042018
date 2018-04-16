package com.example.usuari.agenda;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ActivityAdd extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void agregar(View v){
        EditText nombre=(EditText)this.findViewById(R.id.edtNombre);
        EditText mail=(EditText)this.findViewById(R.id.edtMail);
        EditText edtEdad=(EditText) this.findViewById(R.id.edtEdad);
        int edad=Integer.parseInt(edtEdad.getText().toString());
        DBContactos adp=new DBContactos(this);
        adp.altaContacto(nombre.getText().toString(),mail.getText().toString(),edad);
        adp.close();
        Toast.makeText(this,"Se ha guardado correctamente ", Toast.LENGTH_LONG).show();
        this.finish();
    }
}

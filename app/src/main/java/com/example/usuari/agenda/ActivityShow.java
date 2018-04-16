package com.example.usuari.agenda;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityShow extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        DBContactos adp=new DBContactos(this);
        Cursor c = adp.recuperarContacto();
        String[] columnas = new String[]{"nombre","mail","edad"};
        final int[] vistas = new int[]{R.id.tvNombre,R.id.tvMail,R.id.tvEdad};
        SimpleCursorAdapter sc = new SimpleCursorAdapter(
                this,
                R.layout.list_controls,
                c,
                columnas,
                vistas,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        ListView listas=(ListView) findViewById(R.id.lvAll);
        listas.setAdapter(sc);
        listas.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void
                    onItemClick(AdapterView<?> parent,
                                View view, int position, long id) {
                        Toast.makeText(ActivityShow.this, vistas.toString() , Toast.LENGTH_LONG).show();
                    }
                });
        adp.close();
    }
    public void cerrar(View v){
        this.finish();
    }

}

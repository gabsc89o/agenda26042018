package com.example.usuari.agenda;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityFind extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
    }
    public void find(View v){
        ListView tfind= (ListView) this.findViewById(R.id.tvFind);
        String bnombre = ((EditText)this.findViewById(R.id.edtBuscar)).getText().toString();
        DBContactos db=new DBContactos(this);
        //contactos contact=db.recuperarPorNombre(bnombre);
        /*String s="";
        s = db.recuperarByNombre(bnombre);
        if(s.equals("")) {
            s += "Nombre: " + contact.getName() + " Mail: " +
                    contact.getMail() + " Edad: " + contact.getAge();
            s="Contacto no encontrado";
        }else{
            s="Contacto no encontrado";
        }*/
        //tfind.setText(s);
        Cursor c = db.recuperarByNombre2(bnombre);
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
        ListView lista2=(ListView) findViewById(R.id.tvFind);
        lista2.setAdapter(sc);
        lista2.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void
                    onItemClick(AdapterView<?> parent,
                                View view, int position, long id) {
                        Toast.makeText(ActivityFind.this, vistas.toString() , Toast.LENGTH_LONG).show();
                    }
                });
        db.close();
    }
    public void cerrar(View v){

        this.finish();
    }
}

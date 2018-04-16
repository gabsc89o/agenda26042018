package com.example.usuari.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by usuari on 20/03/2018.
 */

public class DBContactos {
    private SQLiteDatabase db=null;
    private DatabaseHelper dbhelper=null;
    Context context;
    public DBContactos(Context ctx){
        this.context = ctx;
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getWritableDatabase();
    }
    public void close(){
        dbhelper.close();
    }
    public  long altaContacto(String nombre, String mail, int edad){
        ContentValues initialValues = new ContentValues();
        initialValues.put("nombre",nombre);
        initialValues.put("mail",mail);
        initialValues.put("edad",edad);
        return db.insert("contactos",null,initialValues);
    }
    public Cursor recuperarContacto(){
        return db.query("contactos", new String[]{"_id","nombre","mail","edad"},null,null,null,null,null);
    }
    public boolean borrarLibro(int id){
        return db.delete("contactos", "_id="+id, null)>0;
    }
    public contactos recuperarPorNombre(String name){
        contactos contact=null;
        Cursor c=db.query("contactos", new String[]{"_id",
                "mail","edad","nombre"},"nombre like ?", new String[]{"%"+name+"%"},
                null,null,null);
        if(c.moveToNext()){
            contact=new contactos(c.getString(3),c.getInt(2),c.getString(1));
        }
        return contact;
    }
    public String recuperarByNombre(String name){
        String text="";
        Cursor c = db.rawQuery("SELECT _id, mail,edad,nombre FROM contactos WHERE nombre like '%"+name+"%'", null);
        if (c.moveToFirst()) {
            do {
                int id=c.getInt(0);
                String mail = c.getString(1);
                int ag=c.getInt(2);
                String nom = c.getString(3);
                text+=" " + id + " - " + nom + " - " + mail + " - " + ag+ "\n";
            } while(c.moveToNext());
        }
        return text;
    }
    public Cursor recuperarByNombre2(String name){
        String text="";
        Cursor c = db.rawQuery("SELECT _id, mail,edad,nombre FROM contactos WHERE nombre like '%"+name+"%'", null);
        return c;
    }
}

package com.example.usuari.agenda;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class AccesoFichero {
    private Context contexto;
    private String nombre;
    public AccesoFichero(Context contexto, String nombre){
        this.contexto=contexto;
        this.nombre=nombre;
    }
    public void guardar(String persona ){
        FileOutputStream fos= null;
        PrintStream out=null;
        try {
            fos = contexto.openFileOutput(nombre,
                    Context.MODE_APPEND);
            System.out.println("DIRECCION: "+ contexto.getFilesDir());
            out=new PrintStream(fos);
            out.println(persona);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(out!=null){
                out.close();
            }
        }
    }
    public ArrayList<String> recuperar(){
        ArrayList<String> notas=new ArrayList<>();
        FileInputStream fis=null;
        BufferedReader bf=null;
        try{
            fis=contexto.openFileInput(nombre);
            bf=new BufferedReader(new InputStreamReader(fis));
            String nota;
            while((nota=bf.readLine())!=null){
                notas.add(nota);
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return notas;
    }
    public void limpiarFichero(){
        FileOutputStream fos= null;
        try {
            fos = contexto.openFileOutput(nombre,
                    Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

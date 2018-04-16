package com.example.usuari.agenda;

/**
 * Created by usuari on 13/03/2018.
 */

public class contactos {
    private String name;
    private int age;
    private String mail;

    public contactos() {
    }

    public contactos(String name, int age, String mail) {
        this.name = name;
        this.age = age;
        this.mail = mail;
    }

    /*public contactos(int anInt, String name, int age, String mail) {
        this.name = name;
        this.age = age;
        this.mail = mail;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

   /* @Override
    public String toString() {
        return "contactos{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                '}';
    }*/
    @Override
    public String toString() {
        return "name= " + name + " " +
                "age= " + age + " " +
                "mail= " + mail ;
    }
}

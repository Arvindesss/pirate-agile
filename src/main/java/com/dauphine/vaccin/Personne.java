package com.dauphine.vaccin;

import java.util.ArrayList;
import java.util.List;

public class Personne {

    private String nom;
    private String prénom;
    private int age;
    private List<Vaccin> vaccins;

    public Personne(List<Vaccin> vaccins, int age, String prénom, String nom) {
        this.vaccins = vaccins;
        this.age = age;
        this.prénom = prénom;
        this.nom = nom;
    }

    public Personne(String nom, String prénom, int age) {
        this.nom = nom;
        this.prénom = prénom;
        this.age = age;
        this.vaccins = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Vaccin> getVaccins() {
        return vaccins;
    }

    public void setVaccins(List<Vaccin> vaccins) {
        this.vaccins = vaccins;
    }
}

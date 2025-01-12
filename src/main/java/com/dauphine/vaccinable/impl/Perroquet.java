package com.dauphine.vaccinable.impl;

import com.dauphine.vaccin.exceptions.VaccinExpireException;
import com.dauphine.vaccin.exceptions.VaccinNonAdapteException;
import com.dauphine.vaccin.IVaccin;
import com.dauphine.vaccin.impl.VaccinPacheco;
import com.dauphine.vaccinable.Vaccinable;

import java.util.ArrayList;
import java.util.List;

public class Perroquet implements Vaccinable {

    private String nom;

    private String couleur;

    private int age;

    private Pirate maitre;

    private List<IVaccin> vaccinsRecus;

    public Perroquet(String nom, String couleur, int age) {
        this.nom = nom;
        this.couleur = couleur;
        this.age = age;
        this.maitre = null;
        this.vaccinsRecus = new ArrayList<>();
    }

    /* Le perroquet peut parler.
   @param phrase La phrase que le perroquet répète*/
    public String parler(String phrase) {
        return phrase;
    }

    /* Affiche les informations du perroquet */
    @Override
    public String toString() {
        return "Perroquet [Nom: " + nom + ", Couleur: " + couleur + ", Âge: " + age + " ans]";
    }

    @Override
    public void recevoirVaccin(IVaccin vaccin) {
        if(vaccin.estExpire()) {
            throw new VaccinExpireException("Le vaccin est expiré");
        }
        if(!vaccin.estAdapteA(this)) {
            throw new VaccinNonAdapteException("Le vaccin est n'est pas adapté à un perroquet");
        }
        vaccinsRecus.add((VaccinPacheco) vaccin);
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pirate getMaitre() {
        return maitre;
    }

    public void setMaitre(Pirate maitre) {
        this.maitre = maitre;
    }

    public List<IVaccin> getVaccinsRecus() {
        return vaccinsRecus;
    }
}
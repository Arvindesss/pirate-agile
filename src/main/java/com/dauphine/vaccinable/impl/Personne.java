package com.dauphine.vaccinable.impl;

import com.dauphine.vaccin.IVaccinFactory;
import com.dauphine.vaccin.exceptions.VaccinExpireException;
import com.dauphine.vaccin.exceptions.VaccinNonAdapteException;
import com.dauphine.vaccin.IVaccin;
import com.dauphine.vaccinable.Vaccinable;

import java.util.ArrayList;
import java.util.List;

public class Personne implements Vaccinable {

    private String nom;

    private String prenom;

    private int age;

    private List<IVaccin> vaccinsDisponibles;

    private List<IVaccin> vaccinsRecus;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.vaccinsDisponibles = new ArrayList<>();
        this.vaccinsRecus = new ArrayList<>();
    }

    public void trouverVaccin(String type, String nom, String creatorP, int quantite) {
        List<IVaccin> vaccinsCree = IVaccinFactory.creerVaccins(type, nom, creatorP, quantite);
        vaccinsDisponibles.addAll(vaccinsCree);
    }

    @Override
    public void recevoirVaccin(IVaccin vaccin) {
        if(vaccin.estExpire()) {
            throw new VaccinExpireException("Le vaccin est expiré");
        }
        if(!vaccin.estAdapteA(this)) {
            throw new VaccinNonAdapteException("Le vaccin est n'est pas adapté à un humain");
        }
        vaccinsRecus.add(vaccin);
    }

    public void administrerVaccinTrouve(int numPosition) {
        IVaccin vaccin = this.vaccinsDisponibles.get(numPosition);
        recevoirVaccin(vaccin);
        this.getVaccinsDisponibles().remove(numPosition);
    }

    /**
     * Fait vieillir une personne.
     * @param nbAnnee le nombre d'années à rajouter dans l'age de la personne
     */
    public void vieillir(int nbAnnee) {
        this.age += nbAnnee;
    }

    public boolean isVaccinated(IVaccin vaccin) {
        return this.getVaccinsRecus().stream()
                .anyMatch(v -> v.getNom().equals(vaccin.getNom()));
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<IVaccin> getVaccinsDisponibles() {
        return vaccinsDisponibles;
    }

    public List<IVaccin> getVaccinsRecus() {
        return vaccinsRecus;
    }
}

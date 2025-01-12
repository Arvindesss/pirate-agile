package com.dauphine.vaccin.impl;

import com.dauphine.vaccin.IVaccin;
import com.dauphine.vaccinable.Vaccinable;

import java.time.LocalDate;

public abstract class Vaccin implements IVaccin {

    private String nom;

    private String createur;

    private LocalDate dateCreation;

    public Vaccin(String nom, String createur) {
        this.nom = nom;
        this.createur = createur;
        this.dateCreation = LocalDate.now();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCreateur() {
        return createur;
    }

    public void setCreateur(String createur) {
        this.createur = createur;
    }

    public boolean estExpire(){
        return LocalDate.now().isAfter(this.dateCreation.plusDays(getJoursMaxStockage()));
    }

    public abstract int getJoursMaxStockage();

    public abstract boolean estAdapteA(Vaccinable vaccinable);
}
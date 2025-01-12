package com.dauphine.vaccinable.impl;

import com.dauphine.vaccin.IVaccin;

public class Pirate extends Personne {

    private String grade;

    private Perroquet perroquet;

    /**
     * Constructeur d'objets de classe Pirate
     */
    public Pirate(String nom, String prenom, int age, String grade) {
        super(nom, prenom, age);
        this.grade = grade;
        this.perroquet = null;
    }

    /**
     * Affiche les informations du pirate.
     */
    @Override
    public String toString() {
        return "Pirate [Âge: " + super.getAge() + ", Grade: " + grade + "]";
    }

    /**
     * Fait dire quelque chose au perroquet du pirate.
     *
     * @param phrase la phrase que le perroquet doit dire
     */
    public String faireParlerPerroquet(String phrase)  {
        if (perroquet != null) {
           return perroquet.parler(phrase);
        } else {
           throw new RuntimeException("Le pirate n'a pas de perroquet pour parler.");
        }
    }

    public void vaccinerPeroquet(int numVaccin) {
        try {
            IVaccin vaccin = super.getVaccinsDisponibles().get(numVaccin);
            perroquet.recevoirVaccin(vaccin);
            super.getVaccinsDisponibles().remove(numVaccin);}
        catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Le vaccin recherché n'existe pas");
        }
    }

    // Getters et Setters

    public void setPerroquet(Perroquet nouveauPerroquet) {
        this.perroquet = nouveauPerroquet;
    }

    public Perroquet getPerroquet() {
        return perroquet;
    }

    /**
     * Retourne le grade du pirate.
     * 
     * @return le grade actuel du pirate
     */
    public String getGrade()
    {
        return grade;
    }

    /**
     * Modifie le grade du pirate.
     * 
     * @param nouveauGrade le nouveau grade du pirate
     */
    public void setGrade(String nouveauGrade) {
        grade = nouveauGrade;
    }
}
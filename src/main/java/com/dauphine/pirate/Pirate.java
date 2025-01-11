package com.dauphine.pirate;

import com.dauphine.pirate.Perroquet;

public class Pirate {
    private int age;
    private String grade;
    private String nom;
    private Perroquet perroquet;

    /**
     * Constructeur d'objets de classe Pirate
     */
    
    public Pirate() {
        age = 0;
        grade = "Moussaillon";
        perroquet = null; // Aucun perroquet au départ
    }

    public Pirate(int age, String grade, String nom) {
        this.age = age;
        this.grade = grade;
        this.nom = nom;
        this.perroquet = null;
    }

    /**
     * Fait vieillir le pirate.
     * @param nbAnnee le nombre d'années à rajouter dans l'age du pirate
     */
    public void vieillir(int nbAnnee) {
        this.age += nbAnnee;
    }

    /**
     * Affiche les informations du pirate.
     */
    public String toString() {
        return "com.dauphine.pirate.Pirate [Âge: " + age + ", Grade: " + grade + ", com.dauphine.pirate.Perroquet: " + perroquet + "]";
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

    // Getters et Setters

    public void setPerroquet(Perroquet nouveauPerroquet) {
        this.perroquet = nouveauPerroquet;
    }

    public Perroquet getPerroquet() {
        return perroquet;
    }

    /**
     * Retourne l'âge du pirate.
     * 
     * @return l'âge actuel du pirate
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Modifie l'âge du pirate.
     * 
     * @param nouvelAge le nouvel âge du pirate
     */
    public void setAge(int nouvelAge) {
        age = nouvelAge;
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
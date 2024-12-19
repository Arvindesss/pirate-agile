package com.dauphine;

public class Perroquet {

    private String nom;

    private String couleur;

    private int age;

    private Pirate maitre;

    public Perroquet() {
        this.nom = "Inconnu";
        this.couleur = "Vert";
        this.age = 0;
        this.maitre = null;
    }

    public Perroquet(String nom, String couleur, int age) {
        this.nom = nom;
        this.couleur = couleur;
        this.age = age;
        this.maitre = null;
    }

    /* Le perroquet peut parler.
   @param phrase La phrase que le perroquet répète*/
    public String parler(String phrase) {
        return nom + " dit : " + phrase;
    }

    /* Affiche les informations du perroquet */
    public String toString() {
        return "Perroquet [Nom: " + nom + ", Couleur: " + couleur + ", Âge: " + age + " ans" + maitre + " maitre";}

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
        if (age >= 0) {
            this.age = age;
        } else {
            throw new RuntimeException("L'âge ne peut pas être négatif.");
        }
    }

    public Pirate getMaitre() {
        return maitre;
    }

    public void setMaitre(Pirate maitre) {
        this.maitre = maitre;
    }
}
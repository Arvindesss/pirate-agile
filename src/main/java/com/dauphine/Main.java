package com.dauphine;

import com.dauphine.vaccin.Personne;
import com.dauphine.vaccin.Vaccin;

public class Main {

    public static void main(String[] args) {

        Vaccin vaccin1 = new Vaccin("anti-covid", "Pfizer");
        System.out.println("My vaccin name is : " + vaccin1.getName());
        vaccin1.setName("anti-Tétanos");
        System.out.println("My vaccin name is : " + vaccin1.getName());

        Personne halim = new Personne("halim","zerara",22);
        System.out.println("Halim vaccin : " + halim.getVaccins());
        System.out.println("Halim est-il vacciné ?  " + vaccin1.isVaccined(halim));
        vaccin1.Vaccined(halim);
        System.out.println("Vaccination en cours");

        System.out.println("Halim vaccin : " + halim.getVaccins());
        System.out.println("Halim est-il vacciné ? : " + vaccin1.isVaccined(halim));

    }
}

package com.dauphine.vaccin;

import com.dauphine.vaccin.impl.VaccinCovid19;
import com.dauphine.vaccin.impl.VaccinPacheco;

import java.util.ArrayList;
import java.util.List;

public class IVaccinFactory {

    public static IVaccin creerVaccin(String type, String nom, String createur){
        if(type.equalsIgnoreCase("covid19")){
            return new VaccinCovid19(nom, createur);
        } else if (type.equalsIgnoreCase("pacheco")) {
            return new VaccinPacheco(nom, createur);
        }
        throw new IllegalArgumentException("Type de vaccin inconnu : " + type);
    }

   public static List<IVaccin> creerVaccins(String type, String nom, String createur, int quantite){
        List<IVaccin> vaccins = new ArrayList<>();
        for (int i = 0; i < quantite; i++) {
            vaccins.add(creerVaccin(type, nom, createur));
        }
        return vaccins;
    }
}

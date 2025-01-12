package com.dauphine.vaccin.impl;

import com.dauphine.vaccin.impl.Vaccin;
import com.dauphine.vaccinable.impl.Personne;
import com.dauphine.vaccinable.Vaccinable;

public class VaccinCovid19 extends Vaccin {

    private final static int JOURS_MAX_STOCKAGE = 21;

    public VaccinCovid19(String nom, String createur) {
        super(nom, createur);
    }

    @Override
    public int getJoursMaxStockage() {
        return JOURS_MAX_STOCKAGE;
    }

    @Override
    public boolean estAdapteA(Vaccinable vaccinable) {
        return vaccinable.getClass().equals(Personne.class) || vaccinable instanceof Personne;
    }
}



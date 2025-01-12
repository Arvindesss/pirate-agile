package com.dauphine.vaccin.impl;

import com.dauphine.vaccin.impl.Vaccin;
import com.dauphine.vaccinable.impl.Perroquet;
import com.dauphine.vaccinable.Vaccinable;

public class VaccinPacheco extends Vaccin {

    private final static int JOURS_MAX_STOCKAGE = 30;

    public VaccinPacheco(String nom, String createur) {
        super(nom, createur);
    }

    @Override
    public int getJoursMaxStockage() {
        return JOURS_MAX_STOCKAGE;
    }

    @Override
    public boolean estAdapteA(Vaccinable vaccinable) {
        return vaccinable.getClass().equals(Perroquet.class);
    }
}

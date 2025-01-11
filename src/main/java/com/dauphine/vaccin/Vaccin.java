package com.dauphine.vaccin;

import java.util.List;

public class Vaccin {

    private String name;
    private String creator;

    public Vaccin() {

    }

    public Vaccin(String nameP, String creatorP) {
        this.name = nameP;
        this.creator = creatorP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean isVaccined(Personne personne) {
        List<Vaccin> vaccins = personne.getVaccins();
        for (Vaccin vaccin : vaccins) {
            if( vaccin.name.equals(this.name) && vaccin.creator.equals(this.creator)) {
                return true;
            }
        }
        return false;
    }

    public void Vaccined(Personne personne) {
        List<Vaccin> vaccins = personne.getVaccins();
        vaccins.add(this);
    }


}
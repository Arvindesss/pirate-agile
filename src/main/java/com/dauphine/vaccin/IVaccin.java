package com.dauphine.vaccin;

import com.dauphine.vaccinable.Vaccinable;

public interface IVaccin {

    String getNom();

    boolean estExpire();

    boolean estAdapteA(Vaccinable vaccinable);
}

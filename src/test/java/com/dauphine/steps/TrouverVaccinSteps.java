package com.dauphine.steps;

import com.dauphine.vaccin.IVaccin;
import com.dauphine.vaccinable.impl.Personne;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.MockedStatic;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;

public class TrouverVaccinSteps {

    private Personne personne;

    private Exception exception;

    @Given("une personne nommée {string} {string} âgée de {int} ans")
    public void unePersonneNomméeÂgéeDeAns(String nom, String prenom, int age) {
        this.personne = new Personne(nom, prenom, age);
    }

    @And("qui n'a aucun vaccin disponible")
    public void quiNAAucunVaccinDisponible() {
        assertTrue(this.personne.getVaccinsDisponibles().isEmpty(), this.personne.getNom() + " " +
                this.personne.getPrenom() + "  a un vaccin !");
    }

    @When("il recherche un vaccin de type {string} appelé {string}, créé par {string} en {int} exemplaires le {string}")
    public void ilRechercheUnVaccinDunTypeEtCrééParEnExemplairesLe(String type, String nom, String createur,
                                                                    int quantite, String dateString) {
        LocalDate creationDate = LocalDate.parse(dateString);
        try (MockedStatic<LocalDate> mockedLocalDate = mockStatic(LocalDate.class)) {
            mockedLocalDate.when(LocalDate::now).thenReturn(creationDate);
            personne.trouverVaccin(type,nom,createur,quantite);
        } catch (Exception e) {
            exception = e;
        }
    }


    @Then("il devrait avoir {int} vaccins disponibles appelés {string}")
    public void ilDevraitAvoirVaccinsDisponiblesAppelés(int nbVaccinsDispoAttendus, String nomVaccin) {
        int vaccinCount = 0;
        for (IVaccin v: personne.getVaccinsDisponibles()) {
            if(v.getNom().equals(nomVaccin)) {
                vaccinCount++;
            }
        }
        assertEquals(nbVaccinsDispoAttendus, vaccinCount);
    }

    @Then("Une erreur devrait être levée concernant le vaccin qui n'a pas été trouvé: {string}")
    public void uneErreurDevraitÊtreLevéeConcernantLeVaccinQuiNaPasEteTrouve(String message) {
        Assertions.assertNotNull(exception);
        Assertions.assertEquals(message, exception.getMessage());
    }
}

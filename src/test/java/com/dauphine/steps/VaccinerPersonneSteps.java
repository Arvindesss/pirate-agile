package com.dauphine.steps;

import com.dauphine.vaccin.IVaccinFactory;
import com.dauphine.vaccin.IVaccin;
import com.dauphine.vaccinable.impl.Personne;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.MockedStatic;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.mockStatic;

public class VaccinerPersonneSteps {

    private Personne personne;

    private IVaccin vaccin;

    private Exception exception;

    @Given("une personne nommée {string} {string} agé de {int} ans")
    public void une_personne_nommee_age_de_ans(String prenom, String nom, Integer age) {
        personne = new Personne(nom, prenom, age);
    }
    @When("il trouve le vaccin de type {string} appelé {string} créé par {string} en {int} exemplaires le {string}")
    public void ilRechercheUnVaccin(String type, String nom, String creator, int quantite, String dateString) {
        LocalDate creationDate = LocalDate.parse(dateString);
        try (MockedStatic<LocalDate> mockedLocalDate = mockStatic(LocalDate.class)) {
            mockedLocalDate.when(LocalDate::now).thenReturn(creationDate);
            personne.trouverVaccin(type, nom, creator, quantite);
        }
    }

    @Given("la personne n'a jamais été vaccinée")
    public void elleNAPasDeVaccinRecus() {
        Assertions.assertEquals(0, personne.getVaccinsRecus().size());
    }

    @When("elle se vaccine avec le vaccin présent à la position numéro {int} le {string}")
    public void elleSeVaccineAvecLeVaccinPrésentALaPositionNumeroLe(int numPosition, String dateString) {
        LocalDate creationDate = LocalDate.parse(dateString);
        try (MockedStatic<LocalDate> mockedLocalDate = mockStatic(LocalDate.class)) {
            mockedLocalDate.when(LocalDate::now).thenReturn(creationDate);
            personne.administrerVaccinTrouve(numPosition - 1);
        } catch (Exception e) {
            exception = e;
        }
    }



    @Then("une erreur devrait être levée concernant la non compatibilité du vaccin disant {string}")
    public void erreurLevée(String message) {
        Assertions.assertNotNull(exception);
        Assertions.assertEquals(message, exception.getMessage());
    }

    @Then("la personne à été vacciné {int} fois")
    public void laPersonneÀÉtéVaccinéFois(int nbVaccinations) {
        Assertions.assertEquals(nbVaccinations, personne.getVaccinsRecus().size());
    }

    @Then("Une erreur devrait être levée concernant l'expiration du vaccin : {string}")
    public void uneErreurDevraitÊtreLevéeConcernantLExpirationDuVaccin(String message) {
        Assertions.assertNotNull(exception);
        Assertions.assertEquals(message, exception.getMessage());
    }
}

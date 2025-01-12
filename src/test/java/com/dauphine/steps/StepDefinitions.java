package com.dauphine.steps;

import com.dauphine.vaccinable.impl.Personne;
import com.dauphine.vaccin.impl.Vaccin;
import com.dauphine.vaccin.impl.VaccinCovid19;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StepDefinitions {

    private Vaccin vaccin;

    private Personne personne;

    @Given("un vaccin de type covid-19 nommé {string} créé par {string}")
    public void un_vaccin_covid_nomme_cree_par(String nomVaccin, String createurVaccin) {
        vaccin = new VaccinCovid19(nomVaccin, createurVaccin);
    }

    @Given("une personne nommée {string} {string} agée de {int} ans")
    public void une_personne_nommee_agee_de_ans(String prenom, String nom, Integer age) {
        personne = new Personne(nom, prenom, age);
    }

    @When("on vérifie si la personne est vaccinée avec ce vaccin")
    public void on_verifie_si_la_personne_est_vaccinee_avec_ce_vaccin() {
        // Nothing to do here; the assertion is in the @Then step
    }

    @Then("le résultat devrait être {string}")
    public void le_resultat_devrait_etre(String resultatAttendu) {
        boolean resultatEffectif = personne.getVaccinsRecus().contains(vaccin);
        assertEquals(Boolean.parseBoolean(resultatAttendu), resultatEffectif);
    }

    @When("on vaccine la personne avec ce vaccin")
    public void on_vaccine_la_personne_avec_ce_vaccin() {
        personne.recevoirVaccin(vaccin);
    }

    @When("on modifie le nom du vaccin pour {string}")
    public void on_modifie_le_nom_du_vaccin_pour(String nouveauNom) {
        vaccin.setNom(nouveauNom);  // Handles both string and null values
    }


    @When("on modifie le nom du vaccin pour null")
    public void on_modifie_le_nom_du_vaccin_pour_null() {
        vaccin.setNom(null);
    }

    @Then("le nom du vaccin devrait être {string}")
    public void le_nom_du_vaccin_devrait_etre(String nomAttendu) {
        assertEquals(nomAttendu, vaccin.getNom()); // Handles both string and null
    }

    @Then("le nom du vaccin devrait être null")
    public void le_nom_du_vaccin_devrait_etre_null() {
        assertNull(vaccin.getNom());
    }

    @When("on modifie le créateur du vaccin pour {string}")
    public void on_modifie_le_createur_du_vaccin_pour(String nouveauCreateur) {
        vaccin.setCreateur(nouveauCreateur);
    }

    @Then("le créateur du vaccin devrait être {string}")
    public void le_createur_du_vaccin_devrait_etre(String createurAttendu) {
        assertEquals(createurAttendu, vaccin.getCreateur());
    }
}
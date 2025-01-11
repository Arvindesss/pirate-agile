package com.dauphine.steps;

import com.dauphine.pirate.Pirate;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VieillirPirateSteps {
    private Pirate pirate;

    @Given("un pirate âgé de {int} ans")
    public void un_pirate_age_de_ans(int ageInitial) {
        pirate = new Pirate();
        pirate.setAge(ageInitial);
    }

    @When("Le pirate vieillit de {int} années")
    public void le_pirate_vieillit_de_annees(int nbAnnees) {
        pirate.vieillir(nbAnnees);
    }

    @Then("l'âge du pirate doit maintenant être {int}")
    public void l_age_du_pirate_doit_maintenant_etre(int ageFinal) {
        assertEquals(ageFinal, pirate.getAge(), "L'âge du pirate devrait être " + ageFinal);
    }
}
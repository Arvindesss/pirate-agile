package com.dauphine.steps;

import com.dauphine.vaccinable.impl.Perroquet;
import com.dauphine.vaccinable.impl.Pirate;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FaireParlerPerroquetSteps {

    private Pirate pirate;

    private Perroquet perroquet;

    private String dernierMessage;

    @Given("un pirate possédant un perroquet nommé {string}, de couleur {string}, et agé de {int} ans")
    public void un_pirate_possedant_un_perroquet_nomme(String nomPerroquet, String couleur, int age) {
        pirate = new Pirate("inconnu","inconnu",12,"inconnu");
        perroquet = new Perroquet(nomPerroquet, couleur, age);
    }

    @Given("ce perroquet existe et est associé au pirate")
    public void ce_perroquet_existe_et_est_associe_au_pirate() {
        pirate.setPerroquet(perroquet);
        perroquet.setMaitre(pirate);
    }

    @When("le pirate fait parler le perroquet avec la phrase {string}")
    public void le_pirate_fait_parler_le_perroquet_avec_la_phrase(String phrase) {
        dernierMessage = pirate.faireParlerPerroquet(phrase);
    }

    @Then("le perroquet doit répéter la phrase {string} à l'ecran")
    public void le_perroquet_doit_repeter_la_phrase_a_l_ecran(String phrase) {
        String messageAttendu = perroquet.parler(phrase);
        assertEquals(messageAttendu, dernierMessage,
                "Le message répété par le perroquet ne correspond pas à celui attendu.");
    }
}
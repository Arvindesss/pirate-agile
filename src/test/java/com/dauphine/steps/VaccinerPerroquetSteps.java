package com.dauphine.steps;

import com.dauphine.vaccinable.impl.Perroquet;
import com.dauphine.vaccinable.impl.Pirate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.MockedStatic;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

public class VaccinerPerroquetSteps {

    private Pirate pirate;

    private Perroquet perroquet;

    private Exception exception;

    @Given("^un pirate avec le nom \"([^\"]*)\", le prenom \"([^\"]*)\", âgé de \"(\\d+)\" ans et étant \"([^\"]*)\"$")
    public void unPirateAvecNomPrenomAgeGrade(String nom, String prenom, int age, String grade) {
        pirate = new Pirate(nom, prenom, age, grade);
    }

    @Given("^son perroquet avec le nom \"([^\"]*)\", la couleur \"([^\"]*)\", âgé de \"(\\d+)\" ans$")
    public void unPerroquetAvecNomPrenomAgeGrade(String nom, String couleur, int age) {
        perroquet = new Perroquet(nom, couleur, age);
        pirate.setPerroquet(perroquet);
    }

    @Given("^le pirate a trouvé un vaccin pour la pacheco le \"([^\"]*)\"$")
    public void lePirateATrouvéUnVaccinPachecoAUneDate(String dateString) {
        LocalDate today = LocalDate.parse(dateString);
        try (MockedStatic<LocalDate> mockedLocalDate = mockStatic(LocalDate.class)) {
            mockedLocalDate.when(LocalDate::now).thenReturn(today);
            pirate.trouverVaccin("pacheco","VaccinPerroquet1", "Dr Smith",1);
        }
    }

    @Given("^le pirate a trouvé un vaccin pour le covid-19 le \"([^\"]*)\"$")
    public void lePirateATrouvéUnVaccinCovid19AUneDate(String dateString) {
        LocalDate today = LocalDate.parse(dateString);
        try (MockedStatic<LocalDate> mockedLocalDate = mockStatic(LocalDate.class)) {
            mockedLocalDate.when(LocalDate::now).thenReturn(today);
            pirate.trouverVaccin("covid19", "VaccinCovid19", "Dr Jones", 1);
        }
    }

    @Given("^le perroquet n'a jamais été vacciné$")
    public void lePerroquetNAJamaisÉtéVacciné() {
        assertTrue(perroquet.getVaccinsRecus().isEmpty(), "Le perroquet a déjà été vacciné !");
    }

    @And("le pirate n'a pas de vaccins à disposition")
    public void lePirateNAPasDeVaccinsÀDisposition() {
        assertTrue(pirate.getVaccinsDisponibles().isEmpty(), "Le pirate a un vaccin à disposition !");
    }

    @When("^il vaccine son perroquet avec le vaccin présent à la position numéro (\\d+) le \"([^\"]*)\"$")
    public void ilVaccineSonPerroquetAvecLeVaccinNuméro(int numPosition, String dateString) {
        LocalDate today = LocalDate.parse(dateString);
        try (MockedStatic<LocalDate> mockedLocalDate = mockStatic(LocalDate.class)) {
            mockedLocalDate.when(LocalDate::now).thenReturn(today);
            pirate.vaccinerPeroquet(numPosition - 1); // numero 1 à l'index 0
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("^Le perroquet à été vacciné (\\d+) fois$")
    public void lePerroquetAÉtéVaccinéXfois(int nombreVaccins) {
        assertEquals(nombreVaccins, perroquet.getVaccinsRecus().size());
    }

    @Then("^une erreur devrait être levée disant \"([^\"]*)\"$")
    public void uneErreurDevraitÊtreLevéeDisant(String message) {
        assertNotNull(exception, "Aucune exception n'a été levée !");
        assertEquals(message, exception.getMessage());
    }

    @Then("une erreur devrait être levée concernant le manque de vaccin disant {string}")
    public void uneErreurDevraitÊtreLevéeConcernantLeManqueDeVaccinDisant(String message) {
        assertNotNull(exception, "Aucune exception n'a été levée !");
        assertEquals(message, exception.getMessage());
    }
}

package junit;

import com.dauphine.vaccinable.impl.Personne;
import com.dauphine.vaccin.impl.Vaccin;
import com.dauphine.vaccin.impl.VaccinCovid19;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VaccinPersonneTest {

    private Vaccin vaccin;
    private Personne personne;

    @BeforeEach
    void setUp() {
        this.vaccin = new VaccinCovid19("anti-covid","Pfizer");
        this.personne = new Personne("Halim","Zerara",22);
    }

    @Test
    public void testVaccination() {
        assertFalse(personne.isVaccinated(vaccin));
        personne.recevoirVaccin(vaccin);
        assertTrue(personne.isVaccinated(vaccin));
    }

    @Test
    public void testVaccination2fois() {
        personne.recevoirVaccin(vaccin);
        assertTrue(personne.isVaccinated(vaccin));
        personne.recevoirVaccin(vaccin);
        assertTrue(personne.isVaccinated(vaccin));
    }

    @Test
    public void testSetNameAndGetNom() {
        String expectedName = "anti-covid";

        vaccin.setNom(expectedName);
        String actualName = vaccin.getNom();

        assertEquals(expectedName, actualName, "Le nom du vaccin ne correspond pas à celui attendu.");
    }

    @Test
    public void testSetCreatorAndGetCreator() {
        String expectedCreator = "Pfizer";

        vaccin.setCreateur(expectedCreator);
        String actualCreator = vaccin.getCreateur();

        assertEquals(expectedCreator, actualCreator, "Le créateur du vaccin ne correspond pas à celui attendu.");
    }

    @Test
    public void testSetNameWithNull() {
        vaccin.setNom(null);
        String actualName = vaccin.getNom();

        assertNull(actualName, "Le nom devrait être null.");
    }

    @Test
    public void testSetCreatorWithEmptyString() {
        String expectedCreator = "";

        vaccin.setCreateur(expectedCreator);
        String actualCreator = vaccin.getCreateur();

        assertEquals(expectedCreator, actualCreator, "Le créateur devrait être une chaîne vide.");
    }

    @Test
    public void testSetNomWithValidValue() {
        String expectedNom = "Jane";

        Personne personne = new Personne("John", "Doe", 30);
        personne.setNom(expectedNom);
        String actualNom = personne.getNom();

        assertEquals(expectedNom, actualNom, "Le nom devrait être 'Jane'.");
    }

    @Test
    public void testSetPrenomWithValidValue() {
        String expectedPrenom = "Smith";

        Personne personne = new Personne("John", "Doe", 30);
        personne.setPrenom(expectedPrenom);
        String actualPrenom = personne.getPrenom();

        assertEquals(expectedPrenom, actualPrenom, "Le prénom devrait être 'Smith'.");
    }

    @Test
    public void testSetAgeWithValidValue() {
        int expectedAge = 35;

        Personne personne = new Personne("John", "Doe", 30);
        personne.setAge(expectedAge);
        int actualAge = personne.getAge();

        assertEquals(expectedAge, actualAge, "L'âge devrait être 35.");
    }
}
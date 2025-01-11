package junit;

import com.dauphine.vaccin.Personne;
import com.dauphine.vaccin.Vaccin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VaccinTest {

    private Vaccin vaccin;
    private Personne personne;

    @BeforeEach
    void setUp() {
        this.vaccin = new Vaccin("anti-covid","Pfizer");
        this.personne = new Personne("Halim","Zerara",22);
    }

    @Test
    public void testVaccination() {
        assertEquals(vaccin.isVaccined(personne),false);
        vaccin.Vaccined(personne);
        assertEquals(vaccin.isVaccined(personne),true);
    }

    @Test
    public void testSetNameAndGetName() {
        String expectedName = "anti-covid";

        vaccin.setName(expectedName);
        String actualName = vaccin.getName();

        assertEquals(expectedName, actualName, "Le nom du vaccin ne correspond pas à celui attendu.");
    }

    @Test
    public void testSetCreatorAndGetCreator() {
        String expectedCreator = "Pfizer";

        vaccin.setCreator(expectedCreator);
        String actualCreator = vaccin.getCreator();

        assertEquals(expectedCreator, actualCreator, "Le créateur du vaccin ne correspond pas à celui attendu.");
    }

    @Test
    public void testSetNameWithNull() {
        vaccin.setName(null);
        String actualName = vaccin.getName();

        assertNull(actualName, "Le nom devrait être null.");
    }

    @Test
    public void testSetCreatorWithEmptyString() {
        String expectedCreator = "";

        vaccin.setCreator(expectedCreator);
        String actualCreator = vaccin.getCreator();

        assertEquals(expectedCreator, actualCreator, "Le créateur devrait être une chaîne vide.");
    }
}
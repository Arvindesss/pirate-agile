package junit;

import com.dauphine.Perroquet;
import com.dauphine.Pirate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PirateTest {

    private Pirate arvinde;

    private Perroquet ilyess;

    /**
     * Constructeur de la classe-test junit.PirateTest
     */
    public PirateTest() {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        arvinde = new Pirate();
        ilyess = new Perroquet("ilyess", "vert", 12);
        arvinde.getGrade();
        arvinde.setPerroquet(ilyess);
        arvinde.faireParlerPerroquet("bonjour pirate ");
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }

    @Test
    public void testVieillir() {
        // Arrange : Création d'un pirate avec un âge initial de 20
        Pirate pirate = new Pirate();
        pirate.setAge(20);

        // Act : Appel de la méthode vieillir
        pirate.vieillir(1);

        // Assert : Vérification que l'âge a bien augmenté de 1
        Assertions.assertEquals(21, pirate.getAge());
    }

    @Test
    public void testPirateFaitParlerPerroquet()
    {
        arvinde.setPerroquet(ilyess);
        arvinde.faireParlerPerroquet("test 1 2 3");
    }
}
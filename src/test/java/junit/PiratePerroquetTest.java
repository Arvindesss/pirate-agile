package junit;

import com.dauphine.vaccinable.impl.Perroquet;
import com.dauphine.vaccinable.impl.Pirate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PiratePerroquetTest {

    private Pirate arvinde;

    private Perroquet ilyess;

    /**
     * Constructeur de la classe-test junit.PirateTest
     */
    public PiratePerroquetTest() {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
       /* arvinde = new Pirate("seng", "arvinde", 12, "mousaillon");
        ilyess = new Perroquet("ilyess", "vert", 12);
        arvinde.getGrade();
        arvinde.setPerroquet(ilyess);
        arvinde.faireParlerPerroquet("bonjour pirate ");*/
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
        @AfterEach
        public void tearDown () // throws java.lang.Exception
        {
            //Libérez ici les ressources engagées par setUp()
        }

        @Test
        public void testVieillir () {
        // Arrange : Création d'un pirate avec un âge initial de 20
        arvinde = new Pirate("seng", "arvinde", 20, "mousaillon");

        // Act : Appel de la méthode vieillir
        arvinde.vieillir(1);

        // Assert : Vérification que l'âge a bien augmenté de 1
        assertEquals(21, arvinde.getAge());
    }

        @Test
        public void testPirateFaitParlerPerroquet () {
        // Arrange : Création d'un pirate prononcant une phrase a répeter par le perroquet
        arvinde = new Pirate("seng", "arvinde", 20, "mousaillon");
        ilyess = new Perroquet("ilyess", "vert", 12);
        arvinde.setPerroquet(ilyess);
        final String phrase = "test 1 2 3";

        // Act : Appel de la méthode faire parler le perroquet
        String phrasePerroquet = arvinde.faireParlerPerroquet(phrase);

        // Assert : Vérification que le perroquet enonce la même phrase
        assertEquals(phrase, phrasePerroquet);
    }

        @Test
        public void testPirateSansPerroquetFaitParlerPerroquet () {
        // Arrange : Création d'un pirate sans perroquet prononcant une phrase a répeter par le perroquet
        arvinde = new Pirate("seng", "arvinde", 20, "mousaillon");
        arvinde.setPerroquet(null);
        final String phrase = "test 1 2 3";

        // Act : Appel de la méthode faire parler le perroquet
        RuntimeException exception = assertThrows(RuntimeException.class, () -> arvinde.faireParlerPerroquet(phrase));

        // Assert : Vérification que le perroquet enonce la même phrase
        assertEquals("Le pirate n'a pas de perroquet pour parler.", exception.getMessage());
        }

        @Test public void testPirateGettersAndSetters () {
        Pirate pirate = new Pirate("Jack", "Sparrow", 40, "Capitaine");

        // Test des getters et setters pour le grade
        assertEquals("Capitaine", pirate.getGrade());
        pirate.setGrade("Amiral");
        assertEquals("Amiral", pirate.getGrade());

        // Test des getters et setters pour le perroquet
        Perroquet perroquet = new Perroquet("Polly", "Vert", 5);
        assertNull(pirate.getPerroquet());
        pirate.setPerroquet(perroquet);
        assertEquals(perroquet, pirate.getPerroquet());
    }

        @Test
        public void testPerroquetGettersAndSetters() {
        Perroquet perroquet = new Perroquet("Polly", "Vert", 5);

        // Test des getters et setters pour le nom
        assertEquals("Polly", perroquet.getNom());
        perroquet.setNom("Coco");
        assertEquals("Coco", perroquet.getNom());

        // Test des getters et setters pour la couleur
        assertEquals("Vert", perroquet.getCouleur());
        perroquet.setCouleur("Rouge");
        assertEquals("Rouge", perroquet.getCouleur());

        // Test des getters et setters pour l'âge
        assertEquals(5, perroquet.getAge());
        perroquet.setAge(6);
        assertEquals(6, perroquet.getAge());

        // Test des getters et setters pour le maître
        assertNull(perroquet.getMaitre());
        Pirate pirate = new Pirate("Jack", "Sparrow", 40, "Capitaine");
        perroquet.setMaitre(pirate);
        assertEquals(pirate, perroquet.getMaitre());
    }

    @Test
    public void testToStringPirate() {
        // Création d'une instance de Pirate
        Pirate pirate = new Pirate("Jack", "Sparrow", 40, "Capitaine");

        // Appel de la méthode toString pour vérifier le format
        String expectedString = "Pirate [Âge: 40, Grade: Capitaine]";
        String actualString = pirate.toString();

        // Vérification que la méthode toString retourne la bonne chaîne
        assertEquals(expectedString, actualString, "La méthode toString() ne retourne pas la chaîne attendue.");
    }

    @Test
    public void testToStringPerroquet() {
        // Création d'une instance de Perroquet
        Perroquet perroquet = new Perroquet("Polly", "Vert", 5);

        // Appel de la méthode toString pour vérifier le format
        String expectedString = "Perroquet [Nom: Polly, Couleur: Vert, Âge: 5 ans]";
        String actualString = perroquet.toString();

        // Vérification que la méthode toString retourne la bonne chaîne
        assertEquals(expectedString, actualString, "La méthode toString() ne retourne pas la chaîne attendue.");
    }

}
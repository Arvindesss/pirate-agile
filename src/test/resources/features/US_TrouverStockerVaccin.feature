Feature: Trouver et stocker des vaccins
  En tant que personne
  Je veux pouvoir trouver et stocker des vaccins
  Afin d'assurer ma protection et ma santé

  Scenario: Trouver un vaccin
    Given une personne nommée "Jean" "Dupont" âgée de 35 ans
    And qui n'a aucun vaccin disponible
    When il recherche un vaccin de type "covid19" appelé "VaccinCovid", créé par "Dr Smith" en 2 exemplaires le "2025-01-12"
    Then il devrait avoir 2 vaccins disponibles appelés "VaccinCovid"

  Scenario: Trouver 5 vaccins pour humain et 5 vaccins pour perroquet
    Given une personne nommée "Jean" "Dupont" âgée de 35 ans
    And qui n'a aucun vaccin disponible
    When il recherche un vaccin de type "covid19" appelé "VaccinCovid", créé par "Dr Smith" en 5 exemplaires le "2025-01-12"
    And  il recherche un vaccin de type "pacheco" appelé "VaccinPacheco", créé par "Dr Smith" en 5 exemplaires le "2025-01-12"
    Then il devrait avoir 5 vaccins disponibles appelés "VaccinCovid"
    And il devrait avoir 5 vaccins disponibles appelés "VaccinPacheco"

  Scenario: Trouver un vaccin qui n'existe pas
    Given une personne nommée "Jean" "Dupont" âgée de 35 ans
    And qui n'a aucun vaccin disponible
    When il recherche un vaccin de type "hepatite" appelé "Hepatite C", créé par "Dr Smith" en 1 exemplaires le "2025-01-12"
    Then Une erreur devrait être levée concernant le vaccin qui n'a pas été trouvé: "Type de vaccin inconnu : hepatite"
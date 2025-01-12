Feature: Gestion de la vaccination

  Scenario: Vérifier si une personne est vaccinée (initialement non vaccinée)
    Given un vaccin de type covid-19 nommé "anti-covid" créé par "Pfizer"
    And une personne nommée "Halim" "Zerara" agée de 22 ans
    When on vérifie si la personne est vaccinée avec ce vaccin
    Then le résultat devrait être "false"

  Scenario: Vacciner une personne et vérifier le statut
    Given un vaccin de type covid-19 nommé "anti-covid" créé par "Pfizer"
    And une personne nommée "Halim" "Zerara" agée de 22 ans
    When on vaccine la personne avec ce vaccin
    And on vérifie si la personne est vaccinée avec ce vaccin
    Then le résultat devrait être "true"

  Scenario: Modifier le nom du vaccin (Using same name as in setup for clarity)
    Given un vaccin de type covid-19 nommé "anti-covid" créé par "Pfizer"
    When on modifie le nom du vaccin pour "anti-covid"
    Then le nom du vaccin devrait être "anti-covid"

  Scenario: Modifier le créateur du vaccin (Using same creator as in setup)
    Given un vaccin de type covid-19 nommé "anti-covid" créé par "Pfizer"
    When on modifie le créateur du vaccin pour "Pfizer"
    Then le créateur du vaccin devrait être "Pfizer"


  Scenario: Nom du vaccin null
    Given un vaccin de type covid-19 nommé "anti-covid" créé par "Pfizer"
    When on modifie le nom du vaccin pour null
    Then le nom du vaccin devrait être null

  Scenario: Createur du vaccin vide
    Given un vaccin de type covid-19 nommé "anti-covid" créé par "Pfizer"
    When on modifie le créateur du vaccin pour ""
    Then le créateur du vaccin devrait être ""
Feature: Vaccination d'une personne
  En tant que personne humaine
  Je veux pouvoir me faire vacciner
  Afin d'assurer ma protection et ma santé

  Scenario: Recevoir un vaccin expiré
    Given une personne nommée "Halim" "Zerara" agé de 22 ans
    And il trouve le vaccin de type "covid19" appelé "VaccinCovid1" créé par "Pfizer" en 1 exemplaires le "2000-01-12"
    And la personne n'a jamais été vaccinée
    When elle se vaccine avec le vaccin présent à la position numéro 1 le "2025-01-12"
    Then Une erreur devrait être levée concernant l'expiration du vaccin : "Le vaccin est expiré"

  Scenario: Vacciner une personne humaine avec un vaccin contre le covid19
    Given une personne nommée "Halim" "Zerara" agé de 22 ans
    And il trouve le vaccin de type "covid19" appelé "VaccinCovid1" créé par "Pfizer" en 1 exemplaires le "2000-01-12"
    And la personne n'a jamais été vaccinée
    When elle se vaccine avec le vaccin présent à la position numéro 1 le "2000-01-12"
    Then la personne à été vacciné 1 fois

  Scenario: Vacciner une personne humaine avec un vaccin contre la pacheco
    Given une personne nommée "Halim" "Zerara" agé de 22 ans
    And il trouve le vaccin de type "pacheco" appelé "VaccinPacheco" créé par "Pfizer" en 1 exemplaires le "2000-01-12"
    When elle se vaccine avec le vaccin présent à la position numéro 1 le "2000-01-12"
    Then une erreur devrait être levée concernant la non compatibilité du vaccin disant "Le vaccin est n'est pas adapté à un humain"
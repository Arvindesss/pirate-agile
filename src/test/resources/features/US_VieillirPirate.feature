@test2
Feature: US_VieillirPirate

  En tant que Pirate,
  Je veux pouvoir vieillir d’un an
  Afin que mon âge reflète correctement le temps qui s’écoule.

  Scenario Outline: Le pirate vieillit d'un an
    Given un pirate avec le nom "Sparrow", le prenom "Jack", âgé de <ageInitial> ans et étant "Capitaine"
    When Le pirate vieillit de <nbAnnee> années
    Then l'âge du pirate doit maintenant être <ageFinal>
    Examples:
      | ageInitial |  nbAnnee | ageFinal |
      | 0          | 1        | 1        |
      | 19         | 2        | 21       |
      | 30         | 3        | 33       |
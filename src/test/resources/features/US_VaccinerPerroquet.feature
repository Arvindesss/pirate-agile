Feature: Vacciner un perroquet
  En tant que pirate
  Je veux pouvoir vacciner un perroquet
  Afin d'assurer sa protection et sa santé

  Scenario: Recevoir un vaccin expiré
    Given un pirate avec le nom "Tony", le prenom "Sosa", âgé de "22" ans et étant "Mousaillon"
    And son perroquet avec le nom "Coco", la couleur "Rouge", âgé de "3" ans
    And le pirate a trouvé un vaccin pour la pacheco le "2000-01-12"
    When il vaccine son perroquet avec le vaccin présent à la position numéro 1 le "2025-01-12"
    Then une erreur devrait être levée disant "Le vaccin est expiré"

  Scenario: Vacciner sans vaccins disponibles
    Given un pirate avec le nom "Tony", le prenom "Sosa", âgé de "22" ans et étant "Mousaillon"
    And son perroquet avec le nom "Coco", la couleur "Rouge", âgé de "3" ans
    And le pirate n'a pas de vaccins à disposition
    When il vaccine son perroquet avec le vaccin présent à la position numéro 1 le "2000-01-12"
    Then une erreur devrait être levée concernant le manque de vaccin disant "Le vaccin recherché n'existe pas"

  Scenario: Vacciner un perroquet avec un vaccin pour la pacheco
    Given un pirate avec le nom "Tony", le prenom "Sosa", âgé de "22" ans et étant "Mousaillon"
    And son perroquet avec le nom "Coco", la couleur "Rouge", âgé de "3" ans
    And le pirate a trouvé un vaccin pour la pacheco le "2000-01-12"
    And le perroquet n'a jamais été vacciné
    When il vaccine son perroquet avec le vaccin présent à la position numéro 1 le "2000-01-12"
    Then Le perroquet à été vacciné 1 fois

  Scenario: Vacciner un perroquet avec un vaccin pour le covid-19
    Given un pirate avec le nom "Tony", le prenom "Sosa", âgé de "22" ans et étant "Mousaillon"
    And son perroquet avec le nom "Coco", la couleur "Rouge", âgé de "3" ans
    And le pirate a trouvé un vaccin pour le covid-19 le "2000-01-12"
    And le perroquet n'a jamais été vacciné
    When il vaccine son perroquet avec le vaccin présent à la position numéro 1 le "2000-01-12"
    Then une erreur devrait être levée disant "Le vaccin est n'est pas adapté à un perroquet"
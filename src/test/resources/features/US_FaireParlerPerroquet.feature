@test1
Feature: US_FaireParlerPerroquet

  En tant que Pirate,
  Je veux faire parler mon perroquet en lui faisant répéter une phrase
  Afin d’impressionner les autres membres de l’équipage.

  Scenario Outline: Le perroquet répète la phrase transmise par le pirate
    Given un pirate possédant un perroquet nommé <nomPerroquet>, de couleur <couleur>, et agé de <age> ans
    And ce perroquet existe et est associé au pirate
    When le pirate fait parler le perroquet avec la phrase <phrase>
    Then le perroquet doit répéter la phrase <phrase> à l'ecran

    Examples:
      | nomPerroquet | phrase                       | couleur | age |
      | "Ilyess"     | "A l'abordage !"             | "vert"  | 3   |
      | "Coco"         | "A l'abordage mousaillon !" | "rouge" | 5   |
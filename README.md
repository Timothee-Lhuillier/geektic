geektic
=======

Français:
Application web Geektic permettant de trouver l’âme sœur parmi un ensemble de geeks.

Géré sous gradle et utilise comme serveur tomcat 7
Une API est présente:
   /api/geeks : retourne tout les geek(ette)s
   /api/geek/{id} : retourne le/la geek(ette) ayant l'id
   /api/findGeeks/gender/{gender}/interests/{interests}/cities/{cities} : retourne le résultat de la recherche
   /api/findLuckyGeek/gender/{gender}/interests/{interests}/cities/{cities} : retourne le même résultat que la fonction chanceux de la recherche
   /api/cities : retourne la liste des villes
   /api/interests : retourne la liste des intérets

------------------------------------------------------------------------------------
English:
Web application Geektic to find a soul mate among a set of geeks.

Managed with gradle and used as tomcat 7
there is an API:
   /api/geeks : returns all geeks
   /api/geek/{id} : returns the geek with id
   /api/findGeeks/gender/{gender}/interests/{interests}/cities/{cities} : returns the search result
   /api/findLuckyGeek/gender/{gender}/interests/{interests}/cities/{cities} : returns the same result as the lucky function of search
   /api/cities : returns all cities
   /api/interests : returns all interests
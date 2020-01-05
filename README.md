# leBonAngle


Back End v1 fini : (démarrer avec mvn spring-boot:run depuis /leBonAngleAPI)
1. Utilisateurs
    * GET /utilisateurs
    * POST /utilisateurs avec header : content-type = application/json
    et body contenant un json avec "pseudo", "telephone" et "email" en strings
    * GET /utilisateurs/{id}  ou {id} est un uuid (sans "")
    * DELETE /utilisateurs/{id}
2. Categories
    * GET /categories
    * POST /categories avec header : content-type = application/json
    et body contenant un json avec "nom" en strings
    * GET /categories/{id}  ou {id} est un uuid (sans "")
    * DELETE /categories/{id}
3. Annonces
    * GET /annonces
    * POST /annonces avec header : content-type = application/json
    et body contenant un json avec "titre", "description", "lieu" en strings, "prix" un decimal
    et queryparams auteurId un uuid (sans "") et categorieId un uuid (sans "")
    * GET /annonces/{id}  ou {id} est un uuid (sans "")
    * GET /annoncesFromAuteur/{id}  
    * GET /annoncesFromCategorie/{id}  
    * DELETE /annonces/{id}
4. Photos
    * GET /photos
    * POST /photos avec body form-data contenant string titre, string annonceId et file file
    * GET /photos/{id}  ou {id} est un uuid (sans "")
    * GET /photosIdForAnnonce/{id}
    * DELETE /photos/{id}

RESTE TOUT LE FRONT END...

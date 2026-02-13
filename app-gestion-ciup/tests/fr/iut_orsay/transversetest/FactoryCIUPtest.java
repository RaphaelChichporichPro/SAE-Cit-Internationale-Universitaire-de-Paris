package fr.iut_orsay.transversetest;

import fr.iut_orsay.transverse.controllers.FactoryCIUP;
import fr.iut_orsay.transverse.models.Etudiant;
import fr.iut_orsay.transverse.models.ListeMaison;
import fr.iut_orsay.transverse.models.Maison;

public class FactoryCIUPtest {

    private static Maison maison;

    public static void setup() {
        // Initialisation d'une maison pour les tests
        maison = new Maison("Maison Test", "Adresse Test", 2, "Nationalité Test", "Directeur Test");
        ListeMaison.ajouterMaison(maison); // Ajout de la maison à la liste
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void testCreerEtudiant_ValidInput_ExpectedBehavior() {
        setup(); // Appel de la méthode setup pour initialiser la maison
        Etudiant etudiant = FactoryCIUP.creerEtudiant("Nom", "Prenom", "Nationalite", "01-01-2000", "email@example.com", "0123456789", true, 2023, false, null);
        assert etudiant != null : "Test FAILED ! L'étudiant ne devrait pas être nul.";
        assert "Nom".equals(etudiant.getNom()) : "Test FAILED ! Le nom de l'étudiant devrait être 'Nom'.";
        System.out.println("testCreerEtudiant_ValidInput_ExpectedBehavior passed.\n");
    }

  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void testCreerEtudiant_NomNul_ExpectedBehavior() {
        setup();
        try {
            FactoryCIUP.creerEtudiant(null, "Prenom", "Nationalite", "01-01-2000", "email@example.com", "0123456789", true, 2023, false, null);
            assert false : "Test FAILED ! Une IllegalArgumentException devrait être lancée pour un nom nul.";
        } catch (IllegalArgumentException e) {
            System.out.println("testCreerEtudiant_NomNul_ExpectedBehavior passed.\n");
        }
    }

  //-------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
    public static void testCreerEtudiant_NationaliteNulle_ExpectedBehavior() {
        setup();
        try {
            FactoryCIUP.creerEtudiant("Nom", "Prenom", null, "01-01-2000", "email@example.com", "0123456789", true, 2023, false, null);
            assert false : "Test FAILED ! Une IllegalArgumentException devrait être lancée pour une nationalité nulle.";
        } catch (IllegalArgumentException e) {
            System.out.println("testCreerEtudiant_NationaliteNulle_ExpectedBehavior passed.\n");
        }
    }

  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void testCreerEtudiant_DateNaissanceNulle_ExpectedBehavior() {
        setup();
        try {
            FactoryCIUP.creerEtudiant("Nom", "Prenom", "Nationalite", null, "email@example.com", "0123456789", true, 2023, false, null);
            assert false : "Test FAILED ! Une IllegalArgumentException devrait être lancée pour une date de naissance nulle.";
        } catch (IllegalArgumentException e) {
            System.out.println("testCreerEtudiant_DateNaissanceNulle_ExpectedBehavior passed.\n");
        }
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void testCreerEtudiant_EmailNul_ExpectedBehavior() {
        setup();
        try {
            FactoryCIUP.creerEtudiant("Nom", "Prenom", "Nationalite", "01-01-2000", null, "0123456789", true, 2023, false, null);
            assert false : "Test FAILED ! Une IllegalArgumentException devrait être lancée pour un email nul.";
        } catch (IllegalArgumentException e) {
            System.out.println("testCreerEtudiant_EmailNul_ExpectedBehavior passed.\n");
        }
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void testCreerEtudiant_MaisonNulle_ExpectedBehavior() {
        setup();
        Etudiant etudiant = FactoryCIUP.creerEtudiant("Nom", "Prenom", "Nationalite", "01-01-2000", "email@example.com", "0123456789", true, 2023, false, null);
        assert etudiant.getMaisonSouhaitee() != null : "Test FAILED ! L'étudiant devrait être assigné à une maison.";
        System.out.println("testCreerEtudiant_MaisonNulle_ExpectedBehavior passed.\n");
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
 // Tests pour la méthode creerMaison
    public static void testCreerMaison_ValidInput_ExpectedBehavior() {
        setup(); // Appel de la méthode setup pour initialiser la liste des maisons
        Maison maison = FactoryCIUP.creerMaison("Maison Test", "Adresse Test", 10, "Nationalité Test", "Directeur Test");
        assert maison != null : "La maison ne devrait pas être nulle.";
        assert "Maison Test".equals(maison.getNom()) : "Test FAILED !Le nom de la maison devrait être 'Maison Test'.";
        assert "Adresse Test".equals(maison.getAdresse()) : "Test FAILED ! L'adresse de la maison devrait être 'Adresse Test'.";
        assert maison.getCapaciteMax() == 10 : "Test FAILED ! La capacité maximale de la maison devrait être 10.";
        assert "Nationalité Test".equals(maison.getNationalitePrincipale()) : "Test FAILED ! La nationalité principale de la maison devrait être 'Nationalité Test'.";
        System.out.println("testCreerMaison_ValidInput_ExpectedBehavior passed.\n");
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void testCreerMaison_NomNul_ExpectedBehavior() {
        setup();
        try {
            FactoryCIUP.creerMaison(null, "Adresse Test", 10, "Nationalité Test", "Directeur Test");
            assert false : "Test FAILED ! Une IllegalArgumentException devrait être lancée pour un nom nul.";
        } catch (IllegalArgumentException e) {
            System.out.println("testCreerMaison_NomNul_ExpectedBehavior passed.\n");
        }
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void testCreerMaison_AdresseNulle_ExpectedBehavior() {
        setup();
        try {
            FactoryCIUP.creerMaison("Maison Test", null, 10, "Nationalité Test", "Directeur Test");
            assert false : "Test FAILED ! Une IllegalArgumentException devrait être lancée pour une adresse nulle.";
        } catch (IllegalArgumentException e) {
            System.out.println("testCreerMaison_AdresseNulle_ExpectedBehavior passed.\n");
        }
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void testCreerMaison_CapaciteMaxNulle_ExpectedBehavior() {
        setup();
        try {
            FactoryCIUP.creerMaison("Maison Test", "Adresse Test", 0, "Nationalité Test", "Directeur Test");
            assert false : "Test FAILED ! Une IllegalArgumentException devrait être lancée pour une capacité maximale nulle ou négative.";
        } catch (IllegalArgumentException e) {
            System.out.println("testCreerMaison_CapaciteMaxNulle_ExpectedBehavior passed.\n");
        }
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void testCreerMaison_NationalitePrincipaleNulle_ExpectedBehavior() {
        setup();
        try {
            FactoryCIUP.creerMaison("Maison Test", "Adresse Test", 10, null, "Directeur Test");
            assert false : "Test FAILED ! Une IllegalArgumentException devrait être lancée pour une nationalité principale nulle.";
        } catch (IllegalArgumentException e) {
            System.out.println("testCreerMaison_NationalitePrincipaleNulle_ExpectedBehavior passed.\n");
        }
    }
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void testCreerMaison_DirecteurNul_ExpectedBehavior() {
        setup();
        try {
            FactoryCIUP.creerMaison("Maison Test", "Adresse Test", 10, "Nationalité Test", null);
            assert false : "Test FAILED ! Une IllegalArgumentException devrait être lancée pour un directeur nul.";
        } catch (IllegalArgumentException e) {
            System.out.println("testCreerMaison_DirecteurNul_ExpectedBehavior passed.\n");
        }
    }

  
}
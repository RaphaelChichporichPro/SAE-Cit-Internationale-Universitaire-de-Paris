package fr.iut_orsay.transversetest;

import fr.iut_orsay.transverse.*;
import fr.iut_orsay.transverse.models.ListeMaison;
import fr.iut_orsay.transverse.models.Maison;

public class ListeMaisonTest {

    public static void runTest(){
        ListeMaisonTest.testAjouterMaison();
        ListeMaisonTest.testSupprimerMaisonIndexValide();
        ListeMaisonTest.testSupprimerMaisonHorsLimite();
        ListeMaisonTest.testSupprimerMaisonArrayVide();
        ListeMaisonTest.testSupprimerMaisonValide();
        ListeMaisonTest.testSupprimerMaisonNonExistant();
        ListeMaisonTest.testGetMaisonValide();
        ListeMaisonTest.testGetMaisonArrayVide();

    }

    public static void testAjouterMaison() {
        ListeMaison.getListeMaisons().clear();
        Maison m0 = new Maison("Maison1", "123 rue de France", 100, "France", "M.Dupont");
        Maison m1 = new Maison("Maison2", "456 rue de France", 153, "France", "M.Dupond");
        ListeMaison.ajouterMaison(m0);
        ListeMaison.ajouterMaison(m1);

        if(ListeMaison.getListeMaisons().size() == 2){
            System.out.println("TEST : testAjouterMaison PASSE");
        }else{
            System.out.println("TEST : testAjouterMaison NON PASSE");
        }
    }

    //*TESTS SUPPRESSION PAR INDEX
    public static void testSupprimerMaisonIndexValide(){
        ListeMaison.getListeMaisons().clear();
        Maison m0 = new Maison("Maison1", "123 rue de France", 100, "France", "M.Dupont");
        ListeMaison.ajouterMaison(m0);

        ListeMaison.supprimerMaison(0);
        if (ListeMaison.getListeMaisons().isEmpty()) {
            System.out.println("TEST : testSupprimerMaisonIndexValide PASSE");
        } else {
            System.out.println("TEST : testSupprimerMaisonIndexValide NON PASSE");
        }
    }

    public static void testSupprimerMaisonHorsLimite(){
        ListeMaison.getListeMaisons().clear();
        Maison m0 = new Maison("Maison1", "123 rue de France", 100, "France", "M.Dupont");
        Maison m1 = new Maison("Maison2", "456 rue de France", 153, "France", "M.Dupond");
        ListeMaison.ajouterMaison(m0);
        ListeMaison.ajouterMaison(m1);

        try{
            ListeMaison.supprimerMaison(5);
            System.out.println("TEST : testSupprimerMaisonHorsLimite NON PASSE");
        }catch(Exception e){
            System.out.println("TEST : testSupprimerMaisonHorsLimite PASSE");
        }
    }

    public static void testSupprimerMaisonArrayVide(){
        ListeMaison.getListeMaisons().clear();
        try{
            ListeMaison.supprimerMaison(5);
            System.out.println("TEST : testSupprimerMaisonArrayVide NON PASSE");
        }catch(Exception e){
            System.out.println("TEST : testSupprimerMaisonArrayVide PASSE");
        }
    }

    //TODO: test suppression maison 
    //*TESTS SUPPRESSION PAR OBJET
    public static void testSupprimerMaisonValide(){
        ListeMaison.getListeMaisons().clear();
        Maison m0 = new Maison("Maison1", "123 rue de France", 100, "France", "M.Dupont");
        ListeMaison.ajouterMaison(m0);

        ListeMaison.supprimerMaison(m0);
        if (ListeMaison. getListeMaisons().isEmpty()) {
            System.out.println("TEST : testSupprimerMaisonIndexValide PASSE");
        } else {
            System.out.println("TEST : testSupprimerMaisonIndexValide NON PASSE");
        }
    }

    public static void testSupprimerMaisonNonExistant() {
        ListeMaison.getListeMaisons().clear();
        Maison m0 = new Maison("Maison1", "123 rue de France", 100, "France", "M.Dupont");
        Maison m1 = new Maison("Maison2", "456 rue de France", 153, "France", "M.Dupond");
        ListeMaison.ajouterMaison(m0);
    
        try {
            ListeMaison.supprimerMaison(m1); // m2 n'a jamais été ajoutée
            System.out.println("TEST : testSupprimerMaisonNonExistant NON PASSE");
        } catch (Exception e) {
            System.out.println("TEST : testSupprimerMaisonNonExistant PASSE");
        }
    }


    //TODO: test get(index): liste vide
    //* TESTS get(index)

    public static void testGetMaisonValide(){
        ListeMaison.getListeMaisons().clear();
        Maison m0 = new Maison("Maison1", "123 rue de France", 100, "France", "M.Dupont");
        ListeMaison.ajouterMaison(m0);

        try {
            Maison result = ListeMaison.get(0);
            if (result.equals(m0)) {
                System.out.println("TEST : testGetMaisonValide PASSE");
            } else {
                System.out.println("TEST : testGetMaisonValide NON PASSE");
            }
        } catch (Exception e) {
            System.out.println("TEST : testGetMaisonValide NON PASSE (Exception)");
        }
    }

    public static void testGetMaisonArrayVide() {
        ListeMaison.getListeMaisons().clear();
    
        try {
            ListeMaison.get(0);
            System.out.println("TEST : testGetMaisonArrayVide NON PASSE");
        } catch (Exception e) {
            System.out.println("TEST : testGetMaisonArrayVide PASSE");
        }
    }
    
}

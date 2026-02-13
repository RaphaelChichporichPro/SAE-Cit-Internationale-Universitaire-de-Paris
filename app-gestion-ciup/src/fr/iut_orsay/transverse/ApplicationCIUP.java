package fr.iut_orsay.transverse;

import java.util.Arrays;
import java.util.Collection;

import fr.iut_orsay.transverse.models.*;
import fr.iut_orsay.transverse.controllers.*;

public class ApplicationCIUP {
	public static void main(String[] args) {
        // Création de l'objet CIUP
        CIUP ciup = new CIUP();
        System.out.println("Cite Internationale Universitaire de Paris - SAE-1256");

        //--------------------------------------------------------------------------------------------------
        // PARTIE MAISON
        //--------------------------------------------------------------------------------------------------

        // Création et ajout de maisons
        FactoryCIUP.creerMaison("Maison du Japon", "1 rue de tokyo", 90, "Japonais", "John Doe");
        FactoryCIUP.creerMaison("Maison du Congo", "1 boulevard des capucines", 120, "Congolais", "Jane Doe");

        // Récupération des maisons créées
        Maison maison1 = ListeMaison.get(0);
        Maison maison2 = ListeMaison.get(1);

        // Affichage des maisons
        ListeMaison.afficherListeMaisons();

        // Suppression d'une maison
        ListeMaison.supprimerMaison(maison1);

        // Affichage des maisons après suppression
        ListeMaison.afficherListeMaisons();

        // Utilisation d'autres méthodes
        Maison maison3 = new Maison("Maison du Bresil", "Avenue des Champs", 100, "Bresilien", "Pedro Alves");
        ListeMaison.ajouterMaison(maison3); // Ajout d'une maison

        // Vérification de l'ajout
        ListeMaison.afficherListeMaisons();

        // Affichage des caractéristiques de la maison
        maison3.afficherCaracteristiques();

        //----------------------------------------------------------------------------------------------------
        // PARTIE ETUDIANT
        //----------------------------------------------------------------------------------------------------

        // Création d'un étudiant et ajout à la CIUP
        FactoryCIUP.creerEtudiant("Sam", "Smith", "Anglais", "1/1/1999", "sam.smith@mail.com", "011111111", true, 0, false, maison2);


        //----------------------------------------------------------------------------------------------------
        // PARTIE ALUMNI
        //----------------------------------------------------------------------------------------------------

        // Création d'un alumni et ajout à la CIUP
        Collection<Integer> anneesLogement = Arrays.asList(2010, 2011, 2012); // Exemple d'années de logement
        Alumni alumni1 = new Alumni("Jean", "Legrand", 2015, "Ingénieur logiciel", "Google", "jean.legrand@example.com", anneesLogement);
        alumni1.addAlumni();

        // Affichage des alumnis
        alumni1.afficheDescription();

        // Mise à jour des informations d'un Alumni
        alumni1.mettreAJourInfos("Developpeur Full Stack", "Apple", "jean.legrand@etu-upsaclay.com");


        // Suppression d'un événement (si nécessaire)
        // FactoryCIUP.supprimerEvenement(evenement2); // Cette ligne dépend de la gestion d'événements que tu veux avoir

        //----------------------------------------------------------------------------------------------------
        // LISTE DES ETUDIANTS
        //----------------------------------------------------------------------------------------------------


        //----------------------------------------------------------------------------------------------------
        // RESULTATS FINAUX
        //----------------------------------------------------------------------------------------------------
        
        System.out.println("\nEtat final de la Cité Internationale Universitaire de Paris :");
        
        // Affichage final des maisons
        System.out.println("\nListe des Maisons : ");
        ListeMaison.afficherListeMaisons();
        
        // Affichage final des alumnis
        System.out.println("\nListe des Alumnis : ");
        for (Alumni a : ciup.getAlumnis()) {
            a.afficheDescription();
        }


    }
}

package fr.iut_orsay.transverse.controllers;

import java.util.Date;
import java.util.Random;

import fr.iut_orsay.transverse.models.*;

public class FactoryCIUP {
	
	/**
	 * Créé une maison et l'enregistre dans la listeMaison.
	 * @param nom
	 * @param adresse
	 * @param capaciteMax
	 * @param nationalitePrincipale
	 * @param directeur
	 * @throws IllegalArgumentExceptions
	 */
	public static Maison creerMaison(String nom, String adresse, int capaciteMax, String nationalitePrincipale, String directeur) throws IllegalArgumentException {
		if(nom == null) throw new IllegalArgumentException("L'argument nom ne peut pas être nul");
		if(adresse == null) throw new IllegalArgumentException("L'argument adresse ne peut pas être nul");
		if(capaciteMax <= 0) throw new IllegalArgumentException("L'argument capaciteMax doit être strictement supérieur à 0");
		if(nationalitePrincipale == null) throw new IllegalArgumentException("L'argument nationalitePrincipale ne peut pas être nul");
		if(directeur == null) throw new IllegalArgumentException("L'argument directeur ne peut pas être nul");
		
		Maison m = new Maison(nom, adresse, capaciteMax, nationalitePrincipale, directeur);
		ListeMaison.ajouterMaison(m);
		return m;
	}
	
	 /**
     * Génère un identifiant d'étudiant aléatoire.
     * @return Un identifiant d'étudiant.
     */
    private static int generateStudentId() {
        return 10000 + new Random().nextInt(90000); // Génère un nombre entre 10000 et 99999
    }
	
	/**
	 * Créé un nouvel étudiant et le place dans la liste d'attente de la maison souhaitée
	 * - Si l'étudiant n'exprime pas de souhait, on essaie de le placer dans la maison de sa nationalité
	 * - Si la maison souhaitée est pleine, on le place dans la maison de sa nationalité ou dans une maison qui a de la place.
	 * @param nom
	 * @param prenom
	 * @param nationalite
	 * @param dateNaissance
	 * @param email
	 * @param telephone
	 * @param inscrit
	 * @param anneeEntree
	 * @param estAncienEtudiant
	 * @param maisonSouhaitee
	 * @throws IllegalArgumentException
	 */
	public static Etudiant creerEtudiant(String nom, String prenom, String nationalite, String dateNaissance, String email, String telephone, boolean inscrit, int anneeEntree, boolean estAncienEtudiant, Maison maisonSouhaitee) throws IllegalArgumentException {
		if (nom == null) throw new IllegalArgumentException("L'argument nom ne peut pas être nul");
		if (nationalite == null) throw new IllegalArgumentException("L'argument nationalite ne peut pas être nul");
		if (dateNaissance == null) throw new IllegalArgumentException("L'argument dateNaissance ne peut pas être nul");
		if (email == null) throw new IllegalArgumentException("L'argument email ne peut pas être nul");
		
		
		int numEtudiant = generateStudentId();
		
		if (maisonSouhaitee == null) {
			for (Maison m: ListeMaison.getListeMaisons()) {
				if (!m.estPleine()) {
					maisonSouhaitee = m;
					break;
				}
			}
		}
		
		if (maisonSouhaitee.estPleine()) {
			for (Maison m: ListeMaison.getListeMaisons()) {
				if (!m.estPleine()) {
					maisonSouhaitee = m;
					break;
				}
			}
		}
		
		
		Date dateInscription = new Date();
		Etudiant etud = new Etudiant(nom, prenom, nationalite, dateNaissance, email, telephone, null, numEtudiant, inscrit, anneeEntree, estAncienEtudiant, maisonSouhaitee, dateInscription.toLocaleString());
		maisonSouhaitee.inscrireEtudiant(etud);
		return etud;
	}
	
	
}

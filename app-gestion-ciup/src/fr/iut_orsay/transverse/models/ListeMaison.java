package fr.iut_orsay.transverse.models;

import java.util.*;

public class ListeMaison {

	private static 	ArrayList<Maison> lesMaisons = new ArrayList<Maison>();

	/**
	 * 
	 * @param maison
	 * @return L'indice de la maison ajoutÃ©e
	 */
	public static int ajouterMaison(Maison maison) {
		lesMaisons.add(maison);
		return lesMaisons.size() - 1;
	}

	/**
	 * Supprime la maison donnÃ©e de la liste
	 * @param index
	 * @throws Renvoie une erreur si la maison n'est pas trouvÃ©e.
	 */
	public static void supprimerMaison(int index) throws IllegalArgumentException {
		if(!lesMaisons.contains(lesMaisons.get(index))) {
			throw new IllegalArgumentException("Il n'existe aucune maison A  l'index " + index);
		}
		lesMaisons.remove(index);
	}
	
	/**
	 * Supprime la maison donnÃ©e de la liste
	 * @param maison
	 * @throws Renvoie une erreur si la maison n'est pas trouvÃ©e.
	 */
	public static void supprimerMaison(Maison m) throws IllegalArgumentException {
		int index = -1;
		int counter = 0;
		for(Maison ma : lesMaisons) {
			if(ma == m) {
				index = counter;
				break;
			}
			counter ++;
		}
		if (index == -1) throw new IllegalArgumentException("La maison " + m.getNom() + " n'existe pas dans la liste");
		supprimerMaison(index);
	}


	/**
	 * RÃ©cupÃ¨re une maison en fonction de son index
	 * @param index
	 */
	public static Maison get(int index) throws IndexOutOfBoundsException {
		return lesMaisons.get(index);
	}

	public static void afficherListeMaisons() {
		System.out.println("La liste des maisons de la CIUP:");
		for(Maison m: lesMaisons) {
			System.out.println("- " + m.getNom() + " | " + m.getAdresse() + " | " + m.getListeEtudiant().size() + "/" + m.getCapaciteMax());
		}
		
	}
	
	/**
	 * 
	 * @return la liste des maisons
	 */
	public static ArrayList<Maison> getListeMaisons() {
		return lesMaisons;
	}

}
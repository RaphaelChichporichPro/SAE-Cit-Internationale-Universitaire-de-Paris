package fr.iut_orsay.transversetest;

import fr.iut_orsay.transverse.*;
import fr.iut_orsay.transverse.models.Etudiant;
import fr.iut_orsay.transverse.models.Maison;

public class MaisonTest {
	
	private Maison m;
	
	private void setup() {
		m = new Maison("Testing house", "1600, Pennsylvania Avenue NW, Washington D.C", 2, "Deutsch", "John Doe");
	}
	
    // TODO Inscrire etudiant: maison pas pleine ajouté à la liste, maison pleine ajouté à la liste d'attente (queue)
    
    public void inscrireEtudiant_notFullHouse_studentAddedToList() {
    	this.setup();
        Etudiant e1 = new Etudiant("Doe", "Jane", "Irelandaise", "13/01/2006", "jane.doe@mail.net", "0123456789", m, 12, true, 2001, false, m, "12/01/2020");
        m.inscrireEtudiant(e1);
        assert (this.m.getListeEtudiant().contains(e1)) : "Test inscrireEtudiant_notFullHouse_studentAddedToList Failed";
        System.out.println("Test inscrireEtudiant_notFullHouse_studentAddedToList Passed");
    }


    public void inscrireEtudiant_fullHouse_studentAddedToQueue() {
    	this.setup();
        Etudiant e1 = new Etudiant("Doe", "Jane", "Française", "13/01/2006", "jane.doe@mail.net", "0123456789", m, 12, true, 2001, false, m, "12/01/2020");
        Etudiant e2 = new Etudiant("Doe", "John Jr.", "Americain", "13/01/2006", "johnjr.doe@mail.net", "0987654321", m, 12, true, 2001, false, m, "12/01/2020");
        Etudiant e3 = new Etudiant("Doe", "Johana", "Canadienne", "13/01/2006", "johanna.doe@mail.net", "0918273645", m, 12, true, 2001, false, m, "12/01/2020");
        
        m.inscrireEtudiant(e1);
        m.inscrireEtudiant(e2);
        m.inscrireEtudiant(e3);
        assert (this.m.getListeAttente().contains(e3)) : "Test inscrireEtudiant_fullHouse_studentAddedToQueue Failed";
        System.out.println("Test inscrireEtudiant_fullHouse_studentAddedToQueue Passed");
        
    }


    // TODO Supprimer etudiant: maison contenant des étudiants expected, maison vide renvoie erreur

    public void supprimerEtudiant_notEmptyHouse_studentRemoved(){
    	this.setup();
        Etudiant e1 = new Etudiant("Doe", "Jane", "Française", "13/01/2006", "jane.doe@mail.net", "0123456789", m, 12, true, 2001, false, m, "12/01/2020");
        Etudiant e2 = new Etudiant("Doe", "John Jr.", "Americain", "13/01/2006", "johnjr.doe@mail.net", "0987654321", m, 12, true, 2001, false, m, "12/01/2020");
        m.inscrireEtudiant(e1);
        m.inscrireEtudiant(e2);
        
        m.supprimerEtudiant(e1);       
        assert (!m.getListeEtudiant().contains(e1)) : "Test supprimerEtudiant_notEmptyHouse_studentRemoved Failed";
        System.out.println("Test supprimerEtudiant_notEmptyHouse_studentRemoved Passed");
    }

    public void supprimerEtudiant_emptyHouse_throwsError(){
        this.setup();
        Etudiant e1 = new Etudiant("Doe", "Jane", "Française", "13/01/2006", "jane.doe@mail.net", "0123456789", m, 12, true, 2001, false, m, "12/01/2020");
        try {
        	m.supprimerEtudiant(e1);
        	assert (false) : "Test supprimerEtudiant_emptyHouse_throwsError Failed";
        } catch (IllegalArgumentException e) {
        	System.out.println("Test supprimerEtudiant_emptyHouse_throwsError Passed");
        }
    }
    
    public void supprimerEtudiant_fullHouse_registersNextStudentInQueue() {
    	this.setup();
        Etudiant e1 = new Etudiant("Doe", "Jane", "Française", "13/01/2006", "jane.doe@mail.net", "0123456789", m, 12, true, 2001, false, m, "12/01/2020");
        Etudiant e2 = new Etudiant("Doe", "John Jr.", "Americain", "13/01/2006", "johnjr.doe@mail.net", "0987654321", m, 12, true, 2001, false, m, "12/01/2020");
        Etudiant e3 = new Etudiant("Doe", "Johana", "Canadienne", "13/01/2006", "johanna.doe@mail.net", "0918273645", m, 12, true, 2001, false, m, "12/01/2020");
        
        m.inscrireEtudiant(e1);
        m.inscrireEtudiant(e2);
        m.inscrireEtudiant(e3);
        
        m.supprimerEtudiant(e2);
        
        assert(m.getListeEtudiant().contains(e3)) : "Test supprimerEtudiant_fullHouse_registersNextStudentInQueue Failed";
        System.out.println("Test supprimerEtudiant_fullHouse_registersNextStudentInQueue Passed");
    }
}

package fr.iut_orsay.transverse.models;

import java.util.*;

import fr.iut_orsay.transverse.controllers.FactoryCIUP;

public class CIUP {

    // Collections pour les alumnis et les maisons
    private Collection<Alumni> lesAlumnis;
    private MaisonInternationale maisonInternationale;

    // Constructeur
    public CIUP() {
        this.lesAlumnis = new ArrayList<>();
        this.maisonInternationale = new MaisonInternationale("Adresse de la maison internationale");
    }
    
    public Collection<Alumni> getAlumnis() {
    	return lesAlumnis;
    }
    
}

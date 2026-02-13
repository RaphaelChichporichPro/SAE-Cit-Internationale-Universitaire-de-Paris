package fr.iut_orsay.transverse.models;

public class Evenement {

	private String nom;
	private String dateHeure;
	private String description;
	private Maison maisonOrganisatrice;
	private String lieu;
	private String type;
	
	public Evenement(String nom, String dateHeure, String description, Maison maisonOrganisatrice, String lieu, String type) {
		this.nom = nom;
		this.dateHeure = dateHeure;
		this.description = description;
		this.maisonOrganisatrice = maisonOrganisatrice;
		this.lieu = lieu;
		this.type = type;
	}

	public String getNom() {
		return this.nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateHeure() {
		return this.dateHeure;
	}

	/**
	 * 
	 * @param dateHeure
	 */
	public void setDateHeure(String dateHeure) {
		this.dateHeure = dateHeure;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Maison getMaisonOrganisatrice() {
		return this.maisonOrganisatrice;
	}

	/**
	 * 
	 * @param maisonOrganisatrice
	 */
	public void setMaisonOrganisatrice(Maison maisonOrganisatrice) {
		this.maisonOrganisatrice = maisonOrganisatrice;
	}

	public String getLieu() {
		return this.lieu;
	}

	/**
	 * 
	 * @param lieu
	 */
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

}
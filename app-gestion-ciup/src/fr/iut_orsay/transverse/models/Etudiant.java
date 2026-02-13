package fr.iut_orsay.transverse.models;

public class Etudiant {

	Maison maison;
	private String nom;
	private String prenom;
	private String nationnalite;
	private String dateNaissance;
	private String email;
	private String telephone;
	private Maison maisonActuelle;
	private int numEtudiant;
	private boolean inscrit;
	private int anneeEntree;
	private boolean estAncienEtudiant;
	private Maison maisonSouhaitee;
	private String dateInscription;
	
	public Etudiant(String nom, String prenom, String nationnalite, String dateNaissance, String email, String telephone, Maison maisonActuelle, int numEtudiant, boolean inscrit, int anneeEntree, boolean estAncienEtudiant, Maison maisonSouhaitee, String dateInscription){
		this.nom = nom;
		this.prenom = prenom;
		this.nationnalite = nationnalite;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.telephone = telephone;
		this.maisonActuelle = maisonActuelle;
		this.numEtudiant = numEtudiant;
		this.inscrit = inscrit;
		this.anneeEntree = anneeEntree;
		this.estAncienEtudiant = estAncienEtudiant;
		this.maisonSouhaitee = maisonSouhaitee;
		this.dateInscription = dateInscription;
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

	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationnalite() {
		return this.nationnalite;
	}

	/**
	 * 
	 * @param nationnalite
	 */
	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	public String getDateNaissance() {
		return this.dateNaissance;
	}

	/**
	 * 
	 * @param dateNaissance
	 */
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Maison getMaisonActuelle() {
		return this.maisonActuelle;
	}

	/**
	 * 
	 * @param maisonActuelle
	 */
	public void setMaisonActuelle(Maison maisonActuelle) {
		this.maisonActuelle = maisonActuelle;
	}

	public int getNumEtudiant() {
		return this.numEtudiant;
	}

	/**
	 * 
	 * @param numEtudiant
	 */
	public void setNumEtudiant(int numEtudiant) {
		this.numEtudiant = numEtudiant;
	}

	public boolean getInscrit() {
		return this.inscrit;
	}

	/**
	 * 
	 * @param inscrit
	 */
	public void setInscrit(boolean inscrit) {
		this.inscrit = inscrit;
	}

	public int getAnneeEntree() {
		return this.anneeEntree;
	}

	/**
	 * 
	 * @param anneeEntree
	 */
	public void setAnneeEntree(int anneeEntree) {
		this.anneeEntree = anneeEntree;
	}

	public boolean getEstAncienEtudiant() {
		return this.estAncienEtudiant;
	}

	/**
	 * 
	 * @param estAncienEtudiant
	 */
	public void setEstAncienEtudiant(boolean estAncienEtudiant) {
		this.estAncienEtudiant = estAncienEtudiant;
	}

	public Maison getMaisonSouhaitee() {
		return this.maisonSouhaitee;
	}

	/**
	 * 
	 * @param maisonSouhaitee
	 */
	public void setMaisonSouhaitee(Maison maisonSouhaitee) {
		this.maisonSouhaitee = maisonSouhaitee;
	}

	public String getDateInscription() {
		return this.dateInscription;
	}

	/**
	 * 
	 * @param dateInscription
	 */
	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}

}
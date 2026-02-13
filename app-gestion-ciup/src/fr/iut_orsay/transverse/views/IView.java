package fr.iut_orsay.transverse.views;

/**
 * Interface pour les vues de l'application.
 * Définit les méthodes communes à toutes les vues.
 * 
 * @author Votre_Nom
 * @version 1.0
 */
public interface IView {
    
    /**
     * Initialise les composants graphiques de la vue.
     */
    void initComponents();
    
    /**
     * Met à jour l'affichage de la vue avec les données actuelles du modèle.
     */
    void updateView();
    
    /**
     * Ferme la vue actuelle.
     */
    void closeView();
}
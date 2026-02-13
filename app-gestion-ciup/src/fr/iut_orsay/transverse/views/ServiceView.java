package fr.iut_orsay.transverse.views;

import fr.iut_orsay.transverse.controllers.ServiceController;
import fr.iut_orsay.transverse.models.CIUP;
import fr.iut_orsay.transverse.models.MaisonInternationale;
import fr.iut_orsay.transverse.models.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Vue de la page Service.
 * Affiche la liste des services et permet de les gérer.
 * 
 * @author Votre_Nom
 * @version 1.0
 */
public class ServiceView extends JFrame implements IView, Observer {
    
    //-----------------------------------------------------------------------
    // ATTRIBUTS
    //-----------------------------------------------------------------------
    
    /** Couleur principale de l'application */
    public static final Color TEAL_COLOR = new Color(20, 184, 165);
    
    /** Couleur gris clair pour les bordures et fonds */
    public static final Color LIGHT_GRAY = new Color(236, 240, 243);
    
    /** Couleur gris moyen pour les textes secondaires */
    public static final Color MEDIUM_GRAY = new Color(115, 115, 115);
    
    /** Panneau principal de la vue */
    private JPanel mainPanel;
    
    /** Tableau des services */
    private JTable serviceTable;
    
    /** Modèle de données du tableau */
    private DefaultTableModel tableModel;
    
    /** Champ de recherche */
    private JTextField searchField;
    
    /** Bouton de recherche */
    private JButton searchButton;
    
    /** Bouton d'ajout d'un service */
    private JButton addButton;
    
    /** Bouton de modification d'un service */
    private JButton editButton;
    
    /** Bouton de suppression d'un service */
    private JButton deleteButton;
    
    /** Bouton pour réserver un service */
    private JButton reserveButton;
    
    /** Bouton pour voir les réservations d'un service */
    private JButton viewReservationsButton;
    
    /** Bouton de retour à l'accueil */
    private JButton backButton;
    
    /** Modèle CIUP */
    private CIUP ciup;
    
    /** Contrôleur gérant les interactions utilisateur */
    private ServiceController controller;
    
    //-----------------------------------------------------------------------
    // CONSTRUCTEUR
    //-----------------------------------------------------------------------
    
    /**
     * Constructeur de la vue des services.
     * 
     * @param ciup Le modèle CIUP
     */
    public ServiceView(CIUP ciup) {
        this.ciup = ciup;
        
        // Initialisation du contrôleur
        controller = new ServiceController(this, ciup);
        
        // Configuration de la fenêtre
        setTitle("CIUP Admin - Services");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        
        // Initialisation des composants
        initComponents();
        
        // Affichage de la fenêtre
        setVisible(true);
    }
    
    //-----------------------------------------------------------------------
    // MÉTHODES
    //-----------------------------------------------------------------------
    
    /**
     * Initialise les composants graphiques de la vue.
     * Implémentation de la méthode de l'interface IView.
     */
    @Override
    public void initComponents() {
        // Création du panneau principal
        mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // En-tête
        JPanel headerPanel = createHeaderPanel();
        
        // Panneau de recherche
        JPanel searchPanel = createSearchPanel();
        
        // Panneau central avec le tableau des services
        JPanel centerPanel = createCenterPanel();
        
        // Panneau des boutons d'action
        JPanel actionPanel = createActionPanel();
        
        // Panneau de navigation
        JPanel navigationPanel = createNavigationPanel();
        
        // Ajout des panneaux au panneau principal
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Panneau central qui contient la recherche et le tableau
        JPanel contentPanel = new JPanel(new BorderLayout(0, 20));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.add(searchPanel, BorderLayout.NORTH);
        contentPanel.add(centerPanel, BorderLayout.CENTER);
        contentPanel.add(actionPanel, BorderLayout.SOUTH);
        
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(navigationPanel, BorderLayout.SOUTH);
        
        // Ajout du panneau principal à la fenêtre
        add(mainPanel);
        
        // Chargement initial des données
        updateView();
    }
    
    /**
     * Crée le panneau d'en-tête avec le titre et le sous-titre.
     * 
     * @return Le panneau d'en-tête créé
     */
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Color.WHITE);
        
        JLabel titleLabel = new JLabel("Services");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel subtitleLabel = new JLabel("Gestion des services de la Cité Internationale Universitaire de Paris");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitleLabel.setForeground(MEDIUM_GRAY);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(subtitleLabel);
        headerPanel.add(Box.createVerticalStrut(20));
        
        return headerPanel;
    }
    
    /**
     * Crée le panneau de recherche.
     * 
     * @return Le panneau de recherche créé
     */
    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel(new BorderLayout(10, 0));
        searchPanel.setBackground(Color.WHITE);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        // Panneau de gauche avec le label de recherche
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(Color.WHITE);
        
        JLabel searchLabel = new JLabel("Rechercher un service:");
        searchLabel.setFont(new Font("Arial", Font.BOLD, 14));
        leftPanel.add(searchLabel);
        
        // Panneau central avec le champ de recherche
        searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Panneau de droite avec le bouton de recherche
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(Color.WHITE);
        
        searchButton = new JButton("Rechercher");
        searchButton.setBackground(TEAL_COLOR);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setActionCommand("search");
        searchButton.addActionListener(controller);
        
        rightPanel.add(searchButton);
        
        // Ajout des panneaux au panneau de recherche
        searchPanel.add(leftPanel, BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(rightPanel, BorderLayout.EAST);
        
        return searchPanel;
    }
    
    /**
     * Crée le panneau central avec le tableau des services.
     * 
     * @return Le panneau central créé
     */
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        
        // Création du modèle de tableau
        String[] columnNames = {"Nom", "Horaires", "Lieu", "Détails spécifiques", "Nombre de réservations"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Rend toutes les cellules non éditables
            }
        };
        
        // Création du tableau
        serviceTable = new JTable(tableModel);
        serviceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        serviceTable.getTableHeader().setReorderingAllowed(false);
        serviceTable.setRowHeight(25);
        serviceTable.setFont(new Font("Arial", Font.PLAIN, 14));
        serviceTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        
        // Ajout du tableau à un JScrollPane
        JScrollPane scrollPane = new JScrollPane(serviceTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(LIGHT_GRAY));
        
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        
        return centerPanel;
    }
    
    /**
     * Crée le panneau des boutons d'action.
     * 
     * @return Le panneau des boutons d'action créé
     */
    private JPanel createActionPanel() {
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actionPanel.setBackground(Color.WHITE);
        
        reserveButton = new JButton("Réserver");
        reserveButton.setBackground(TEAL_COLOR);
        reserveButton.setForeground(Color.WHITE);
        reserveButton.setFocusPainted(false);
        reserveButton.setActionCommand("reserve");
        reserveButton.addActionListener(controller);
        
        viewReservationsButton = new JButton("Voir les réservations");
        viewReservationsButton.setBackground(TEAL_COLOR);
        viewReservationsButton.setForeground(Color.WHITE);
        viewReservationsButton.setFocusPainted(false);
        viewReservationsButton.setActionCommand("viewReservations");
        viewReservationsButton.addActionListener(controller);
        
        addButton = new JButton("Ajouter");
        addButton.setBackground(TEAL_COLOR);
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setActionCommand("add");
        addButton.addActionListener(controller);
        
        editButton = new JButton("Modifier");
        editButton.setBackground(TEAL_COLOR);
        editButton.setForeground(Color.WHITE);
        editButton.setFocusPainted(false);
        editButton.setActionCommand("edit");
        editButton.addActionListener(controller);
        
        deleteButton = new JButton("Supprimer");
        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(controller);
        
        actionPanel.add(reserveButton);
        actionPanel.add(Box.createHorizontalStrut(10));
        actionPanel.add(viewReservationsButton);
        actionPanel.add(Box.createHorizontalStrut(10));
        actionPanel.add(addButton);
        actionPanel.add(Box.createHorizontalStrut(10));
        actionPanel.add(editButton);
        actionPanel.add(Box.createHorizontalStrut(10));
        actionPanel.add(deleteButton);
        
        return actionPanel;
    }
    
    /**
     * Crée le panneau de navigation avec le bouton de retour.
     * 
     * @return Le panneau de navigation créé
     */
    private JPanel createNavigationPanel() {
        JPanel navigationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        navigationPanel.setBackground(Color.WHITE);
        
        backButton = new JButton("Retour à l'accueil");
        backButton.setBackground(TEAL_COLOR);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setActionCommand("back");
        backButton.addActionListener(controller);
        
        navigationPanel.add(backButton);
        
        return navigationPanel;
    }
    
    /**
     * Met à jour l'affichage de la vue avec les données actuelles du modèle.
     * Implémentation de la méthode de l'interface IView.
     */
    @Override
    public void updateView() {
        // Effacer le tableau
        tableModel.setRowCount(0);
        
        // Récupérer la liste des services
        MaisonInternationale maisonInternationale = ciup.getMaisonInternationale();
        Service[] services = maisonInternationale.getListeServices();
        
        // Filtrer par texte de recherche si nécessaire
        String searchText = searchField.getText().toLowerCase();
        
        // Remplir le tableau avec les données des services
        for (Service service : services) {
            // Filtrer par texte de recherche si nécessaire
            if (!searchText.isEmpty()) {
                if (!service.getNom().toLowerCase().contains(searchText) &&
                    !service.getLieu().toLowerCase().contains(searchText)) {
                    continue;
                }
            }
            
            Object[] rowData = {
                service.getNom(),
                service.getHoraires(),
                service.getLieu(),
                service.getDetailsSpecifique(),
                service.getReservations().size()
            };
            tableModel.addRow(rowData);
        }
    }
    
    /**
     * Ferme la vue actuelle.
     * Implémentation de la méthode de l'interface IView.
     */
    @Override
    public void closeView() {
        dispose();
    }
    
    /**
     * Met à jour la vue lorsque le modèle observé change.
     * Implémentation de la méthode de l'interface Observer.
     * 
     * @param o L'objet Observable qui a changé
     * @param arg Un argument optionnel passé par l'Observable
     */
    @Override
    public void update(Observable o, Object arg) {
        updateView();
    }
    
    /**
     * Affiche une boîte de dialogue pour ajouter ou modifier un service.
     * 
     * @param service Le service à modifier, ou null pour un nouveau service
     * @return Le service créé ou modifié, ou null si l'opération est annulée
     */
    public Service showServiceDialog(Service service) {
        // Création des champs de saisie
        JTextField nomField = new JTextField(service != null ? service.getNom() : "");
        JTextField horairesField = new JTextField(service != null ? service.getHoraires() : "");
        JTextField lieuField = new JTextField(service != null ? service.getLieu() : "");
        JTextField detailsField = new JTextField(service != null ? service.getDetailsSpecifique() : "");
        
        // Création du panneau avec les champs
        Object[] message = {
            "Nom:", nomField,
            "Horaires:", horairesField,
            "Lieu:", lieuField,
            "Détails spécifiques:", detailsField
        };
        
        // Titre de la boîte de dialogue
        String title = service != null ? "Modifier un service" : "Ajouter un service";
        
        // Affichage de la boîte de dialogue
        int option = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            // Récupération des valeurs saisies
            String nom = nomField.getText();
            String horaires = horairesField.getText();
            String lieu = lieuField.getText();
            String details = detailsField.getText();
            
            // Vérification que les champs obligatoires sont remplis
            if (nom.isEmpty() || horaires.isEmpty() || lieu.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Les champs Nom, Horaires et Lieu sont obligatoires.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
            // Création ou mise à jour du service
            Service newService = new Service(nom, horaires, lieu, details);
            
            // Si c'est une modification, copier les réservations existantes
            if (service != null) {
                for (String reservation : service.getReservations()) {
                    newService.reserverServices(reservation);
                }
            }
            
            return newService;
        }
        
        return null;
    }
    
    /**
     * Affiche une boîte de dialogue pour réserver un service.
     * 
     * @param service Le service à réserver
     * @return true si la réservation a été effectuée, false sinon
     */
    public boolean showReservationDialog(Service service) {
        // Création des champs de saisie
        JTextField detailsField = new JTextField();
        
        // Création du panneau avec les champs
        Object[] message = {
            "Détails de la réservation:", detailsField
        };
        
        // Affichage de la boîte de dialogue
        int option = JOptionPane.showConfirmDialog(this, message, "Réserver le service " + service.getNom(), JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            // Récupération des valeurs saisies
            String details = detailsField.getText();
            
            // Vérification que les champs obligatoires sont remplis
            if (details.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Veuillez saisir les détails de la réservation.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            // Effectuer la réservation
            return service.reserverServices(details);
        }
        
        return false;
    }
    
    /**
     * Affiche une boîte de dialogue avec la liste des réservations d'un service.
     * 
     * @param service Le service dont on veut voir les réservations
     */
    public void showReservationsDialog(Service service) {
        // Création du modèle de tableau pour les réservations
        String[] columnNames = {"ID", "Détails"};
        DefaultTableModel reservationsModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Rend toutes les cellules non éditables
            }
        };
        
        // Remplir le tableau avec les données des réservations
        java.util.ArrayList<String> reservations = service.getReservations();
        for (int i = 0; i < reservations.size(); i++) {
            Object[] rowData = {
                i + 1,
                reservations.get(i)
            };
            reservationsModel.addRow(rowData);
        }
        
        // Création du tableau
        JTable reservationsTable = new JTable(reservationsModel);
        reservationsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        reservationsTable.getTableHeader().setReorderingAllowed(false);
        reservationsTable.setRowHeight(25);
        reservationsTable.setFont(new Font("Arial", Font.PLAIN, 14));
        reservationsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        
        // Ajout du tableau à un JScrollPane
        JScrollPane scrollPane = new JScrollPane(reservationsTable);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        
        // Affichage de la boîte de dialogue
        JOptionPane.showMessageDialog(this,
            scrollPane,
            "Réservations du service " + service.getNom(),
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    //-----------------------------------------------------------------------
    // ACCESSEURS
    //-----------------------------------------------------------------------
    
    /**
     * Retourne le tableau des services.
     * 
     * @return Le tableau des services
     */
    public JTable getServiceTable() {
        return serviceTable;
    }
    
    /**
     * Retourne le modèle de données du tableau.
     * 
     * @return Le modèle de données du tableau
     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    /**
     * Retourne le champ de recherche.
     * 
     * @return Le champ de recherche
     */
    public JTextField getSearchField() {
        return searchField;
    }
    
    /**
     * Retourne le modèle CIUP.
     * 
     * @return Le modèle CIUP
     */
    public CIUP getCiup() {
        return ciup;
    }
}